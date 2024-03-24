package Game;

import Karakter.*;
import Palya.*;
import Szoba.*;
import Targy.*;


public class Game {
    /**
	 * A játékba lévő pálya
	 */
    private Palya palya;
    /**
	 * Idő számláló
	 */
    private int szamlalo;

    /**
     * Konstruktor
     * 
     * @param sz az itőt reprezentáló számláló
     */
    public Game(int sz) {
        palya = new Palya();
        szamlalo = sz;
    }

    /**
     * le generálja a pályát és folyton meghívja a léptet függvényt a pályán
     */
    public void start(){
        System.out.println("Game -> start()");
        palya.general();
    }

    /**
     * Ezt fogja a start() a végén meghívni, hogy folyamatosan futtathassa a játékot
     */
    private void jatekLeptetes() {
        // while(szamlalo!=0)
        palya.leptet();
    }

    /**
	 * Befejezi a játékot
	 */
    public void endgame(){
        System.out.println("Game -> endgame()");
    }


    
}
