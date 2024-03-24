package Skeleton;

import java.util.ArrayList;
import java.util.Scanner;

import Szoba.*;
import Karakter.*;
import Targy.*;

public class Skeleton {


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
     * Oktató felveszi a camembert a földről.
     */
    public static void test44() {
        Szoba szoba = new Szoba(false, 10);
        Oktato h = new Oktato(szoba);
        Camembert camembert = new Camembert(szoba);
        h.felvesz(camembert);
    }

    public void skeleton() {
        Scanner scanner = new Scanner(System.in);
        int szam;

        while ((szam = scanner.nextInt()) != 100) {
            switch (szam) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;

                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

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

                case 44:
                    test44();
                    break;

                default:
                    break;
            }
        }
    }
}
