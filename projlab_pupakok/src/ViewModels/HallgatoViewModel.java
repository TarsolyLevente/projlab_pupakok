package ViewModels;

import Karakter.Hallgato;
import Szoba.Szoba;
import Targy.Targy;
import Targy.Tranzisztor;
import Views.RoomFrame;

public class HallgatoViewModel {
    private Hallgato hallgato;

    /**
     * Visszaadja a Hallgato objektumot.
     * 
     * @return A Hallgato objektum.
     */
    public Hallgato getHallgato() {
        return hallgato;
    }

    /**
     * Beállítja a Hallgato objektumot.
     * 
     * @param hallgato A beállítandó Hallgato objektum.
     */
    public void setHallgato(Hallgato hallgato) {
        this.hallgato = hallgato;
    }

    /**
     * Mozgatja a Hallgato objektumot a megadott Szoba objektumba.
     * 
     * @param szoba A Szoba objektum, amelybe mozgatni kell.
     */
    public void mozgas() {
        RoomFrame rf = new RoomFrame(this);
    }

    /**
     * Használja a megadott Targy objektumot.
     * 
     * @param targy A használandó Targy objektum.
     */
    public void hasznal(int i) {
        hallgato.getTaska().get(i).use();
    }

    /**
     * Elhagyja a Hallgato által tartott megadott Targy objektumot.
     * 
     * @param targy Az eldobandó Targy objektum.
     */
    public void eldob(int i) {
        hallgato.eldob(hallgato.getTaska().get(i));
    }

    /**
     * Felveszi a megadott Targy objektumot és hozzáadja a Hallgato tárgyainak
     * listájához.
     * 
     * @param targy A felveendő Targy objektum.
     */
    public void felvesz(Targy targy) {
        hallgato.felvesz(targy);
    }

    /**
     * Teleportálja a Hallgato objektumot a megadott Tranzisztor objektum
     * segítségével.
     * 
     * @param t A teleportáláshoz használt Tranzisztor objektum.
     */
    public void teleportal(Tranzisztor t) {
        hallgato.teleport(t);
    }
}
