package Targy;

import Szoba.*;

public class Maszk extends PasszivTargy {
    public Maszk(Szoba sz) {
        super(sz, Funkcio.gaztol_ved);
    }

    /**
     * Az absztrakt setToltet() függvény megvalósítása a Maszk által
     */
    public void setToltet() {
        System.out.println("Maszk -> setToltet()");
    }

    public void use(){
        
    }
}