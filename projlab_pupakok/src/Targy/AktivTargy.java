package Targy;

import Szoba.*;

public abstract class AktivTargy extends Targy {
    public AktivTargy(Szoba sz) {
        super(sz, Funkcio.aktiv);
    }


    /**
     * Abstract metódus, minden leszármazott felüldefiniálja a saját használatának megfelelően.
     */
    public abstract void use();
}