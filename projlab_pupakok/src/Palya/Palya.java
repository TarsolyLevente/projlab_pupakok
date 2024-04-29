package Palya;

import Game.Game;
import Karakter.*;
import Szoba.*;
import Targy.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Palya {
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
    public void general() {

        // Szobak hozzaadasa
        try {
            File attr = new File("projlab_pupakok/src/Data/Szoba_attributumok.txt");
            Scanner reader = new Scanner(attr);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] attributes = data.split(",");
                String id = attributes[1];
                boolean gaz = Boolean.parseBoolean(attributes[2]);
                int ferohely = Integer.parseInt(attributes[3]);
                if (attributes[0].equals("false")) {
                    new Szoba(id, gaz, ferohely, this);
                } else
                    new ElatkozottSzoba(id, gaz, ferohely, this);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Szobák összekötése
        try {
            File szomsz = new File("projlab_pupakok/src/Data/Szoba_szomszedok.txt");
            Scanner reader2 = new Scanner(szomsz);
            int sz = 0;
            while (reader2.hasNextLine()) {
                String data = reader2.nextLine();
                String[] szomszedok = data.split(",");
                for (int i = 0; i < szomszedok.length; i++) {
                    for (Szoba szoba : szobak) {
                        if (szoba.getid().equals(szomszedok[i]))
                            szobak.get(sz).addSzomszed(szoba);
                    }
                }
                sz++;
            }
            reader2.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Random rand = new Random();
        int input;
        // hallgatók felvétele
        if (toggle_random) {

            System.out.println("Játékosok száma:");
            try {
                input = System.in.read() - '0';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < input; i++) {
                hallgatok.add(new Hallgato(szobak.get(rand.nextInt(10)), String.valueOf(hallgatok.size())));
            }
        } else {
            for (int i = 0; i < 1; i++) {
                hallgatok.add(new Hallgato(szobak.get(0), String.valueOf(hallgatok.size())));
            }
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

                switch (rand.nextInt(1, 7)) {
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
                Szoba szoba = oktato.getSzoba();
                ArrayList<Szoba> szomszedok = szoba.getSzomszedok();
                int randomIndex = rand.nextInt(szomszedok.size());
                Szoba randomSzoba = szomszedok.get(randomIndex);
                oktato.mozog(randomSzoba);
            }
        } else {
            for (Oktato oktato : oktatok) {
                Szoba szoba = oktato.getSzoba();
                ArrayList<Szoba> szomszedok = szoba.getSzomszedok();
                Szoba randomSzoba = szomszedok.get(0);
                oktato.mozog(randomSzoba);
            }
        }

        for (Oktato oktato : oktatok)
        {
            oktato.felvesz(oktato.getSzoba().getTargyak().get(0));
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
        // TODO osztodas, egyesules
        // Szobák osztódása
        if (toggle_random) {
            for (int i = 0; i < 3; i++) {
                szobak.get(rand.nextInt(szobak.size())).osztodik();
            }
        } else {
            for (int i = 0; i < 3; i++) {
                szobak.get(i).osztodik();
            }
        }

        // Szobák egyesülése
        if (toggle_random) {
            for (int i = 0; i < 7; i++) {
                szobak.get(rand.nextInt(szobak.size())).egyesul(szobak.get(rand.nextInt(szobak.size())));
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
                if (szoba instanceof ElatkozottSzoba)
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
                if (szoba instanceof ElatkozottSzoba)
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
