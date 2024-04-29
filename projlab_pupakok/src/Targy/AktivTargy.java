package Targy;

import Szoba.*;

public abstract class AktivTargy extends Targy {
    /**
     * Konstruktor az Aktív Tárgyakhoz
     */
    public AktivTargy(Szoba sz, String id) {
        super(Funkcio.aktiv, id, sz);
    }

    /**
     * Absztrakt függvény, amely a specifikus tárgyak esetében, azok használatáért
     * felelős.
     */
    public abstract void use();

    public abstract String toString(Funkcio funkcio);
}