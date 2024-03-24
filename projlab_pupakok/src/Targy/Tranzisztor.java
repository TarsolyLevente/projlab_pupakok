package Targy;

import Szoba.*;
import Karakter.*;

public class Tranzisztor extends AktivTargy {

    public Tranzisztor(Szoba sz) {
        super(sz);
        System.out.println("Tranzisztor -> create");
    }

    /**
     * Aktiválva van-e a tranzisztor
     */
    private boolean aktiv;

    /**
     * Melyik szobával áll összeköttetésben a tranzisztor
     */
    private Szoba hova;

    /**
     * Az adott tranzisztor melyik másikkal van kapcsolatban
     */
    private Tranzisztor tars;

    /**
     * A tranzisztor tárgy megvalósítása az absztrakt use() függvénynek
     */
    public void use() {
        System.out.println("Tranzisztor -> use()");
    }

    /**
     * Setter a tranzisztorral kapcsolatban lévő társához
     */
    public void setTars(Tranzisztor t) {
        
        System.out.println("Tranzisztor -> setTars(Tranzisztor)");
    }
}