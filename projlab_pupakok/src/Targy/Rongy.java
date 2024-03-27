package Targy;

import Karakter.Oktato;
import Szoba.*;

public class Rongy extends PasszivTargy{

    public Rongy(Szoba sz) {
        super(sz, Funkcio.oktatot_tamad);
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
        for (Oktato oktato : getBirtokos().getSzoba().getOktatok()) {
            oktato.megbenul();
        }
    }
}
