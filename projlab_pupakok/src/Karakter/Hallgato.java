package Karakter;

import Palya.*;
import Szoba.*;
import Targy.*;

import java.util.ArrayList;

public class Hallgato extends Karakter
{
    public Hallgato(Szoba sz){
        super(sz);
        System.out.println("Hallgato -> create");
    }

    public void eldob(Targy t) 
    {
        System.out.println("Hallgato -> eldob()");
        szoba.targy_elhelyezese(t);
        t.setSzoba(szoba);
        t.setBirtokos(null);
    }

    public void mozog(Szoba sz){
        System.out.println("Hallgato -> mozog()");
        if (sz.getOktatok().size() != 0) {
            kibukik();
        }
    }

    public void kibukik() 
    {
        System.out.println("kibukik fv lefutott");
        this.getSzoba().deleteHallgato(this);
    }

    public void teleport(Tranzisztor t) 
    {
        System.out.println("teleport fv lefutott");
        this.mozog(t.getTars().getSzoba());
        t.setAktiv(false);
        t.getTars().setAktiv(true);
    }
    
    public void felvesz(Targy t)
    {
        if(taska.size() < 5){
            System.out.println("Hallgato -> felvesz()");
            t.setBirtokos(this);
            t.setSzoba(null);
            szoba.targy_eltuntetese(t);
        }
    }
}
