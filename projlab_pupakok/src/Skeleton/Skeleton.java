package Skeleton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import Game.Game;
import Palya.Palya;
import Szoba.*;
import Karakter.*;
import Palya.Palya;
import Targy.*;

public class Skeleton {

    /**
     * Jatek inditasa
     */
    public static void test0() {
        Game game = new Game(0);
        game.start();
    }

    /**
     * Oktatok leptetese
     */
    public static void test1() {
        Palya palya = new Palya();
        palya.general();
        System.out.println("");
        palya.leptet();
    }

    /**
     * Szoba osztodasa
     */
    public static void test2() {
        Szoba sz1 = new Szoba(false, 2);
        Szoba sz2 = new Szoba(false, 2);
        Szoba szomszedSzoba = new Szoba(false, 0);
        sz2.addSzomszed(szomszedSzoba);
        sz2.targy_elhelyezese(new Maszk(sz2));
        sz1.egyesul(sz2);
        System.out.println("");
        sz1.osztodik();
    }

    /**
     * Szoba egyesulese
     */
    public static void test3() {
        Szoba sz1 = new Szoba(false, 2);
        Szoba sz2 = new Szoba(false, 2);
        Szoba szomszedSzoba = new Szoba(false, 0);
        sz2.addSzomszed(szomszedSzoba);
        sz2.targy_elhelyezese(new Maszk(sz2));
        System.out.println("");
        sz1.egyesul(sz2);
    }

    /**
     * Camembert elhelyezese
     */
    public static void test4() {
        Szoba szoba = new Szoba(false, 0);
        Camembert camembert = new Camembert(szoba);
        System.out.println("");
        szoba.targy_elhelyezese(camembert);
    }

    /**
     * Camembert eltunetetese
     */
    public static void test5() {
        Szoba szoba = new Szoba(false, 0);
        Camembert camembert = new Camembert(szoba);
        szoba.targy_elhelyezese(camembert);
        System.out.println("");
        szoba.targy_eltuntetese(camembert);
    }

    /**
     * Logarlec elhelyezese
     */
    public static void test6() {
        Szoba szoba = new Szoba(false, 0);
        Logarlec logarlec = new Logarlec(szoba);
        System.out.println("");
        szoba.targy_elhelyezese(logarlec);
    }

    /**
     * Logarlec eltuntetese
     */
    public static void test7() {
        Szoba szoba = new Szoba(false, 0);
        Logarlec logarlec = new Logarlec(szoba);
        szoba.targy_elhelyezese(logarlec);
        System.out.println("");
        szoba.targy_eltuntetese(logarlec);
    }

    /**
     * Tranzisztor elhelyezese
     */
    public static void test8() {
        Szoba szoba = new Szoba(false, 0);
        Tranzisztor tranzisztor = new Tranzisztor(szoba);
        System.out.println("");
        szoba.targy_elhelyezese(tranzisztor);
    }

    /**
     * Tranzisztor eltuntetese
     */
    public static void test9() {
        Szoba szoba = new Szoba(false, 0);
        Tranzisztor tranzisztor = new Tranzisztor(szoba);
        szoba.targy_elhelyezese(tranzisztor);
        System.out.println("");
        szoba.targy_eltuntetese(tranzisztor);
    }

    /**
     * Elátkozott szobában ajtó eltüntetése
     */
    public static void test22() {
        Szoba szoba = new Szoba(false, 10);
        ElatkozottSzoba elatkozottszoba = new ElatkozottSzoba(false, 10);
        ArrayList<Szoba> szobaszomszedok = new ArrayList<>();
        szobaszomszedok.add(elatkozottszoba);
        szoba.setSzomszedok(szobaszomszedok);


        ArrayList<Szoba> elatkozottszobaszomszedok = new ArrayList<>();
        elatkozottszobaszomszedok.add(szoba);
        elatkozottszoba.setSzomszedok(elatkozottszobaszomszedok);
        System.out.println("");
        elatkozottszoba.eltunik(szoba);

        
    }
    /**
     * Elátkozott szobában ajtó előtűnése
     */
    public static void test23() {
        Szoba szoba = new Szoba(false, 10);
        ElatkozottSzoba elatkozottszoba = new ElatkozottSzoba(false, 10);
        ArrayList<Szoba> szobaszomszedok = new ArrayList<>();
        //szobaszomszedok.add(elatkozottszoba);
        szoba.setSzomszedok(szobaszomszedok);


        ArrayList<Szoba> elatkozottszobaszomszedok = new ArrayList<>();
        elatkozottszobaszomszedok.add(szoba);
        elatkozottszoba.setSzomszedok(elatkozottszobaszomszedok);
        System.out.println("");
        elatkozottszoba.elotunik(szoba);

    }
    /**
     * Eszméletvesztés
     */
    public static void test24() {
        Szoba gazosszoba = new Szoba(true, 10);
        Szoba szoba2 = new Szoba(false, 10);
        Oktato oktato = new Oktato(szoba2);
        System.out.println("");
        gazosszoba.addOktato(oktato);
        
    }
    /**
     * Hallgató kibuktatása
     */
    public static void test25() {
        Palya palya = new Palya();
        Szoba szoba1 = new Szoba(false, 10, palya);
        Szoba szoba2 = new Szoba(false, 10, palya);
        Oktato oktato = new Oktato(szoba1);
        Hallgato hallgato1 = new Hallgato(szoba1);
        Hallgato hallgato2 = new Hallgato(szoba2);
        Maszk Maszk = new Maszk(szoba2);

        hallgato2.felvesz(Maszk);
        szoba1.addHallgato(hallgato1);
        palya.addHallgato(hallgato1);
        szoba2.addHallgato(hallgato2);
        palya.addHallgato(hallgato2);

        System.out.println("");
        oktato.mozog(szoba2);
        
    }

    /**
     * Oktató megbénítása
     */
    public static void test26() {
        Szoba szoba1 = new Szoba(false, 10);
        Szoba szoba2 = new Szoba(false, 10);
        Oktato oktato = new Oktato(szoba1);
        Hallgato hallgato = new Hallgato(szoba2);
        Rongy rongy = new Rongy(szoba2);
        szoba2.addHallgato(hallgato);
        hallgato.felvesz(rongy);
        System.out.println("");
        szoba2.addOktato(oktato);
        
    }
    
    /**
     * Oktató mozgása szobába
     */
    public static void test27() {
        Szoba szoba1 = new Szoba(false, 10);
        Szoba szoba2 = new Szoba(false, 10);
        Oktato oktato = new Oktato(szoba1);
        System.out.println("");
        oktato.mozog(szoba2);
        
    }

    /**
     * Hallgató mozgása szobába
     */
    public static void test28() {
        Szoba szoba1 = new Szoba(false, 10);
        Szoba szoba2 = new Szoba(false, 10);
        Hallgato hallgato = new Hallgato(szoba1);
        System.out.println("");
        hallgato.mozog(szoba2);
        
    }
    /**
     * Hallgató camembert felvétele
     */
    public static void test29() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Camembert camambert = new Camembert(szoba);
        System.out.println("");
        h.felvesz(camambert);
        
    }
    /**
     * Hallgató Logarléc felvétele
     */
    public static void test30() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Logarlec logarlec = new Logarlec(szoba);
        System.out.println("");
        h.felvesz(logarlec);
    }
    /**
     * Hallgató tranzisztor felvétele
     */
    public static void test31() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Tranzisztor tranzisztor = new Tranzisztor(szoba);
        System.out.println("");
        h.felvesz(tranzisztor);
        
    }
    /**
     * Hallgató TVSZ felvétele
     */
    public static void test32() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        TVSZ tvsz = new TVSZ(szoba);
        System.out.println("");
        h.felvesz(tvsz);
        
    }
    /**
     * Hallgató söröspohár felvétele
     */
    public static void test33() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Sorospohar sorospohar = new Sorospohar(szoba);
        System.out.println("");
        h.felvesz(sorospohar);
        
    }


    /**
     * Hallgató felveszi a rongyot a földről.
     */
    public static void test34() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Rongy rongy = new Rongy(szoba);
        System.out.println("");
        h.felvesz(rongy);
    }

    /**
     * Hallgató felveszi a maszkot a földről.
     */
    public static void test35() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Maszk maszk = new Maszk(szoba);
        System.out.println("");
        h.felvesz(maszk);
    }

    /**
     * Camembert eldobásának tesztje.
     */
    public static void test36(){
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Camembert c = new Camembert(szoba);
        h.felvesz(c);
        System.out.println("");
        h.eldob(c);
    }

    /**
     * Tranzisztor eldobásának tesztje.
     */
    public static void test38(){
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Tranzisztor t = new Tranzisztor(szoba);
        h.felvesz(t);
        System.out.println("");
        h.eldob(t);
    }

    /**
     * TVSZ eldobásának tesztje.
     */
    public static void test39(){
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        TVSZ t = new TVSZ(szoba);
        h.felvesz(t);
        System.out.println("");
        h.eldob(t);
    }

    /**
     * Söröspohár eldobásának tesztje.
     */
    public static void test40(){
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Sorospohar t = new Sorospohar(szoba);
        h.felvesz(t);
        System.out.println("");
        h.eldob(t);
    }

    /**
     * Rongy eldobásának tesztje.
     */
    public static void test41(){
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Rongy t = new Rongy(szoba);
        h.felvesz(t);
        System.out.println("");
        h.eldob(t);
    }

    /**
     * Maszk eldobásának tesztje.
     */
    public static void test42(){
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Maszk t = new Maszk(szoba);
        h.felvesz(t);
        System.out.println("");
        h.eldob(t);
    }

    /**
     * Oktató felveszi a camembert a földről.
     */
    public static void test44() {
        Szoba szoba = new Szoba(false, 10);
        Oktato h = new Oktato(szoba);
        Camembert camembert = new Camembert(szoba);
        System.out.println("");
        h.felvesz(camembert);
    }

    /**
     * Oktató felveszi a tranzisztort a földről.
     */
    public static void test46() {
        Szoba szoba = new Szoba(false, 10);
        Oktato oktato = new Oktato(szoba);
        Tranzisztor tranzisztor = new Tranzisztor(szoba);
        System.out.println("");
        oktato.felvesz(tranzisztor);
    }

    /**
     * Oktató felveszi a TVSZ-t a földről.
     */
    public static void test47() {
        Szoba szoba = new Szoba(false, 10);
        Oktato oktato = new Oktato(szoba);
        TVSZ tvsz = new TVSZ(szoba);
        System.out.println("");
        oktato.felvesz(tvsz);
    }

    /**
     * Oktató felveszi a söröspoharat a földről.
     */
    public static void test48() {
        Szoba szoba = new Szoba(false, 10);
        Oktato oktato = new Oktato(szoba);
        Sorospohar sorospohar = new Sorospohar(szoba);
        System.out.println("");
        oktato.felvesz(sorospohar);
    }

    /**
     * Oktató felveszi a rongyot a földről.
     */
    public static void test49() {
        Szoba szoba = new Szoba(false, 10);
        Oktato oktato = new Oktato(szoba);
        Rongy rongy = new Rongy(szoba);
        System.out.println("");
        oktato.felvesz(rongy);
    }

    /**
     * Oktató felveszi a maszkot a földről.
     */
    public static void test50() {
        Szoba szoba = new Szoba(false, 10);
        Oktato oktato = new Oktato(szoba);
        Maszk maszk = new Maszk(szoba);
        System.out.println("");
        oktato.felvesz(maszk);
    }

    /**
     * Camembert használata
     */
    // TODO
    public static void test51() {
        Szoba szoba1 = new Szoba(false, 10);
        Szoba szoba2 = new Szoba(true, 10);
        Hallgato hallgato = new Hallgato(szoba1);
        Camembert camembert = new Camembert(szoba1);
        hallgato.felvesz(camembert);
        hallgato.mozog(szoba2);
        System.out.println("");
        camembert.use();
    }

    /**
     * Tranzisztor összekapcsolása
     */
    public static void test52() {
        Szoba szoba1 = new Szoba(false, 10);
        Szoba szoba2 = new Szoba(false, 10);
        Tranzisztor t1 = new Tranzisztor(szoba1);
        Tranzisztor t2 = new Tranzisztor(szoba2);
        Hallgato hallgato = new Hallgato(szoba1);
        hallgato.felvesz(t1);
        hallgato.mozog(szoba2);
        hallgato.felvesz(t2);
        System.out.println("");
        t1.setTars(t2);
        t2.setTars(t1);
    }

    /**
     * Tranzisztor használata
     */
    // TODO exception
    public static void test53() {
        Szoba szoba1 = new Szoba(false, 10);
        Szoba szoba2 = new Szoba(false, 10);
        Tranzisztor t1 = new Tranzisztor(szoba1);
        Tranzisztor t2 = new Tranzisztor(szoba2);
        Hallgato hallgato = new Hallgato(szoba1);
        hallgato.felvesz(t1);
        hallgato.mozog(szoba2);
        hallgato.felvesz(t2);
        t1.setTars(t2);
        t2.setTars(t1);
        System.out.println("");
        t1.use();
        t2.use();
    }

    /**
     * Teleportálás tranzisztor segítségvel
     */
    // TODO exception
    public static void test54() {
        Szoba szoba1 = new Szoba(false, 10);
        Szoba szoba2 = new Szoba(false, 10);
        Tranzisztor t1 = new Tranzisztor(szoba1);
        Tranzisztor t2 = new Tranzisztor(szoba2);
        Hallgato hallgato = new Hallgato(szoba1);
        hallgato.felvesz(t1);
        hallgato.mozog(szoba2);
        hallgato.felvesz(t2);
        t1.setTars(t2);
        t2.setTars(t1);
        t1.use();
        t2.use();
        System.out.println("");
        hallgato.teleport(t1);
    }

    /**
     * Logarléc felvétele, a játék vége
     */
    public static void test55() {
        Szoba szoba = new Szoba(false, 10);
        Game game = new Game(0);
        Hallgato hallgato = new Hallgato(szoba);
        Logarlec logarlec = new Logarlec(szoba);
        logarlec.addPropertyChangeListener(new LogarlecPropertyChangeListener(game));
        System.out.println("");
        hallgato.felvesz(logarlec);
    }

    /**
     * Hallgató kibukása, a játék vége
     */
    // TODO
    public static void test56() {
        Palya palya = new Palya();
        Game game = new Game(0);
        Szoba szoba1 = new Szoba(false, 10, palya);
        Szoba szoba2 = new Szoba(false, 10, palya);
        Hallgato hallgato = new Hallgato(szoba1);
        palya.addHallgato(hallgato);
        Oktato oktato = new Oktato(szoba2);
        System.out.println("");
        hallgato.mozog(szoba2);
    }

    /**
     * Lejár az idő, a játéknak vége
     */
    public static void test57() {
        Palya palya = new Palya();
        Game game = new Game(0);
        System.out.println("");
        game.jatekLeptetes();
    }

    private ArrayList<String> readMenu() {
        File f = new File("projlab_pupakok/Data/Skeleton.txt");
        File file = new File(f.getAbsolutePath());
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                // process the line
                lines.add(line);
            }
            br.close();
        } catch (Exception e) {
        }
        return lines;
    }

    private void printMenu(ArrayList<String> lines) {
        for (String string : lines) {
            System.out.println(string);
        }
    }

    public void skeleton() {
        Scanner scanner = new Scanner(System.in);
        int szam;

        ArrayList<String> lines = readMenu();
        printMenu(lines);
        while ((szam = scanner.nextInt()) != 100) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (szam) {
                case 0:
                    test0();
                    break;
                case 1:
                    test1();
                    break;
                case 2:
                    test2();
                    break;
                case 3:
                    test3();
                    break;
                case 4:
                    test4();
                    break;
                case 5:
                    test5();
                    break;

                case 6:
                    test6();
                    break;
                case 7:
                    test7();
                    break;
                case 8:
                    test8();
                    break;
                case 9:
                    test9();
                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                case 14:

                    break;
                case 15:

                    break;
                case 16:

                    break;
                case 17:

                    break;
                case 18:

                    break;
                case 19:

                    break;

                // TODO
                case 22:
                    test22();
                    break;
                case 23:
                    test23();
                    break;
                case 24:
                    test24();
                    break;
                case 25:
                    test25();
                    break;
                case 26:
                    test26();
                    break;
                case 27:
                    test27();
                    break;
                case 28:
                    test28();
                    break;
                case 29:
                    test29();
                    break;
                case 30:
                    test30();
                    break;
                case 31:
                    test31();
                    break;
                case 32:
                    test32();
                    break;
                case 33:
                    test33();
                    break;    
                    

                case 34:
                    test34();
                    break;
                case 35:
                    test35();
                    break;
                case 36:
                    test36();
                    break;
                case 37:
                    
                    break;
                case 38:
                    test38();
                    break;
                case 39:
                    test39();
                    break;
                case 40:
                    test40();
                    break;
                case 41:
                    test41();
                    break;
                case 42:
                    test42();
                    break;
                case 43:
                    test27();
                    break;
                case 44:
                    test44();
                    break;
                case 45:

                    break;
                case 46:
                    test46();
                    break;
                case 47:
                    test47();
                    break;
                case 48:
                    test48();
                    break;
                case 49:
                    test49();
                    break;
                case 50:
                    test50();
                    break;
                case 51:
                    test51();
                    break;
                case 52:
                    test52();
                    break;
                case 53:
                    test53();
                    break;
                case 54:
                    test54();
                    break;
                case 55:
                    test55();
                    break;
                case 56:
                    test56();
                    break;
                case 57:
                    test57();
                    break;


                default:
                    break;
            }
        }
        scanner.close();
    }
}
