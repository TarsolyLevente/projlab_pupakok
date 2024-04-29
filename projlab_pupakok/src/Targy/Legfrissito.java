package Targy;

import Szoba.*;

public class Legfrissito extends AktivTargy {
    /**
     * Legfrissito osztály konstruktora.
     */
    public Legfrissito(Szoba sz, String id) {
        super(sz, id);
    }

    /**
     * A függvény meghívása után a gázos szobából, ahol a játékos tartózkodik,
     * eltűnik a gáz.
     */
    public void use() {
        this.getSzoba().setGaz(false);
        this.getBirtokos().getTaska().remove(this);
    }

    public String toString(Funkcio funkcio) {
        if (funkcio == null || funkcio == this.funkcio)
            return "Légfrissítő";
        return "";
    }
}
