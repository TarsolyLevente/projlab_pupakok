package Karakter;

import Palya.*;
import Szoba.*;
import Targy.*;

import java.util.ArrayList;

public class Hallgato extends Karakter
{
    public Hallgato(Szoba sz){
        super(sz);
    }

    public void eldob(Targy t) 
    {
        System.out.println("eldob fv lefutott");
    }

    public void kibukik() 
    {
        System.out.println("kibukik fv lefutott");
    }

    public void teleport(Tranzisztor t) 
    {
        System.out.println("teleport fv lefutott");
    }
    
    public void felvesz(Targy t)
    {
        if(taska.size() < 5){
            System.out.println("felvesz fv lefutott");
            t.setBirtokos(this);
            t.setSzoba(null);
            szoba.targy_eltuntetese(t);
        }
    }
}
