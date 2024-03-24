package Targy;

import Szoba.*;

public class Camembert extends AktivTargy {
    public Camembert(Szoba sz) {
        super(sz);
    }

    /**
     * A Camembert tárgy megvalósítása az absztrakt use() függvénynek.
     */
    public void use() {
        System.out.println("Camembert -> use()");
    }
}