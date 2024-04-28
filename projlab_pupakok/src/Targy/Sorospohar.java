package Targy;

import Karakter.Hallgato;
import Szoba.*;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Sorospohar extends PasszivTargy{
    /**
     * Rongy osztály konstruktora.
     */

    //TODO t paraméter nem kell, állíts be neki egy alapértéket (szar lesz a tárgy létrehozásánál).... ugyanez a többi t paraméternél is
    public Sorospohar(Szoba sz, String id, int t) {
        super(Funkcio.oktatotol_ved, id, sz, t);
    }

    /**
     * Meghatározza, hogy mennyi ideig használható még a Söröspohár tárgy.
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
     * A Söröspohár tárgy általi megvalósítása az absztrakt setToltet() függvénynek.
     */
    public void setToltet(){
        this.getBirtokos().getTaska().remove(this);
    }

    /**
     * A Söröspohár tárgy általi megvalósítása az absztrakt use() függvénynek.
     */
    public void use(){
        Random rand = new Random();
        int eldob = rand.nextInt(this.getBirtokos().getTaska().size() - 1);
        Hallgato h = (Hallgato) this.getBirtokos();
        h.eldob(this.getBirtokos().getTaska().get(eldob));
    }

    public String toString(Funkcio funkcio) {
        if (funkcio == null || funkcio == this.funkcio)
            return "Söröspohár";
        return "";
    }
}