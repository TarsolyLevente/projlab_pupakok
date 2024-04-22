package Game;

import javax.management.timer.Timer;

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

    Timer timer = new Timer();

    LogarlecPropertyChangeListener logChange; // TODO mi ez???

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
        timer.start();
        palya.general();
    }

    /**
     * Ezt fogja a start() a végén meghívni, hogy folyamatosan futtathassa a játékot
     */
    public void jatekLeptetes() {
        while(szamlalo!=0) {
            palya.leptet();
            szamlalo--;
        }
        endgame();
    }

    /**
	 * Befejezi a játékot
	 */
    public void endgame(){
        if (timer >= ???)  // minél nagyobb?
            //mi lesz a vége?
        else if (palya.getHallgatok().isEmpty())
            // vége?
        else
            //mi lesz ha gyoznek?
    }
}
