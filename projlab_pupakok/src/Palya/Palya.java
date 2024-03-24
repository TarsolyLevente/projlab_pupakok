package Palya;

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

  
	public Palya() {
		hallgatok =  new ArrayList<>();
        oktatok =  new ArrayList<>();
        oktatok =  new ArrayList<>();
	}

    /**
	 * A szobákat beolvassa fájlból
	 * és létrehozza a hallgatókat és oktatókat és elhelyezi a tárgyakat
	 */
    public  void general(){

        System.out.println("Palya -> general()");

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


}
