package Palya;

import Game.Game;
import Karakter.*;
import Szoba.*;
import Targy.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Palya {
    private static final String FILE_PATH = "projlab_pupakok/src/Data/";
    public ArrayList<Oktato> getOktatok() {
        return oktatok;
    }

    public ArrayList<Szoba> getSzobak() {
        return szobak;
    }

    public ArrayList<Takarito> getTakaritok() {
        return takaritok;
    }

    /**
     * A játékban lévő hallgatók
     */
    protected ArrayList<Hallgato> hallgatok;
    /**
     * A játékban lévő oktatok
     */
    protected ArrayList<Oktato> oktatok;

    /**
     * A játékban lévő szobák
     */
    protected ArrayList<Szoba> szobak;

    /**
     * A játékban lévő takarítók
     */
    protected ArrayList<Takarito> takaritok;

    Game game;

    public void setToggle_random(boolean toggle_random) {
        this.toggle_random = toggle_random;
    }

    boolean toggle_random = true;

    /**
     * Konstruktor
     */
    public Palya() {
        hallgatok = new ArrayList<>();
        oktatok = new ArrayList<>();
        szobak = new ArrayList<>();
        takaritok = new ArrayList<Takarito>();
    }

    /**
     * Konstruktor
     *
     * @param g a game amihez a pálya tartozik
     */
    public Palya(Game g) {
        hallgatok = new ArrayList<Hallgato>();
        oktatok = new ArrayList<Oktato>();
        szobak = new ArrayList<Szoba>();
        takaritok = new ArrayList<Takarito>();
        game = g;
    }

    /**
     * A szobákat előre megterveztük
     * és ezeket létrehozza a hallgatókkal, oktatókkal és tárgyakkal együtt.
     */
    public void general(int jatekosokszama) {

        // Szobak hozzaadasa
        File f = new File(FILE_PATH + "Szoba_attributumok.txt");
        File attr = new File(f.getAbsolutePath());

        try {
            FileInputStream fis = new FileInputStream(attr);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                String id = attributes[1];
                boolean gaz = Boolean.parseBoolean(attributes[2]);
                int ferohely = Integer.parseInt(attributes[3]);
                if (attributes[0].equals("false")) {
                    new Szoba(id, gaz, ferohely, this);
                } else
                    new ElatkozottSzoba(id, gaz, ferohely, this);
            }
            br.close();
        } catch (Exception e) {
        }

        f = new File(FILE_PATH + "Szoba_szomszedok.txt");
        File szomsz = new File(f.getAbsolutePath());

        try {
            FileInputStream fis = new FileInputStream(szomsz);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            int sz = 0;
            while ((line = br.readLine()) != null) {
                String[] szomszedok = line.split(",");
                for (int i = 0; i < szomszedok.length; i++) {
                    for (Szoba szoba : szobak) {
                        if (szoba.getid().equals(szomszedok[i]))
                            szobak.get(sz).addSzomszed(szoba);
                    }
                }
                sz++;
            }
            br.close();
        } catch (Exception e) {
        }

        Random rand = new Random();
        int input;
        // hallgatók felvétele
        if (toggle_random) {
            input = jatekosokszama;
            if (input == 10)
                hallgatok.add(new Hallgato(szobak.get(rand.nextInt(10)), String.valueOf(hallgatok.size())));
            else {
                for (int i = 0; i < input; i++) {
                    hallgatok.add(new Hallgato(szobak.get(rand.nextInt(10)), String.valueOf(hallgatok.size())));
                }
            }
        } else {
            hallgatok.add(new Hallgato(szobak.get(0), String.valueOf(hallgatok.size())));
        }

        // oktatók felvétele
        for (int i = 0; i < Math.ceil((double) hallgatok.size() / 3); i++) {
            if (szobak.get(42).getBefogadokepesseg() > oktatok.size())
                oktatok.add(new Oktato(szobak.get(42), String.valueOf(oktatok.size())));
        }

        // Takarito hozzaadasa
        takaritok.add(new Takarito(szobak.get(25), String.valueOf(oktatok.size())));

        int id_distributor = 0;
        for (Szoba sz : szobak) {
            for (int i = 0; i < 5; i++) {

                switch (rand.nextInt(1, 8)) {
                    case 1:
                        new Tranzisztor(sz, String.valueOf(id_distributor));
                        break;
                    case 2:
                        new Sorospohar(sz, String.valueOf(id_distributor));
                        break;
                    case 3:
                        new Rongy(sz, String.valueOf(id_distributor));
                        break;
                    case 4:
                        new Maszk(sz, String.valueOf(id_distributor));
                        break;
                    case 5:
                        new Camembert(sz, String.valueOf(id_distributor));
                        break;
                    case 6:
                        new Logarlec(Funkcio.hamis, sz, String.valueOf(id_distributor));
                        break;
                    case 7:
                        new Legfrissito(sz, String.valueOf(id_distributor));
                        break;
                    default:
                        new TVSZ(sz, String.valueOf(id_distributor));
                        break;

                }
                id_distributor++;
            }
        }

        Logarlec logarlec = new Logarlec(Funkcio.logarlec, szobak.get(12), "igazilogarlec");
        logarlec.addPropertyChangeListener(new LogarlecPropertyChangeListener(game));
    }

    /**
     * Meghívja az oktatók mozog függvényét egy szomszédos szobába
     */
    public void leptet() {
        Random rand = new Random();

        // lépés az oktatóval
        if (toggle_random) {
            for (Oktato oktato : oktatok) {
                if (!oktato.getEszmeletvesztett()) {
                    Szoba szoba = oktato.getSzoba();
                    ArrayList<Szoba> szomszedok = szoba.getSzomszedok();
                    if (szomszedok.isEmpty()) {
                        int randomIndex = rand.nextInt(szomszedok.size());
                        Szoba randomSzoba = szomszedok.get(randomIndex);
                        oktato.mozog(randomSzoba);
                    }
                }
            }
        } else {
            for (Oktato oktato : oktatok) {
                if (!oktato.getEszmeletvesztett()) {
                    Szoba szoba = oktato.getSzoba();
                    ArrayList<Szoba> szomszedok = szoba.getSzomszedok();
                    Szoba randomSzoba = szomszedok.get(0);
                    oktato.mozog(randomSzoba);
                }
            }
        }

        for (Oktato oktato : oktatok) {
            if (!oktato.getSzoba().getTargyak().isEmpty()) {
                oktato.felvesz(oktato.getSzoba().getTargyak().get(0));
            }
        }

        // lépés a takarítóval
        if (toggle_random) {
            for (Takarito takarito : takaritok) {

                Szoba szoba = takarito.getSzoba();
                ArrayList<Szoba> szomszedok = szoba.getSzomszedok();
                int randomIndex = rand.nextInt(szomszedok.size());
                Szoba randomSzoba = szomszedok.get(randomIndex);
                takarito.mozog(randomSzoba);

            }
        } else {
            for (Takarito takarito : takaritok) {

                Szoba szoba = takarito.getSzoba();
                ArrayList<Szoba> szomszedok = szoba.getSzomszedok();
                Szoba randomSzoba = szomszedok.get(0);
                takarito.mozog(randomSzoba);

            }
        }
        // Szobák osztódása
        if (toggle_random) {
            for (int i = 0; i < 3; i++) {
                int randszoba = rand.nextInt(szobak.size());
                szobak.get(randszoba).osztodik();
            }
        } else {
            for (int i = 0; i < 3; i++) {
                szobak.get(i).osztodik();
            }
        }

        // Szobák egyesülése
        if (toggle_random) {
            for (int i = 0; i < 7; i++) {
                int randszoba = rand.nextInt(szobak.size());
                int randszoba2 = rand.nextInt(szobak.size());
                while (randszoba == randszoba2) {
                    randszoba2 = rand.nextInt(szobak.size());
                }
                szobak.get(randszoba).egyesul(szobak.get(randszoba2));
            }
        } else {
            for (int i = 0; i < 7; i++) {
                szobak.get(i).egyesul(szobak.get(i + 1));
            }
        }

        // Ajtok eltunese
        if (toggle_random) {
            for (Szoba szoba : szobak) {
                if (szoba instanceof ElatkozottSzoba)
                    ((ElatkozottSzoba) szoba)
                            .eltunik(szoba.getSzomszedok().get(rand.nextInt(szoba.getSzomszedok().size())));
            }
        } else {
            for (Szoba szoba : szobak) {
                if (szoba instanceof ElatkozottSzoba && !szoba.getSzomszedok().isEmpty())
                    ((ElatkozottSzoba) szoba).eltunik(szoba.getSzomszedok().get(0));
            }
        }

        // Ajtok elotuntetese
        if (toggle_random) {
            for (Szoba szoba : szobak) {
                if (szoba instanceof ElatkozottSzoba)
                    ((ElatkozottSzoba) szoba).elotunik(((ElatkozottSzoba) szoba).getEltuntajto()
                            .get(rand.nextInt(((ElatkozottSzoba) szoba).getEltuntajto().size())));
            }
        } else {
            for (Szoba szoba : szobak) {
                if (szoba instanceof ElatkozottSzoba && !szoba.getSzomszedok().isEmpty())
                    ((ElatkozottSzoba) szoba).elotunik(((ElatkozottSzoba) szoba).getEltuntajto().get(0));
            }
        }
    }

    /**
     * Hallgató hozzáadása a pályához
     */
    public void addHallgato(Hallgato h) {
        hallgatok.add(h);
    }

    /**
     * Hallgató eltávolítása a pályából
     */
    public void removeHallgato(Hallgato h) {
        hallgatok.remove(h);
    }

    /**
     * Oktató hozzáadása a pályához
     */
    public void addOktato(Oktato o) {
        oktatok.add(o);
    }

    /**
     * Oktató eltávolítása a pályából
     */
    public void removeOktato(Oktato o) {
        oktatok.remove(o);
    }

    /**
     * Szoba hozzáadása a pályához
     */
    public void addSzoba(Szoba sz) {
        szobak.add(sz);
    }

    /**
     * Szoba eltávolítása a pályához
     */
    public void removeSzoba(Szoba sz) {
        szobak.remove(sz);
    }

    /**
     * Getter a hallgatók listájára a pályán
     */
    public ArrayList<Hallgato> getHallgatok() {
        return hallgatok;
    }

    /**
     * Getter a game attribútumra
     */
    public Game getGame() {
        return game;
    }
}
