package Targy;

import Szoba.*;
import Karakter.*;

public abstract class PasszivTargy extends Targy {
    /**
     * A tárgy mennyiszer használható még.
     */
    protected int toltet;

    public PasszivTargy(Szoba sz, Karakter k, Funkcio f){
        super(sz, k, f);
    }

    /**
     * Abstract metódus, minden leszármazott felüldefiniálja a saját használatának megfelelően.
     */
    public abstract void setToltet();
}