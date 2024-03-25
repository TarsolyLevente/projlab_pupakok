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
     * Konstruktor
     * 
     * @param gaz gázos-e alapértelmezetten a szoba
     * @param bef a szoba befogadóképessége
     */
    public Szoba(boolean gaz, int bef){
        System.out.println("Szoba -> create");
        palya = new Palya();
        this.gazos = gaz;
        this.befogadokepesseg = bef;
        regiszobak = new ArrayList<>();
        szomszedok = new ArrayList<>();
        hallgatok = new ArrayList<>();
        oktatok = new ArrayList<>();
        targyak = new ArrayList<>();
    }

    /**
     * Konstruktor
     *
     * @param gaz gázos-e alapértelmezetten a szoba
     * @param bef a szoba befogadóképessége
     * @param p a pálya, amihez a szoba tartozik
     */
    public Szoba(boolean gaz, int bef, Palya p){
        System.out.println("Szoba -> create");
        this.gazos = gaz;
        this.befogadokepesseg = bef;
        regiszobak = new ArrayList<>();
        szomszedok = new ArrayList<>();
        hallgatok = new ArrayList<>();
        oktatok = new ArrayList<>();
        targyak = new ArrayList<>();
        palya = p;
    }

    /**
	 * A szobába tárgyat lehelyező függvény
	 * @param t a tárgy, amit letesz a szobába
	 */
    public void targy_elhelyezese(Targy t){
        System.out.println("Szoba -> targy_elhelyezese()");
        t.setSzoba(this);
        targyak.add(t);
    }

    /**
	 * A szobából tárgyat kivevő függvény
	 * @param t a tárgy, amit kivesz a szobából
	 */
    public void targy_eltuntetese(Targy t){
        System.out.println("Szoba -> targy_eltuntetese()");
        targyak.remove(t);
    }

    public ArrayList<Targy> getTargyak() {
        return targyak;
    }

    /**
	 * Egy szoba a két eredeti szobájává osztódik
	 */
    public void osztodik() {
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
    }

    /**   
     * A szoba egyesül a paraméterben kapott szobával
	 * @param sz a szoba, amivel egyesül
	 */
    public void egyesul(Szoba sz){
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

    public boolean isGazos() {
        System.out.println("Szoba -> isGazos()");
        return gazos;
    }

    /**
	 * A gázosságot igazzá állító függvény
	 */
    public void setGaz() {
        System.out.println("Szoba -> setGaz()");
        this.gazos = true;
    }

    /**
	 * A szobában levő oktatók gettere
	 * @return oktatók listája
	 */
    public ArrayList<Oktato> getOktatok() {
        System.out.println("Szoba -> getOktatok()");
        return oktatok;
    }

    /**
	 * A szobában levő hallgatók gettere
	 * @return hallgatók listája
	 */
    public ArrayList<Hallgato> getHallgatok() {
        System.out.println("Szoba -> getHallgatok()");
        return hallgatok;
    }

    /**   
     * A paraméterben kapott oktatót törli a szoba oktatói közül
	 * @param o az oktató, akit töröl
	 */
    public void removeOktato(Oktato o){
        System.out.println("Szoba -> removeOktato()");
    }

    /**   
     * A paraméterben kapott hallgatót törli a szoba hallgatói közül
	 * @param h az hallgató, akit töröl
	 */
    public void removeHallgato(Hallgato h){
        System.out.println("Szoba -> removeHallgato()");
    }

    /**   
     * A paraméterben kapott oktatót hozzáadja a szoba oktatói közé
	 * @param o az oktató, akit addol
	 */
    public boolean addOktato(Oktato o){
        System.out.println("Szoba -> addOktato()");
        if(oktatok.size() + hallgatok.size() < befogadokepesseg - 1){
            oktatok.add(o);
            if (gazos) {
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
	 * @param h az hallgató, akit addol
	 */
    public boolean addHallgato(Hallgato h){
        System.out.println("Szoba -> addHallgato()");
        hallgatok.add(h);
        return true;
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
     */
    public void deleteHallgato(Hallgato h) {
        hallgatok.remove(h);
        palya.removeHallgato(h);
        System.out.println("Palya -> hallgatok.remove(Hallgato)");
        if (palya.getHallgatok().size() == 0)
            palya.getGame().endgame();
    }
    
    /*
     * public boolean isGazos() {
     * return gazos;
     * }
     * public int getBefogadokepesseg() {
     * return befogadokepesseg;
     * }
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
     * A szoba befagadóképességének gettere
     * 
     * @return befogadóképesség
     */
    public int getBefogadokepesseg() {
        System.out.println("Szoba -> getBefogadokepesseg()");
        return befogadokepesseg;
    }

    /*
     * public void setBefogadokepesseg(int befogadokepesseg) {
     * this.befogadokepesseg = befogadokepesseg;
     * }
     * 
     * public ArrayList<Szoba> getRegiszobak() {
     * return regiszobak;
     * }
     * 
     * public void setRegiszobak(ArrayList<Szoba> regiszobak) {
     * this.regiszobak = regiszobak;
     * }
     * 
     * public void setHallgatok(ArrayList<Hallgato> hallgatok) {
     * this.hallgatok = hallgatok;
     * }
     * 
     * public void setOktatok(ArrayList<Oktato> oktatok) {
     * this.oktatok = oktatok;
     * }
     * 
     * 
     * public void setTargyak(ArrayList<Targy> targyak) {
     * this.targyak = targyak;
     * }
     */
}
