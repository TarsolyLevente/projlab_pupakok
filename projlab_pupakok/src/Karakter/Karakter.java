package Karakter;

import Palya.*;
import Szoba.*;
import Targy.*;

import java.util.*;

public abstract class Karakter 
{
    /**
     * Jelenleg cselekvőképes-e a karakter
     */
    protected boolean eszmeletvesztett;

    /**
     * Ebben tartózkodik a karakter
     */
    protected Szoba szoba;

    /**
     * Ebben tárolódnak a tárgyak
     */
    protected ArrayList<Targy> taska;

    /**
     * Karakter konstruktora
     * @param sz Ebben a szobában jön létre.
     */

    public Karakter(Szoba sz){
        szoba = sz;
        taska = new ArrayList<Targy>();
    }

    /**
     * eszmeletvesztett gettere
     */
    public boolean getEszmeletvesztett() 
    {

        return eszmeletvesztett;
    }

    /**
     * eszmeletvesztett settere
     */
    public void setEszmeletvesztett(boolean eszmeletvesztett) 
    {
        this.eszmeletvesztett = eszmeletvesztett;
    }

    /**
     * szoba gettere
     */
    public Szoba getSzoba() 
    {
        return szoba;
    }

    /**
     * szoba settere
     */
    public void setSzoba(Szoba szoba) 
    {
        this.szoba = szoba;
    }

    /**
     * Karakter absztrakt mozog függvénye
     * @param sz Ide mozog át
     */
    public abstract void mozog(Szoba sz);
   
    /**
     * Karakter absztrakt felvesz függvénye
     * @param t Ezt a tárgyat veszi fel
     */
    public abstract void felvesz(Targy t);


/**
     * Karakter eszmeletvesztes függvénye
     */
    public void eszmeletvesztes()
    {
        System.out.println("Karakter -> eszmeletvesztes()");
    }

    /**
     * Függvény ami megmutatja mi ellen védett
     * @param v Ez ellen védett-e
     */

    public boolean vedette(Vedettseg v)
    {
        System.out.println("Karakter ->vedette()");
        if (v == Vedettseg.oktatotol) {
            for (int i = 0; i < taska.size(); i++) {
                if (taska.get(i).getFunkcio() == Funkcio.oktatot_tamad) {
                    taska.get(i).use();
                    return true;
                }
            }
        }
        return false;
    }
}

