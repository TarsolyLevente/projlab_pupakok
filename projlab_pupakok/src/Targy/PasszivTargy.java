package Targy;

import Szoba.*;

public abstract class PasszivTargy extends Targy {
    /**
     * A tárgy mennyiszer használható még.
     */
    protected int toltet;

    public PasszivTargy(Szoba sz, Funkcio f) {
        super(sz, f);
    }

    /**
     * Abstract metódus, minden leszármazott felüldefiniálja a saját használatának megfelelően.
     */
    public abstract void setToltet();
}