package Szoba;

import Palya.*;

import java.util.ArrayList;

/**
 * Olyan szoba, amely ajtajai képesek eltűnni és előtűnni
 */
public class ElatkozottSzoba extends Szoba {
    /**
     * Az eltűnt ajtók listája
     */
    private ArrayList<Szoba> eltuntajto;

    /**
     * Elatkozott szoba konstruktora
     */
    public ElatkozottSzoba(String id, boolean gaz, int bef, Palya p) {
        super(id, gaz, bef, p);
        eltuntajto = new ArrayList<>();
    }

    /**
     * Ajtó eltűnésének függvénye
     * 
     * @param sz Eltűnő szomszéd
     */
    public void eltunik(Szoba sz) {
        eltuntajto.add(sz);
        sz.removeSzomszed(this);
        removeSzomszed(sz);
    }

    /**
     * Ajtó előtűnésének függvénye
     * 
     * @param sz Előtűnő szomszéd
     */
    public void elotunik(Szoba sz) {
        szomszedok.add(sz);
        sz.addSzomszed(this);
        eltuntajto.remove(sz);
    }

    /**
     * Visszaadja az eltuntajto listát.
     * 
     * @return
     */
    public ArrayList<Szoba> getEltuntajto() {
        return eltuntajto;
    }

    /**
     * Setter az eltuntajto attribútumra.
     * 
     * @param e
     */
    public void setEltuntajto(ArrayList<Szoba> e) {
        eltuntajto = e;
    }

    /**
     * Hozzáadja a paraméterben kapott szobát az eltuntajto listához.
     * 
     * @param sz
     */
    public void addEltuntajto(Szoba sz) {
        eltuntajto.add(sz);
    }

    /**
     * Eltávolítja a paraméterben kapott szobát az eltuntajto listából.
     * 
     * @param sz
     */
    public void removeEltuntajto(Szoba sz) {
        eltuntajto.remove(sz);
    }
}
