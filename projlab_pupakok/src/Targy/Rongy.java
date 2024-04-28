package Targy;

import Szoba.*;

import java.util.Timer;
import java.util.TimerTask;

public class Rongy extends PasszivTargy{
    /**
     * Rongy osztály konstruktora.
     */
    public Rongy(Szoba sz, String id, int t) {
        super(Funkcio.oktatotol_ved, id, sz, t);
    }

    /**
     * Meghatározza, hogy mennyi ideig használható még a Rongy tárgy.
     */
    private Timer timer;

    /**
     * Segít eldönteni, hogy pontosan meddig védi meg a játékost a Rongy az oktatók ellen.
     * Amint a tárgyat magához veszi a hallgató, elindul egy Timer, ami idő alatt a tárgy használható.
     * Ennek a Timer-nek a megfelelő nyomon követesében segít a függvény.
     * Ha lejár az idő, akkor a tárgy eltűnik a hallgató invertory-ából.
     */
    public void tick(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setToltet();
            }
        }, 5 * 60 * 1000);
    }

    /**
     * A Rongy tárgy általi megvalósítása az absztrakt setToltet() függvénynek.
     */
    public void setToltet(){
        this.getBirtokos().getTaska().remove(this);
    }

    /**
     * A Rongy tárgy általi megvalósítása az absztrakt use() függvénynek.
     */
    public void use(){
        //hát így kinda nem csinál semmit
    }

    public String toString(Funkcio funkcio) {
        if (funkcio == null || funkcio == this.funkcio)
            return "Rongy";
        return "";
    }
}