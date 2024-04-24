package Targy;

import Szoba.*;
import Karakter.*;

public class TVSZ extends PasszivTargy{
    /**
     * TVSZ osztály konstruktora.
     */
    public TVSZ(Szoba sz, String id, int t) {
        super(Funkcio.oktatotol_ved, id, sz, t = 3);
    }

    /**
     * A TVSZ tárgy általi megvalósítása az absztrakt setToltet() függvénynek.
     */
    public void setToltet(){
        toltet--;
    }

    /**
     * A TVSZ tárgy általi megvalósítása az absztrakt use() függvénynek.
     */
    public void use(){
        setToltet();
    }
}