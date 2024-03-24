package Targy;

import Szoba.*;
import Karakter.*;

public class TVSZ extends PasszivTargy {
    public TVSZ(Szoba sz) {
        super(sz, Funkcio.oktatotol_ved);
    }
    /**
     * Az absztrakt setToltet() függvény megvalósítása a TVSZ által
     */
    public void setToltet() {
        System.out.println("TVSZ -> setToltet()");
    }

    public void use(){
        
    }

}