package Karakter;

import Palya.*;
import Szoba.*;
import Targy.*;

import java.util.*;

public abstract class Karakter 
{
    protected boolean eszmeletvesztett;
    protected Szoba szoba;
    protected ArrayList<Targy> taska;

    public Karakter(Szoba sz){
        szoba = sz;
        taska = new ArrayList<Targy>();
    }

    public boolean getEszmeletvesztett() 
    {

        return eszmeletvesztett;
    }

    public void setEszmeletvesztett(boolean eszmeletvesztett) 
    {
        this.eszmeletvesztett = eszmeletvesztett;
    }

    public Szoba getSzoba() 
    {
        return szoba;
    }

    public void setSzoba(Szoba szoba) 
    {
        this.szoba = szoba;
    }

    public abstract void mozog(Szoba sz);
   
    public abstract void felvesz(Targy t);

    public void eszmeletvesztes()
    {
        System.out.println("eszmeletvesztes fv lefutott");
    }

    public boolean vedette(Védettség v)
    {
        System.out.println("vedette fv lefutott");
        return false;
    }
}

