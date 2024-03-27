package Karakter;

import Palya.*;
import Szoba.*;
import Targy.*;

public class Oktato extends Karakter
{
    /**
     * Megbénult-e tárgy hatására.
     */
    private boolean megbenult;

    /**
     * Oktató mozog függvénye
     * @param sz Ide mozog át
     */
    public Oktato(Szoba sz){
        super(sz);
        sz.addOktato(this);
        System.out.println("Oktato -> create");
    }

    /**
     * Hallgató mozgásért felelős függvénye
     * @param sz Ebbe a szobába mozog át.
     */
    public void mozog(Szoba sz){
        System.out.println("Oktato -> mozog()");
        sz.addOktato(this);
        if(sz.addOktato(this)){
            getSzoba().removeOktato(this);
            this.setSzoba(sz);
        }
    }

    /**
     * Oktató megbénul függvénye
     */
    public void megbenul() 
    {
        System.out.println("Oktato -> megbenul()");
    }

    /**
     * Oktató felvesz függvénye
     * @param t Ezt veszi fel
     */
    public void felvesz(Targy t)
    {
        System.out.println("Oktato -> felvesz()");
        t.setBirtokos(this);
        t.setSzoba(null);
        szoba.targy_eltuntetese(t);
    }
}
