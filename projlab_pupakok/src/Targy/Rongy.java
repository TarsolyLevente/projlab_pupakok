package Targy;

import Szoba.*;

import javax.swing.*;

public class Rongy extends PasszivTargy {
    /**
     * Rongy osztály konstruktora.
     */
    public Rongy(Szoba sz, String id) {
        super(Funkcio.oktatotol_ved, id, sz, 0);
    }

    /**
     * Számláló a Timerhez.
     */
    private int counter = 0;

    /**
     * Meghatározza, hogy mennyi ideig használható még a Rongy tárgy.
     */
    Timer t = new Timer(1000, e -> {
        counter++;
        if (counter == 180) {
            setToltet();
        }
    });

    /**
     * Segít eldönteni, hogy pontosan meddig védi meg a játékost a Rongy az oktatók
     * ellen.
     * Amint a tárgyat magához veszi a hallgató, elindul egy Timer, ami idő alatt a
     * tárgy használható.
     * Ennek a Timer-nek a megfelelő nyomon követesében segít a függvény.
     * Ha lejár az idő, akkor a tárgy eltűnik a hallgató invertory-ából.
     */
    public void tick() {
        t.start();
    }

    /**
     * A Rongy tárgy általi megvalósítása az absztrakt setToltet() függvénynek.
     */
    public void setToltet() {
        if (this.getBirtokos() != null)
            this.getBirtokos().getTaska().remove(this);
        else {
            this.getSzoba().getTargyak().remove(this);
        }
    }

    /**
     * A Rongy tárgy általi megvalósítása az absztrakt use() függvénynek.
     */
    public void use(){
        if(this.getFunkcio() != Funkcio.hamis){
            tick();
        }
    }

    /**
     * Visszaadja az objektum szöveges reprezentációját a Funkcio attribútum alapján.
     */
    public String toString(Funkcio funkcio) {
        if (funkcio == null || funkcio == this.funkcio)
            return "Rongy";
        return "";
    }
}