package Szoba;

import Palya.*;
import Karakter.*;
import Targy.*;

import java.util.ArrayList;

public class Szoba {
    /**
     * A szoba gázos-e vagy sem
     */
    protected boolean gazos;
    /**
     * A szoba befogadóképessége
     */
    protected int befogadokepesseg;
    /**
     * Ha két szoba egyesült, a list két tagja a két eredeti szoba
     */
    protected ArrayList<Szoba> regiszobak;
    /**
     * A szoba szomszédai / ajtói
     */
    protected ArrayList<Szoba> szomszedok;
    /**
     * A szobában tartózkodó hallgatók
     */
    protected ArrayList<Hallgato> hallgatok;
    /**
     * A szobában tartózkodó oktatók
     */
    protected ArrayList<Oktato> oktatok;
    /**
     * A szobában levő tárgyak
     */
    protected ArrayList<Targy> targyak;
    /**
     * A szoba pálya attribútuma
     */
    protected Palya palya;
    /**
     * Minden szobát egyedileg azonosít.
     */
    protected String id;
    /*
     * A szoba ragacsosságát adja meg.
     */
    protected int ragacs_cnt;

    // TODO: takarito - get, set, add, remove, ctor

    /**
     * Konstruktor
     * 
     * @param gaz gázos-e alapértelmezetten a szoba
     * @param bef a szoba befogadóképessége
     */
    public Szoba(boolean gaz, int bef) {
        System.out.println("Szoba -> create");
        palya = new Palya();
        this.gazos = gaz;
        this.befogadokepesseg = bef;
        regiszobak = new ArrayList<>();
        szomszedok = new ArrayList<>();
        hallgatok = new ArrayList<>();
        oktatok = new ArrayList<>();
        targyak = new ArrayList<>();
        id = palya.getSzobak().size();
    }

    /**
     * Konstruktor
     *
     * @param gaz gázos-e alapértelmezetten a szoba
     * @param bef a szoba befogadóképessége
     * @param p   a pálya, amihez a szoba tartozik
     */
    public Szoba(boolean gaz, int bef, Palya p) {
        System.out.println("Szoba -> create");
        this.gazos = gaz;
        this.befogadokepesseg = bef;
        regiszobak = new ArrayList<>();
        szomszedok = new ArrayList<>();
        hallgatok = new ArrayList<>();
        oktatok = new ArrayList<>();
        targyak = new ArrayList<>();
        palya = p;
        palya.addSzoba(this);
        id = palya.getSzobak().size();
    }

    /**
     * A szobába tárgyat lehelyező függvény
     * 
     * @param t a tárgy, amit letesz a szobába
     */
    public void targy_elhelyezese(Targy t) {
        System.out.println("Szoba -> targy_elhelyezese()");
        t.setSzoba(this);
        targyak.add(t);
    }

    /**
     * A szobából tárgyat kivevő függvény
     * 
     * @param t a tárgy, amit kivesz a szobából
     */
    public void targy_eltuntetese(Targy t) {
        System.out.println("Szoba -> targy_eltuntetese()");
        targyak.remove(t);
    }

    /**
     * A tárgyak lista gettere
     * 
     * @return a tárgyak listája
     */
    public ArrayList<Targy> getTargyak() {
        return targyak;
    }

    /**
     * A tárgyak lista settere
     * 
     * @param targyak a beállítandó tárgylista
     */
    public void setTargyak(ArrayList<Targy> targyak) {
        this.targyak = targyak;
    }

    /**
     * Egy szoba a két eredeti szobájává osztódik
     */
    public boolean osztodik() {
        if (!regiszobak.isEmpty()) {
            System.out.println("Szoba -> osztodik()");
            Szoba regi = regiszobak.get(1);
            Szoba uj = new Szoba(regi.gazos, regi.befogadokepesseg);
            for (Targy regitargy : regi.getTargyak()) {
                for (Targy targy : this.getTargyak()) {
                    if (regitargy == targy) {
                        this.targy_eltuntetese(targy);
                        uj.targy_elhelyezese(targy);
                    }
                }
            }
            ArrayList<Szoba> regiszomszedok = regi.getSzomszedok();
            ArrayList<Szoba> szomszedok = this.getSzomszedok();
            for (int i = 0; i < regiszomszedok.size(); i++) {
                for (int j = 0; j < szomszedok.size(); j++) {
                    if (regiszomszedok.get(i) == szomszedok.get(j)) {
                        uj.addSzomszed(szomszedok.get(j));
                        this.removeSzomszed(szomszedok.get(j));
                    }
                }
            }
            palya.addSzoba(uj);
            return true;
        }
        return false;
    }

    /**
     * A szoba egyesül a paraméterben kapott szobával
     * 
     * @param sz a szoba, amivel egyesül
     */
    public void egyesul(Szoba sz) {
        System.out.println("Szoba -> egyesul()");
        regiszobak.add(sz);
        regiszobak.add(this);
        for (Targy targy : sz.getTargyak()) {
            this.targy_elhelyezese(targy);
        }
        for (Szoba szoba : sz.getSzomszedok()) {
            if (!this.szomszedok.contains(szoba))
                this.addSzomszed(szoba);
            szoba.removeSzomszed(sz);
            szoba.addSzomszed(this);
        }
        palya.removeSzoba(sz);
    }

    /**
     * Visszaadja a szoba gázosságát
     * 
     * @return gázos-e a szoba
     */
    public boolean isGazos() {
        System.out.println("Szoba -> isGazos()");
        return gazos;
    }

    /**
     * A gázosságot igazzá állító függvény
     * 
     * @param gaz gázosság
     */
    public void setGaz(boolean gaz) {
        System.out.println("Szoba -> setGaz()");
        this.gazos = gaz;
    }

    /**
     * A szobában levő oktatók gettere
     * 
     * @return oktatók listája
     */
    public ArrayList<Oktato> getOktatok() {
        System.out.println("Szoba -> getOktatok()");
        return oktatok;
    }

    /**
     * Setter az oktatok listára.
     * 
     * @param oktatok
     */
    public void setOktatok(ArrayList<Oktato> oktatok) {
        this.oktatok = oktatok;
    }

    /**
     * A szobában levő hallgatók gettere
     * 
     * @return hallgatók listája
     */
    public ArrayList<Hallgato> getHallgatok() {
        System.out.println("Szoba -> getHallgatok()");
        return hallgatok;
    }

    /**
     * Setter a hallgatok listára.
     * 
     * @param hallgatok
     */
    public void setHallgatok(ArrayList<Hallgato> hallgatok) {
        this.hallgatok = hallgatok;
    }

    /**
     * A paraméterben kapott oktatót törli a szoba oktatói közül
     * 
     * @param o az oktató, akit töröl
     */
    public void removeOktato(Oktato o) {
        System.out.println("Szoba -> removeOktato()");
        oktatok.remove(o);
    }

    /**
     * A paraméterben kapott hallgatót törli a szoba hallgatói közül
     * 
     * @param h az hallgató, akit töröl
     */
    public void removeHallgato(Hallgato h) {
        System.out.println("Szoba -> removeHallgato()");
        hallgatok.remove(h);
    }

    /**
     * A paraméterben kapott oktatót hozzáadja a szoba oktatói közé
     * 
     * @param o az oktató, akit addol
     */
    public boolean addOktato(Oktato o) {
        System.out.println("Szoba -> addOktato()");
        if (befer()) {
            oktatok.add(o);
            if (isGazos()) {
                if (!o.vedette(Vedettseg.gaztol)) {
                    o.eszmeletvesztes();
                    return true;
                }
            }
            for (int i = 0; i < hallgatok.size(); i++) {
                if (!hallgatok.get(i).vedette(Vedettseg.oktatotol))
                    hallgatok.get(i).kibukik();
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * A paraméterben kapott hallgatót hozzáadja a szoba hallgatói közé
     * 
     * @param h az hallgató, akit addol
     */
    public boolean addHallgato(Hallgato h) {
        System.out.println("Szoba -> addHallgato()");
        if (befer()) {
            hallgatok.add(h);
            if (isGazos()) {
                if (!h.vedette(Vedettseg.gaztol)) {
                    h.eszmeletvesztes();
                }
            }
            if (oktatok.size() != 0) {
                if (!h.vedette(Vedettseg.oktatotol)) {
                    h.kibukik();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * A szoba szomszédainak listájának gettere
     * 
     * @return Szomszédok listája
     */
    public ArrayList<Szoba> getSzomszedok() {
        System.out.println("Szoba -> getSzomszedok()");
        return szomszedok;
    }

    /**
     * A szoba szomszédainak listájának settere
     * 
     * @param szomszedok
     */
    public void setSzomszedok(ArrayList<Szoba> szomszedok) {
        System.out.println("Szoba -> setSzomszedok()");
        this.szomszedok = szomszedok;
    }

    /**
     * Törli a játékból a hallgatót
     * 
     * @param A játékból törlendő hallgató
     */
    public void deleteHallgato(Hallgato h) {
        palya.removeHallgato(h);
        System.out.println("Palya -> hallgatok.remove(Hallgato)");
        if (palya.getHallgatok().size() == 0)
            palya.getGame().endgame();
    }

    /*
     * A paraméterben kapott szobát hozzáadja a szoba szomszédai közé
     * 
     * @param sz új szomszéd
     */
    public void addSzomszed(Szoba sz) {
        System.out.println("Szoba -> addSzomszed()");
        szomszedok.add(sz);
    }

    /**
     * A paraméterben kapott szobát törli a szoba szomszédai közül
     * 
     * @param sz törlendő szomszéd
     */
    public void removeSzomszed(Szoba sz) {
        System.out.println("Szoba -> removeSzomszed()");
        szomszedok.remove(sz);
    }

    /**
     * A szoba befogadóképességének gettere
     * 
     * @return befogadóképesség
     */
    public int getBefogadokepesseg() {
        System.out.println("Szoba -> getBefogadokepesseg()");
        return befogadokepesseg;
    }

    /**
     * A szoba befogadóképességének settere
     * 
     * @param befogadokepesseg befogadóképesség
     */
    public void setBefogadokepesseg(int befogadokepesseg) {
        this.befogadokepesseg = befogadokepesseg;
    }

    /**
     * Getter az id attribútumra.
     * 
     * @return id
     */
    public String getid() {
        return id;
    }

    /**
     * Setter az id attribútumra.
     * 
     * @param str id
     */
    public void setid(String str) {
        id = str;
    }

    /**
     * Getter a ragacs_cnt attribútumra.
     * 
     * @return ragacs számláló értéke
     */
    public int getRagacs_cnt() {
        return ragacs_cnt;
    }

    /**
     * Setter a ragacs_cnt attribútumra.
     * 
     * @param r ragacs szám
     */
    public void setRagacs_cnt(int r) {
        ragacs_cnt = r;
    }

    /**
     * Visszaadja, hogy ragacsos-e a szoba
     * 
     * @return ragacsosság
     */
    public boolean isRagacsos() {
        if (ragacs_cnt >= Integer.MAX_VALUE) // TODO MENNYI
            return true;
        return false;
    }

    /**
     * Visszadja, hogy befér-e még egy karakter a szobába
     * 
     * @return befér-e
     */
    private boolean befer() {
        if (befogadokepesseg - (hallgatok.size() + oktatok.size() + takaritok.size()) >= 1)
            return false;
        return true;
    }

    /**
     * A regiszobak lista gettere
     * 
     * @return régi szobák listája
     */
    public ArrayList<Szoba> getRegiszobak() {
        return regiszobak;
    }

    /**
     * A regiszobak lista settere
     * 
     * @param regiszobak régi szobák listája
     */
    public void setRegiszobak(ArrayList<Szoba> regiszobak) {
        this.regiszobak = regiszobak;
    }
}
