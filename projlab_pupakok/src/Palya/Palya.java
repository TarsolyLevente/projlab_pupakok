package Palya;

import Game.Game;
import Karakter.*;
import Szoba.*;
import Targy.*;

import java.beans.PropertyChangeListenerProxy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Palya {
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

    /**
     * Konstruktor
     */
	public Palya() {
		hallgatok =  new ArrayList<>();
        oktatok =  new ArrayList<>();
        szobak = new ArrayList<>();
        takaritok = new ArrayList<Takarito>();
	}

    /**
     * Konstruktor
     *
     * @param g a game amihez a pálya tartozik
     */
    public Palya(Game g) {
        hallgatok =  new ArrayList<Hallgato>();
        oktatok =  new ArrayList<Oktato>();
        szobak = new ArrayList<Szoba>();
        takaritok = new ArrayList<Takarito>();
        game = g;
    }

    /**
	 * A szobákat előre megterveztük
	 * és ezeket létrehozza a hallgatókkal, oktatókkal és tárgyakkal együtt.
	 */
    public void general() {

        //Szobak hozzaadasa
        try {
        File attr = new File("Szoba_attributumok.txt");
        Scanner reader = new Scanner(attr);
        while (reader.hasNextLine())
        {
            String data = reader.nextLine();
            String[] attributes = data.split(",");
            int id = Integer.parseInt(attributes[1]);
            boolean gaz = Boolean.parseBoolean(attributes[2]);
            int ferohely = Integer.parseInt(attributes[3]);
            if(attributes[0].equals("false"))
            {
                szobak.add(new Szoba(id, gaz, ferohely, this));
            }
            else
                szobak.add(new ElatkozottSzoba(id, gaz, ferohely, this));
        }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Szobák összekötése
        try {
            File szomsz = new File("Szoba_szomszedok.txt");
            Scanner reader2 = new Scanner(szomsz);
            while (reader2.hasNextLine())
            {
                String data = reader2.nextLine();
                String[] szomszedok = data.split(",");
                for(Szoba sz : szobak) {
                    for (int i = 0; i < szomszedok.length; i++) {
                        for(Szoba szoba : szobak){
                            if(szoba.getId() == szomszedok[i])
                                sz.addSzomszed(szoba);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Random rand = new Random();
        int input;
        // hallgatók felvétele
        System.out.println("Játékosok száma:");
        try {
            input = System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < input; i++) {
            hallgatok.add(new Hallgato(szobak.get(rand.nextInt(10))));
        }


        // oktatók felvétele
        for (int i = 0; i < Math.ceil((double) hallgatok.size() /3); i++) {
            if (szobak.get(42).getBefogadokepesseg() > oktatok.size())
                oktatok.add(new Oktato(szobak.get(42)));
        }

        //Takarito hozzaadasa
        takaritok.add(new Takarito(25));


        for (Szoba sz : szobak) {
            for (int i = 0; i < 5; i++) {
                switch (rand.nextInt(1, 6)) {
                    case 1:
                        sz.targy_elhelyezese(new Tranzisztor(sz));
                        break;
                    case 2:
                        sz.targy_elhelyezese(new Sorospohar(sz));
                        break;
                    case 3:
                        sz.targy_elhelyezese(new Rongy(sz));
                        break;
                    case 4:
                        sz.targy_elhelyezese(new Maszk(sz));
                        break;
                    case 5:
                        sz.targy_elhelyezese(new Camembert(sz));
                        break;
                    default:
                        sz.targy_elhelyezese(new TVSZ(sz));
                        break;

                }
            }
        }

        Logarlec logarlec = new Logarlec(szobak.get(12));
        logarlec.addPropertyChangeListener(new LogarlecPropertyChangeListener(game));
    }

     /**
	 * Meghívja az oktatók mozog függvényét egy szomszédos szobába
	 */
    public void leptet()
    {
        Random rand = new Random();

        //lépés az oktatóval
        for (Oktato oktato : oktatok) {
            
            Szoba szoba = oktato.getSzoba();
            ArrayList<Szoba> szomszedok = szoba.getSzomszedok();
            int randomIndex = rand.nextInt(szomszedok.size());
            Szoba randomSzoba = szomszedok.get(randomIndex);
            oktato.mozog(randomSzoba);

        }

        //lépés a takarítóval
        for (Takarito takarito : takaritok) {
            
            Szoba szoba = takarito.getSzoba();
            ArrayList<Szoba> szomszedok = szoba.getSzomszedok();
            int randomIndex = rand.nextInt(szomszedok.size());
            Szoba randomSzoba = szomszedok.get(randomIndex);
            takarito.mozog(randomSzoba);

        }

        //Szobák osztódása
        for (int i = 0; i < 3; i++)
        {
            szobak.get(rand.nextInt(szobak.size())).osztodik();
        }

        //Szobák egyesülése
        for (int i = 0; i < 7; i++) {
            szobak.get(rand.nextInt(szobak.size())).egyesul(szobak.get(rand.nextInt(szobak.size())));
        }

        // Ajtok eltunese
        for (Szoba szoba : szobak ) { //????
            if (szoba instanceof ElatkozottSzoba)
                ((ElatkozottSzoba) szoba).eltunik(szoba.getSzomszedok().get(rand.nextInt(szoba.getSzomszedok().size())));
        }

        // Ajtok elotuntetese
        for (Szoba szoba : szobak) {
            if(szoba instanceof ElatkozottSzoba)
(                ((ElatkozottSzoba) szoba).elotunik(((ElatkozottSzoba) szoba).getEltuntajto().get(rand.nextInt(((ElatkozottSzoba) szoba).getEltuntajto().size()))));
)        }
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
