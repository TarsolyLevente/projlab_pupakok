package Targy;

import Szoba.*;

import java.security.cert.TrustAnchor;

public class Camembert extends AktivTargy {
    public Camembert(Szoba sz) {
        super(sz);
        System.out.println("Camembert -> create");
    }

    /**
     * A Camembert tárgy megvalósítása az absztrakt use() függvénynek.
     */
    public void use() {
        System.out.println("Camembert -> use()");
        this.getBirtokos().getSzoba().setGaz();
    }
}