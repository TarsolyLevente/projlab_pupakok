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

import Game.*;
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
        palya.general(); // TODO ?????????????
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
        szoba.targy_elhelyezese(camembert); // TODO Targyak.add ????
    }

    /**
     * Camembert eltunetetese
     */
    public static void test5() {
        Szoba szoba = new Szoba(false, 0);
        Camembert camembert = new Camembert(szoba);
        szoba.targy_elhelyezese(camembert);
        System.out.println("");
        szoba.targy_eltuntetese(camembert); // eltuntetes???
    }

    /**
     * Logarlec elhelyezese
     */
    public static void test6() {
        Szoba szoba = new Szoba(false, 0);
        Logarlec logarlec = new Logarlec(szoba);
        System.out.println("");
        szoba.targy_elhelyezese(logarlec); // TODO Targyak.add ????
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
        szoba.targy_elhelyezese(tranzisztor); // TODO Targyak.add ????
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
        
        elatkozottszoba.elotunik(szoba);

    }
    /**
     * Eszméletvesztés
     */
    public static void test24() {
        Szoba gazosszoba = new Szoba(true, 10);
        Szoba szoba2 = new Szoba(false, 10);
        Oktato oktato = new Oktato(szoba2);
        gazosszoba.addOktato(oktato);
        
    }
    /**
     * Hallgató kibuktatása
     */
    public static void test25() {
        Szoba szoba1 = new Szoba(false, 10);
        Szoba szoba2 = new Szoba(false, 10);
        Oktato oktato = new Oktato(szoba1);
        Hallgato hallgato = new Hallgato(szoba2);
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
        hallgato.felvesz(rongy);

        oktato.mozog(szoba2);
        
    }
    /**
     * Oktató mozgása szobába
     */
    public static void test27() {
        Szoba szoba1 = new Szoba(false, 10);
        Szoba szoba2 = new Szoba(false, 10);
        Oktato oktato = new Oktato(szoba1);
        oktato.mozog(szoba2);
        
    }

    /**
     * Hallgató mozgása szobába
     */
    public static void test28() {
        Szoba szoba1 = new Szoba(false, 10);
        Szoba szoba2 = new Szoba(false, 10);
        Hallgato hallgato = new Hallgato(szoba1);
        hallgato.mozog(szoba2);
        
    }
    /**
     * Hallgató camembert felvétele
     */
    public static void test29() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Camembert camambert = new Camembert(szoba);
        h.felvesz(camambert);
        
    }
    /**
     * Hallgató Logarléc felvétele
     */
    public static void test30() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Logarlec logarlec = new Logarlec(szoba);
        h.felvesz(logarlec);
    }
    /**
     * Hallgató tranzisztor felvétele
     */
    public static void test31() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Tranzisztor tranzisztor = new Tranzisztor(szoba);
        h.felvesz(tranzisztor);
        
    }
    /**
     * Hallgató TVSZ felvétele
     */
    public static void test32() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        TVSZ tvsz = new TVSZ(szoba);
        h.felvesz(tvsz);
        
    }
    /**
     * Hallgató söröspohár felvétele
     */
    public static void test33() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Sorospohar sorospohar = new Sorospohar(szoba);
        h.felvesz(sorospohar);
        
    }


    /**
     * Hallgató felveszi a rongyot a földről.
     */
    public static void test34() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Rongy rongy = new Rongy(szoba);
        h.felvesz(rongy);
    }

    /**
     * Hallgató felveszi a maszkot a földről.
     */
    public static void test35() {
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Maszk maszk = new Maszk(szoba);
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
        h.eldob(t);
    }

    /**
     * Oktató felveszi a camembert a földről.
     */
    public static void test44() {
        Szoba szoba = new Szoba(false, 10);
        Oktato h = new Oktato(szoba);
        Camembert camembert = new Camembert(szoba);
        h.felvesz(camembert);
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
            // TODO: handle exception
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

                    break;
                case 44:
                    test44();
                    break;
                case 45:

                    break;


                default:
                    break;
            }
            scanner.next();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            printMenu(lines);
        }
        scanner.close();
    }
}
