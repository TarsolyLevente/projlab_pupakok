package Targy;

import Szoba.*;

import java.security.cert.TrustAnchor;

public class Camembert extends AktivTargy{
    /**
     * Camembert osztály konstruktora.
     */
    public Camembert(Szoba sz, String id) {
        super(sz, id);
    }

    /**
     * A függvény meghívása után a szoba, ahol a játékos tartózkodik, gázzal töltődik meg.
     */
    public void use(){
        this.getSzoba().setGaz(true);
    }
}