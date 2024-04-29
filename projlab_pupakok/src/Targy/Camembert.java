package Targy;

import Szoba.*;

public class Camembert extends AktivTargy {
    /**
     * Camembert osztály konstruktora.
     */
    public Camembert(Szoba sz, String id) {
        super(sz, id);
    }

    /**
     * A függvény meghívása után a szoba, ahol a játékos tartózkodik, gázzal
     * töltődik meg.
     */
    public void use() {
        if(this.getFunkcio() != Funkcio.hamis){
            this.getSzoba().setGaz(true);
            this.getBirtokos().getTaska().remove(this);
        }
    }

    public String toString(Funkcio funkcio) {
        if (funkcio == null || funkcio == this.funkcio)
            return "Camembert";
        return "";
    }
}