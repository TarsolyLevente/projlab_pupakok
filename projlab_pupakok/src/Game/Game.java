package Game;

import Karakter.*;
import Palya.*;
import Szoba.*;
import Targy.*;

import javax.swing.*;


public class Game {
    /**
	 * A játékba lévő pálya
	 */
    private Palya palya;
    /**
	 * Idő számláló
	 */
    private int szamlalo = 0;

    Timer timer = new Timer(1000, e -> {szamlalo++;});

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
        jatekLeptetes();
    }

    public void smashALepo()
    {

        for (Hallgato hallgato : palya.getHallgatok())
        {
            if(hallgato.mozog(hallgato.getSzoba().getSzomszedok())
        }
    }

    /**
     * Ezt fogja a start() a végén meghívni, hogy folyamatosan futtathassa a játékot
     */
    public void jatekLeptetes() {
        while(szamlalo!=900) {
            if (szamlalo % 60 == 0)
                palya.leptet();
        }
        endgame();
    }

    /**
	 * Befejezi a játékot
	 */
    public void endgame(){
        if (szamlalo >= 900)  // 15 perc a játék
            System.out.println("Az idő lejárt, nyomj entert a menübe lépéshez!");
        else if (palya.getHallgatok().isEmpty())
            System.out.println("Minden hallgató kibukott, nyomj entert a menübe lépéshez!");
        else
            System.out.println("Sikerült megtalálni a logarlécet! Győzelem!");
    }
}
