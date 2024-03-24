package Karakter;

import Palya.*;
import Szoba.*;
import Targy.*;

public class Oktato extends Karakter
{
    private boolean megbenult;

    public Oktato(Szoba sz){
        super(sz);
        System.out.println("Oktato -> create");
    }

    public void mozog(Szoba sz){
        System.out.println("Oktato -> mozog()");
        if(sz.addOktato(this)){
            getSzoba().removeOktato(this);
            this.setSzoba(sz);
        }
    }

    public void megbenul() 
    {
        System.out.println("megbenul fv lefutott");
    }

    public void felvesz(Targy t)
    {
        System.out.println("Oktato -> felvesz()");
        t.setBirtokos(this);
        t.setSzoba(null);
        szoba.targy_eltuntetese(t);
    }
}
