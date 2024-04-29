package Targy;

import Szoba.*;

public class TVSZ extends PasszivTargy{
    /**
     * TVSZ osztály konstruktora.
     */
    public TVSZ(Szoba sz, String id) {
        super(Funkcio.oktatotol_ved, id, sz,3);
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
        if(this.getFunkcio() != Funkcio.hamis){
            setToltet();
        }
    }

    public String toString(Funkcio funkcio) {
        if (funkcio == null || funkcio == this.funkcio)
            return "TVSZ";
        return "";
    }
}