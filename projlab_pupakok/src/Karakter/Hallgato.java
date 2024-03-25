package Karakter;

import Palya.*;
import Szoba.*;
import Targy.*;

import java.util.ArrayList;


public class Hallgato extends Karakter
{
    /**
     * Hallgató konstruktora
     * @param sz Ebben a szobában lesz a hallgató
     */
    public Hallgato(Szoba sz){
        super(sz);
        System.out.println("Hallgato -> create");
    }

    /**
     * Hallgató eldob függvénye
     * @param t Ezt a tárgyat dobja el
     */

    public void eldob(Targy t) 
    {
        System.out.println("Hallgato -> eldob()");
        szoba.targy_elhelyezese(t);
        t.setBirtokos(null);
    }

    /**
     * Hallgató mozgásért felelős függvénye
     * @param sz Ebbe a szobába mozog át.
     */

    public void mozog(Szoba sz){
        System.out.println("Hallgato -> mozog()");
        if (sz.addHallgato(this)) {
            getSzoba().removeHallgato(this);
            this.setSzoba(sz);
        sz.addHallgato(this);
        if (sz.getOktatok().size() != 0) {
            kibukik();
        }
    }

    /**
     * Hallgató kibukásért felelős függvénye
     */

    public void kibukik() 
    {
        System.out.println("Hallgato -> kibukik()");
        this.getSzoba().deleteHallgato(this);
        for (Targy targy : taska) {
            targy.setSzoba(null);
            targy.setBirtokos(null);
        }
    }

    /**
     * Hallgató teleportálásért felelős függvénye
     * @param t Ehhez a teleoporthoz teleportál
     */

    public void teleport(Tranzisztor t) 
    {
        System.out.println("Hallgato -> teleport()");
        this.mozog(t.getTars().getSzoba());
        t.setAktiv(false);
        t.getTars().setAktiv(true);
    }

    /**
     * Hallgató felvesz függvénye
     * @param t Ezt veszi fel
     */
    
    public void felvesz(Targy t)
    {
        if(taska.size() < 5){
            System.out.println("Hallgato -> felvesz()");
            t.setBirtokos(this);
            t.setSzoba(null);
            szoba.targy_eltuntetese(t);
            taska.add(t);
        }
    }
}
