package Game;

import Karakter.*;
import Palya.*;
import Szoba.*;
import Targy.*;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.*;

//TODO tranzisztor
public class Game {
    /**
     * A játékba lévő pálya
     */
    private Palya palya;
    /**
     * Idő számláló
     */
    private int szamlalo = 0;

    Timer timer = new Timer(1, e -> {
        szamlalo++;
    });

    /**
     * Konstruktor
     * 
     * @param sz az itőt reprezentáló számláló
     */
    public Game() {
        palya = new Palya(this);
        szamlalo = 0;
    }

    /**
     * le generálja a pályát és folyton meghívja a léptet függvényt a pályán
     */
    public void start(int jatekosokszama) {
        timer.start();
        palya.general(jatekosokszama);
    }

    public void hallgatoLep(Hallgato hallgato) {
        System.out.println("Hallgató " + hallgato.getid() + " következik!");
        System.out.println("Jelenlegi szoba: " + hallgato.getSzoba().getid());
        if (hallgato.getTaska().size() != 0) {
            System.out.println("Tárgyak a taskádban:");
            for (Targy t : hallgato.getTaska()) {
                if (t.getFunkcio() == Funkcio.hamis)
                    System.out.println("hamis " + t.toString(null));
                else
                    System.out.println("igaz " + t.toString(null));
            }
        }
        System.out.println("");

        Scanner reader = new Scanner(System.in);
        while (true) {
            int inventorythrowcnt;
            for (inventorythrowcnt = 0; inventorythrowcnt < hallgato.getTaska().size(); inventorythrowcnt++) {
                System.out.println(
                        inventorythrowcnt + 1 + ". "
                                + hallgato.getTaska().get(inventorythrowcnt).toString(null)
                                + " eldobása");
            }
            int inventoryusecnt = inventorythrowcnt;
            Dictionary<Integer, Integer> dict = new Hashtable<>();
            for (int i = 0; i < hallgato.getTaska().size(); i++) {
                if (hallgato.getTaska().get(i).toString(Funkcio.aktiv) != "") {
                    inventoryusecnt++;
                    dict.put(inventoryusecnt, i);
                    System.out.println(
                            inventoryusecnt + ". " + hallgato.getTaska().get(i).toString(Funkcio.aktiv)
                                    + " használata");
                }
            }

            int targycnt = inventoryusecnt;
            for (Targy t : hallgato.getSzoba().getTargyak()) {
                targycnt++;
                System.out.println(targycnt + ". " + t.toString(null) + " felvétele");
            }
            int tpcnt = targycnt;
            Dictionary<Integer, Integer> trdict = new Hashtable<>();
            for (int i = 0; i < hallgato.getSzoba().getTargyak().size(); i++) {
                Targy t = hallgato.getSzoba().getTargyak().get(i);
                if (t instanceof Tranzisztor && !t.toString(Funkcio.aktiv).equals("")) {
                    if (t.toString(Funkcio.aktiv).length() != 11) {
                        tpcnt++;
                        System.out.println(tpcnt + ". Teleportálás " + t.toString(Funkcio.aktiv) + "ral");
                        dict.put(tpcnt, i);
                    }
                }
            }
            int szomszedcnt = tpcnt;
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
                    if (data <= inventorythrowcnt)
                        hallgato.eldob(hallgato.getTaska().get(data - 1));
                    else if (data <= inventoryusecnt)

                        hallgato.getTaska().get(dict.get(data)).use();
                    else if (data <= targycnt)
                        hallgato.felvesz(hallgato.getSzoba().getTargyak().get(data - inventoryusecnt - 1));
                    else if (data <= tpcnt)
                        hallgato.teleport((Tranzisztor) hallgato.getSzoba().getTargyak().get(dict.get(data)));
                    else {
                        hallgato.mozog(hallgato.getSzoba().getSzomszedok().get(data - targycnt - 1));
                        return;
                    }
                }
            } catch (Exception e) {
                String feladja = reader.next();
                if (feladja.equals("feladom")) {
                    System.out.println("Megnyerted a játékot!");
                    System.exit(0);
                } else
                    System.out.println("Rossz bemenet");
            }
        }
    }

    

    /**
     * Befejezi a játékot
     */
    public void endgame() {
        if (szamlalo >= 900000) // 15 perc a játék
            System.out.println("Az idő lejárt!");
        else if (palya.getHallgatok().isEmpty())
            System.out.println("Minden hallgató kibukott!");
        else
            System.out.println("Sikerült megtalálni a logarlécet! Győzelem!");
        System.exit(0);
    }

    public Palya getPalya() {return palya;}
    
    public int getSzamlalo(){return szamlalo;};

}
