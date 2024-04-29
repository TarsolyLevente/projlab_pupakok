package Game;

import Karakter.*;
import Palya.*;
import Szoba.*;
import Targy.*;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

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

    Timer timer = new Timer(1000, e -> {
        szamlalo++;
    });

    /**
     * Konstruktor
     * 
     * @param sz az itőt reprezentáló számláló
     */
    public Game(int sz) {
        palya = new Palya(this);
        szamlalo = sz;
    }

    /**
     * le generálja a pályát és folyton meghívja a léptet függvényt a pályán
     */
    public void start() {
        timer.start();
        palya.general();
        jatekLeptetes();
    }

    public void hallgatoLep(Hallgato hallgato) {
        System.out.println("Hallgató " + hallgato.getid() + " következik!");
        

        Scanner reader = new Scanner(System.in);
        while (true) {
            int inventorycnt = 0;
            Dictionary<Integer, Integer> dict = new Hashtable<>();
            for (int i = 0; i < hallgato.getTaska().size(); i++) {
                if (hallgato.getTaska().get(i).toString(Funkcio.aktiv) != "") {
                    inventorycnt++;
                    dict.put(inventorycnt, i);
                    System.out.println(
                            inventorycnt + ". " + hallgato.getTaska().get(i).toString(Funkcio.aktiv) + " használata");
                }
            }

            int targycnt = inventorycnt;
            for (Targy t : hallgato.getSzoba().getTargyak()) {
                targycnt++;
                System.out.println(targycnt + ". " + t.toString(null) + " felvétele");
            }
            int szomszedcnt = targycnt;
            for (Szoba szoba : hallgato.getSzoba().getSzomszedok()) {
                szomszedcnt++;
                System.out.println(szomszedcnt + ". " + szoba.getid() + ". számú szobába lépés");
            }

            int data = 0;
            try {
                data = reader.nextInt();
                if (data > szomszedcnt)
                    System.out.println("Rossz bemenet");
                else {
                    if (data <= inventorycnt)
                        hallgato.getTaska().get(dict.get(data)).use();
                    else if (data <= targycnt)
                        hallgato.felvesz(hallgato.getSzoba().getTargyak().get(data - inventorycnt - 1));
                    else {
                        hallgato.mozog(hallgato.getSzoba().getSzomszedok().get(data - targycnt - 1));
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Rossz bemenet");
            }
        }
    }

    /**
     * Ezt fogja a start() a végén meghívni, hogy folyamatosan futtathassa a játékot
     */
    public void jatekLeptetes() {
        while (szamlalo != 900) {
            for (Hallgato h : palya.getHallgatok()) {
                hallgatoLep(h);
            }
            palya.leptet();
        }
        endgame();
    }

    /**
     * Befejezi a játékot
     */
    public void endgame() {
        if (szamlalo >= 900) // 15 perc a játék
            System.out.println("Az idő lejárt, nyomj entert a menübe lépéshez!");
        else if (palya.getHallgatok().isEmpty())
            System.out.println("Minden hallgató kibukott, nyomj entert a menübe lépéshez!");
        else
            System.out.println("Sikerült megtalálni a logarlécet! Győzelem!");
        System.exit(0);
    }
}
