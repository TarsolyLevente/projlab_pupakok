package Targy;

import Karakter.Hallgato;
import Szoba.*;

import java.util.Random;
import javax.swing.*;

public class Sorospohar extends PasszivTargy {
    /**
     * Rongy osztály konstruktora.
     */
    /**
     * Számláló a Timerhez.
     */
    private int counter = 0;

    public Sorospohar(Szoba sz, String id) {
        super(Funkcio.oktatotol_ved, id, sz, 0);
    }

    /**
     * Meghatározza, hogy mennyi ideig használható még a Söröspohár tárgy.
     */
    private Timer timer = new Timer(1000, e -> {
        counter++;
        if (counter == 180) {
            setToltet();
        }
    });;

    /**
     * Segít eldönteni, hogy pontosan meddig védi meg a játékost a Rongy az oktatók
     * ellen.
     * Amint a tárgyat magához veszi a hallgató, elindul egy Timer, ami idő alatt a
     * tárgy használható.
     * Ennek a Timer-nek a megfelelő nyomon követesében segít a függvény.
     * Ha lejár az idő, akkor a tárgy eltűnik a hallgató invertory-ából.
     */
    public void tick() {
        timer.start();
    }

    /**
     * A Söröspohár tárgy általi megvalósítása az absztrakt setToltet() függvénynek.
     */
    public void setToltet() {
        if (this.getBirtokos() != null)
            this.getBirtokos().getTaska().remove(this);
        else {
            this.getSzoba().getTargyak().remove(this);
        }
    }

    /**
     * A Söröspohár tárgy általi megvalósítása2
     * az absztrakt use() függvénynek.
     */
    public void use() {
        if (this.getFunkcio() != Funkcio.hamis) {
            tick();
            if (this.getBirtokos().getTaska().size() > 1) {
                Random rand = new Random();
                int eldob = rand.nextInt(this.getBirtokos().getTaska().size() - 1);
                Hallgato h = (Hallgato) this.getBirtokos();
                h.eldob(this.getBirtokos().getTaska().get(eldob));
            }
        }
    }

    public String toString(Funkcio funkcio) {
        if (funkcio == null || funkcio == this.funkcio)
            return "Söröspohár";
        return "";
    }
}