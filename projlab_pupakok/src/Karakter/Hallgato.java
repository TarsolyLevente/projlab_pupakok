package Karakter;

import Szoba.*;
import Targy.*;

public class Hallgato extends Karakter {

    /**
     * Hallgató konstruktora
     * 
     * @param sz Ebben a szobában lesz a hallgató
     */
    public Hallgato(Szoba sz, String id) {
        super(sz, id);
        sz.getHallgatok().add(this);
    }

    /**
     * Hallgató eldob függvénye
     * 
     * @param t Ezt a tárgyat dobja el
     */

    public void eldob(Targy t) {
        szoba.targy_elhelyezese(t);
        t.setBirtokos(null);
        taska.remove(t);
    }

    /**
     * Hallgató mozgásért felelős függvénye
     * 
     * @param sz Ebbe a szobába mozog át.
     */

    public void mozog(Szoba sz) {

        if (sz.addHallgato(this)) {
            getSzoba().removeHallgato(this);
            this.setSzoba(sz);
            if (getSzoba().getRagacs_cnt() != -1) {
                getSzoba().setRagacs_cnt(getSzoba().getRagacs_cnt() + 1);
            }

            for (Targy targy : taska) {
                targy.setSzoba(sz);
            }

        }
    }

    /**
     * Hallgató kibukásért felelős függvénye
     */

    public void kibukik() {

        for (Targy targy : taska) {
            targy.setSzoba(null);
            targy.setBirtokos(null);
        }
        System.out.println("Hallgató " + id + " kibukott!");
        this.getSzoba().deleteHallgato(this);
    }

    /**
     * Hallgató teleportálásért felelős függvénye
     * 
     * @param t Ehhez a teleoporthoz teleportál
     */

    public void teleport(Tranzisztor t) {
        if (t.getAktiv()) {
            this.mozog(t.getTars().getSzoba());
            t.setAktiv(false);
            t.getTars().setAktiv(true);
        }
    }

    /**
     * Hallgató felvesz függvénye
     * 
     * @param t Ezt veszi fel
     */
    public void felvesz(Targy t) { // TODO regiszobakbol is ki kell venni
        if (!getSzoba().isRagacsos()) {
            if (taska.size() < 5) {
                if (t instanceof Tranzisztor) {
                    int tranzisztorSzam = 0;
                    // Számoljuk meg, hány tranzisztor van már a taskában
                    for (Targy targy : taska) {
                        if (targy instanceof Tranzisztor) {
                            tranzisztorSzam++;
                        }
                        if (tranzisztorSzam >= 2) {
                            System.out.println("Nem vehetsz fel több tranzisztort!");
                            return;
                        }

                        else {
                            for (Targy targy2 : taska) {
                                if (targy2 instanceof Tranzisztor && targy2.getFunkcio() != Funkcio.hamis
                                        && t.getFunkcio() != Funkcio.hamis) {
                                    ((Tranzisztor) targy2).setTars((Tranzisztor) t);
                                    ((Tranzisztor) t).setTars((Tranzisztor) targy2);
                                }
                            }
                        }
                    }
                }
                if (t instanceof Rongy) {
                    t.use();
                }
                t.setBirtokos(this);
                getSzoba().targy_eltuntetese(t);
                taska.add(t);
            }
        }
        return;
    }

}
