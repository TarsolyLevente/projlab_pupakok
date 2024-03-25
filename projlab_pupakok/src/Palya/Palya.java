package Palya;

import Game.Game;
import Karakter.*;
import Szoba.*;
import Targy.*;

import java.util.ArrayList;
import java.util.Random;

public class Palya {
    /**
	 * A játékba lévő hallgatók
	 */
    protected ArrayList<Hallgato> hallgatok;
    /**
	 * A játékba lévő oktatok
	 */
    protected ArrayList<Oktato> oktatok;
    /**
	 * A játékba lévő szobák
	 */
    protected ArrayList<Szoba> szobak;
    /**
     * A pálya game attribútuma
     */
    protected Game game;

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
        hallgatok =  new ArrayList<>();
        oktatok =  new ArrayList<>();
        szobak = new ArrayList<>();
        game = g;
    }

    /**
	 * A szobákat beolvassa fájlból
	 * és létrehozza a hallgatókat és oktatókat és elhelyezi a tárgyakat
	 */
    public void general() {

        System.out.println("Palya -> general()");
        Szoba szoba = new Szoba(false, 2);
        ElatkozottSzoba elatkozottSzoba = new ElatkozottSzoba(false, 3);

        szoba.addSzomszed(elatkozottSzoba);
        elatkozottSzoba.addSzomszed(szoba);

        Hallgato hallgato = new Hallgato(szoba);
        hallgatok.add(hallgato);
        Oktato oktato = new Oktato(elatkozottSzoba);
        oktatok.add(oktato);
    }

     /**
	 * Meghívja az oktatók mozog függvényét egy szomszédos szobába
	 */
    public  void leptet(){
        System.out.println("Palya -> leptet()");
        Random rand = new Random();

        for (Oktato oktato : oktatok) {
            
            Szoba szoba = oktato.getSzoba();
            ArrayList<Szoba> szomszedok = szoba.getSzomszedok();
            int randomIndex = rand.nextInt(szomszedok.size());
            Szoba randomSzoba = szomszedok.get(randomIndex);
            oktato.mozog(randomSzoba);

        }
        return;
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
