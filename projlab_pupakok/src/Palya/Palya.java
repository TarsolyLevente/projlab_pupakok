package Palya;

import Game.Game;
import Karakter.*;
import Szoba.*;
import Targy.*;

import java.util.ArrayList;
import java.util.Random;

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
    protected ArrayList<Takarító> takaritok;

    /**
     * Konstruktor
     */
	public Palya() {
		hallgatok =  new ArrayList<>();
        oktatok =  new ArrayList<>();
        szobak = new ArrayList<>();
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
        takaritok = new ArrayList<Takarito>()
        game = g;
    }

    /**
	 * A szobákat beolvassa fájlból
	 * és létrehozza a hallgatókat és oktatókat és elhelyezi a tárgyakat
	 */
    public void general() {

        // hallgatók felvétele
        while ((input = System.in.read()) != "q") 
        {
            Random random = new Random();
            if (input == "\n") 
            {
                hallgatok.add(new Hallgato(random.nextInt(10), , (string) input))
            }

        }

        // oktatók felvétele
        for (int i = 0; i <= Math.ceil(hallgatok.size()/3); i++) 
        {
            oktatok.add(new Oktato(43))
        }
        //TODO fajlbeolvasas, create command??

        takaritok.add(new Takarito(25))
    }

     /**
	 * Meghívja az oktatók mozog függvényét egy szomszédos szobába
	 */
    public void leptet(){
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
        for (Takarito takarito : oktatok) {
            
            Szoba szoba = takarito.getSzoba();
            ArrayList<Szoba> szomszedok = szoba.getSzomszedok();
            int randomIndex = rand.nextInt(szomszedok.size());
            Szoba randomSzoba = szomszedok.get(randomIndex);
            takarito.mozog(randomSzoba);

        }

        for (int i = 0; i <= 4; i++)
        {
            Random random = new Random();
            Szoba temp = szobak.get(random.nextInt(szobak.size()));
            temp.osztodik();
        }

        //TODO osztodott szobak egyesulese?

        for (Szoba szoba : hallgatok) {
            
        }

        // Ajtok eltunese
        for (ElatkozottSzoba szoba : szobak ) { //????
            if (szoba.elobbeltunt)
                szoba.eltunik;
            else
                szoba.elotunik(szoba); //???
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
