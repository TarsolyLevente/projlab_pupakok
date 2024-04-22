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
     * A karakter azonosítója
     */
    protected String id;


    /**
     * Karakter konstruktora
     * @param sz Ebben a szobában jön létre.
     */

    public Karakter(Szoba sz, String i){
        szoba = sz;
        id= i;
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
        setEszmeletvesztett(true);

        for (Targy targy : taska) { // végig megyünk a táskán
            targy.setBirtokos(null);//nem lesz a tulajdonosa a tárgynak
            getSzoba().targy_elhelyezese(targy);//elhelyezzük a szobába
        }
        taska.clear(); // Minden elemet eltávolítunk a listából

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
            for (int i = 0; i < taska.size(); i++) {
                if (taska.get(i).getFunkcio() == Funkcio.oktatotol_ved) {
                    taska.get(i).use();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * táska gettere
     */
    public ArrayList<Targy> getTaska() {
        return taska;
    }
}

