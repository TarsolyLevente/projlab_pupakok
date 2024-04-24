package Targy;

import Szoba.*;

public class Maszk extends PasszivTargy{
    /**
     * Maszk osztály konstruktora.
     */
    public Maszk(Szoba sz, String id, int t) {
        super(Funkcio.gaztol_ved, id, sz, t = 4);
    }

    /**
     * A Maszk tárgy általi megvalósítása az absztrakt setToltet() függvénynek.
     */
    public void setToltet(){
        toltet--;
    }

    /**
     * A Maszk tárgy általi megvalósítása az absztrakt use() függvénynek.
     */
    public void use(){
        setToltet();
    }
}