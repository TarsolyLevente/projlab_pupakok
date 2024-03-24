package Targy;

import Szoba.*;

public class Sorospohar extends PasszivTargy{
    public Sorospohar(Szoba sz) {
        super(sz, Funkcio.oktatotol_ved);
    }
    /**
     * Az idő múlását határozza meg
     */
    public void tick() {
        System.out.println("Sorospohar -> tick()");
    }

    /**
     * Az absztrakt setToltet() függvény megvalósítása a Söröspohár által
     */
    public void setToltet() {
        System.out.println("Sorospohar -> setToltet()");
    }

    public void use(){
        
    }
}