import java.util.ArrayList;

public class Szoba {
    /**
	 * A szoba gázos-e vagy sem
	 */
    protected bool gazos;
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
      
    public Szoba(bool gaz, int bef){
        System.out.println("Szoba konstruktor");
        this.gazos = gaz;
        this.befogadokepesseg = bef;
        //TODO TÁRGY GENERÁLÁS KÖSZÖNÖM SZÉPEN
        regiszobak = new ArrayList<>();
        szomszedok = new ArrayList<>();
        hallgatok = new ArrayList<>();
        oktatok = new ArrayList<>();
        targyak = new ArrayList<>();
    }

    /**
	 * A szobába tárgyat lehelyező függvény
	 * @param t a tárgy, amit letesz a szobába
	 */
    public void targy_elhelyezese(Targy t){
        System.out.println("Tárgy elhelyeződött");
    }

    /**
	 * A szobából tárgyat kivevő függvény
	 * @param t a tárgy, amit kivesz a szobából
	 */
    public void targy_eltuntetese(Targy t){
        System.out.println("Tárgy etűnt");
    }

    /**
	 * Egy szoba a két eredeti szobájává osztódik
	 */
    public void osztodik(){
        System.out.println("Szoba osztódott");
    }

    /**   
     * A szoba egyesül a paraméterben kapott szobával
	 * @param sz a szoba, amivel egyesül
	 */
    public void egyesul(Szoba sz){
        System.out.println("Szobák egyesültek");
    }

    /**
	 * A gázosságot igazzá állító függvény
	 */
    public void setGaz() {
        System.out.println("Szoba -> gázos");
        this.gazos = true;
    }

    /**
	 * A szobában levő oktatók gettere
	 * @return oktatók listája
	 */
    public ArrayList<Oktato> getOktatok() {
        System.out.println("getOktatok");
        return oktatok;
    }

    /**
	 * A szobában levő hallgatók gettere
	 * @return hallgatók listája
	 */
    public ArrayList<Hallgato> getHallgatok() {
        System.out.println("getHallgatok");
        return hallgatok;
    }

    /**   
     * A paraméterben kapott oktatót törli a szoba oktatói közül
	 * @param o az oktató, akit töröl
	 */
    public void removeOktato(Oktato o){
        System.out.println("removeOktato");
    }

    /**   
     * A paraméterben kapott hallgatót törli a szoba hallgatói közül
	 * @param h az hallgató, akit töröl
	 */
    public void removeHallgato(Hallgato h){
        System.out.println("removeHallgato");
    }

    /**   
     * A paraméterben kapott oktatót hozzáadja a szoba oktatói közé
	 * @param o az oktató, akit addol
	 */
    public void addOktato(Oktato o){
        System.out.println("Oktato added");
    }

    /**   
     * A paraméterben kapott hallgatót hozzáadja a szoba hallgatói közé
	 * @param h az hallgató, akit addol
	 */
    public void addHallgato(Hallgato h){
        System.out.println("Hallgato added");
    }
      
    /*
    public boolean isGazos() {
        return gazos;
    }
    public int getBefogadokepesseg() {
        return befogadokepesseg;
    }
      
    public void setBefogadokepesseg(int befogadokepesseg) {
        this.befogadokepesseg = befogadokepesseg;
    }
      
    public ArrayList<Szoba> getRegiszobak() {
        return regiszobak;
    }
      
    public void setRegiszobak(ArrayList<Szoba> regiszobak) {
        this.regiszobak = regiszobak;
    }
      
    public ArrayList<Szoba> getSzomszedok() {
        return szomszedok;
    }
      
    public void setSzomszedok(ArrayList<Szoba> szomszedok) {
        this.szomszedok = szomszedok;
    }
      
    public void setHallgatok(ArrayList<Hallgato> hallgatok) {
        this.hallgatok = hallgatok;
    }
      
    public void setOktatok(ArrayList<Oktato> oktatok) {
        this.oktatok = oktatok;
    }
      
    public ArrayList<Targy> getTargyak() {
        return targyak;
    }
      
    public void setTargyak(ArrayList<Targy> targyak) {
        this.targyak = targyak;
    }*/
}
