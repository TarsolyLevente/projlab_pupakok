package Targy;

import Szoba.*;
import Karakter.*;

public class Tranzisztor extends AktivTargy {
    /**
     * Tranzisztor osztály konstruktora.
     */
    public Tranzisztor(Szoba sz, String id) {
        super(sz, id);
    }

    /**
     * Meghatározza, hogy a tranzisztor aktiválva van-e, vagy sem.
     */
    private boolean aktiv = false;

    /**
     * Megadja, hogy a tranzisztor, teleportálást követően melyik szobában fogja
     * elhelyezni a hallgatót.
     */
    private Szoba hova;

    /**
     * Megadja, hogy az adott tranzisztor melyik másikkal van összekapcsolva a
     * pályán.
     */
    private Tranzisztor tars;

    /**
     * A függvény meghívása után a játékos elteleportál abba a Szobába, ami az
     * aktivált tranzisztor társát tartalmazza.
     */
    public void use() {
        if (this.getTars() != null) {
            if (this.getTars().getAktiv() != true) {
                this.getBirtokos().getSzoba().targy_elhelyezese(this);
                this.setAktiv(true);
            } else {
                Hallgato h = (Hallgato) this.getBirtokos();
                h.teleport(this);
            }
        }
    }

    /**
     * A függvény beállítja, hogy az adott tranzisztor melyik másikkal van
     * összeköttetésben.
     * Setter függvény a Tars attribútumra.
     */
    public void setTars(Tranzisztor t) {
        tars = t;
    }

    /**
     * Getter a tranzisztor társához, amivel kapcsolatban van.
     */
    public Tranzisztor getTars() {
        return tars;
    }

    /**
     * Setter a tranzisztor aktiv adattagához
     */
    public void setAktiv(boolean b) {
        aktiv = b;
    }

    /**
     * Getter a tranzisztor aktiv attribútumához
     */
    public boolean getAktiv() {
        return aktiv;
    }

    /**
     * Getter a tranzisztor hova attribútumához
     */
    public Szoba getHova() {
        return hova;
    }

    /**
     * Setter a tranzisztor hova attribútumához
     */
    public void setHova(Szoba h) {
        hova = h;
    }

    public String toString(Funkcio funkcio) {
        if (funkcio == null || (funkcio == this.funkcio && this.aktiv))
            return "Tranzisztor";
        return "";
    }

}