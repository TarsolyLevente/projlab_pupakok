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
     * A szoba páyla attribútuma
     */
    protected Palya palya;
      
    public Szoba(boolean gaz, int bef){
        System.out.println("Szoba -> create");
        this.gazos = gaz;
        this.befogadokepesseg = bef;
        regiszobak = new ArrayList<>();
        szomszedok = new ArrayList<>();
        hallgatok = new ArrayList<>();
        oktatok = new ArrayList<>();
        targyak = new ArrayList<>();
    }

    public Szoba(boolean gaz, int bef, Palya p){
        System.out.println("Szoba -> create");
        this.gazos = gaz;
        this.befogadokepesseg = bef;
        //TODO TÁRGY GENERÁLÁS KÖSZÖNÖM SZÉPEN
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
    }

    /**
	 * A szobából tárgyat kivevő függvény
	 * @param t a tárgy, amit kivesz a szobából
	 */
    public void targy_eltuntetese(Targy t){
        System.out.println("Szoba -> targy_eltuntetese()");
    }

    /**
	 * Egy szoba a két eredeti szobájává osztódik
	 */
    public void osztodik(){
        System.out.println("Szoba -> osztodik()");
    }

    /**   
     * A szoba egyesül a paraméterben kapott szobával
	 * @param sz a szoba, amivel egyesül
	 */
    public void egyesul(Szoba sz){
        System.out.println("Szobák -> egyesul()");
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
        return true;
    }
      
    public ArrayList<Szoba> getSzomszedok() {
        System.out.println("Szoba -> getSzomszedok()");
        return szomszedok;
    }

    public void setSzomszedok(ArrayList<Szoba> szomszedok) {
        System.out.println("Szoba -> setSzomszedok()");
        this.szomszedok = szomszedok;
    }

    /**
     * Törli a játékból a hallgatót
     */
    public void deleteHallgato(Hallgato h) {
        palya.removeHallgato(h);
        hallgatok.remove(h);
    }
    
    /*
     * public boolean isGazos() {
     * return gazos;
     * }
     * public int getBefogadokepesseg() {
     * return befogadokepesseg;
     * }
     * 
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
     * public ArrayList<Targy> getTargyak() {
     * return targyak;
     * }
     * 
     * public void setTargyak(ArrayList<Targy> targyak) {
     * this.targyak = targyak;
     * }
     */
}
