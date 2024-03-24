package Targy;

import Szoba.*;

public class Rongy extends PasszivTargy{

    public Rongy(Szoba sz) {
        super(sz, Funkcio.oktatotol_ved);
        System.out.println("Rongy -> create");
    }

    /**
     * Az idő múlását határozza meg
     */
    public void tick() {
        System.out.println("Rongy -> tick()");
    }

    /**
     * Az absztrakt setToltet() függvény megvalósítása a Rongy által
     */
    public void setToltet() {
        System.out.println("Rongy -> setToltet()");
    }

    public void use(){
        
    }
}
