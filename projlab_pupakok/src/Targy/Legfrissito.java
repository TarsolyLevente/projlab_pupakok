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
        if(this.getFunkcio() != Funkcio.hamis){
            this.getSzoba().setGaz(false);
            this.getBirtokos().getTaska().remove(this);
        }
    }

    /**
     * Visszaadja az objektum szöveges reprezentációját a Funkcio attribútum alapján.
     */
    public String toString(Funkcio funkcio) {
        if (funkcio == null || funkcio == this.funkcio)
            return "Légfrissítő";
        return "";
    }
}
