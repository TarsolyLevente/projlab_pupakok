
import java.util.Random;

public abstract class Targy {
	/**
	 * Az adott tárgy funkciójának megfelelő enumerációs attribútum.
	 * Egyedül azt dönti el pontosan, hogy milyen tárgyról is beszélünk.
	 */
	protected Funkcio funkcio;

	/**
	 * A tárgyakat egyértelműen meghatározó azonosító.
	 */
	protected String id;

	/**
	 * A szoba, ahol a tárgy megtalálható. WARNIGN - NEM CLASS DIAG-BAN.
	 */
	protected Szoba szoba;

	/**
	 * A tárgy birtokosa.
	 */
	private Karakter birtokos;

	/**
	 * Paraméteres konstruktor a Targy osztályhoz
	 * 
	 * @param f  - funkció paraméter
	 * @param i  - id paraméter
	 * @param sz - szoba paraméter
	 */
	public Targy(Funkcio f, String i, Szoba sz) {
		id = i;
		szoba = sz;
		sz.targy_elhelyezese(this);
		Random rand = new Random();
		if (rand.nextInt() % 1 == 0) {
			funkcio = f;
		} else {
			funkcio = Funkcio.hamis;
		}
	}

	/**
	 * Beállítja az adott tárgyhoz tartozó szobát, amit paraméterként kap és ahol
	 * ezek után a tárgy megtalálható lesz.
	 * 
	 * @param sz - Szoba, ahol a tárgy elhelyezkedik a pályán.
	 */
	public void setSzoba(Szoba sz) {
		szoba = sz;
	}

	/**
	 * A szoba tagváltozó getter-e.
	 */
	public Szoba getSzoba() {
		return szoba;
	}

	/**
	 * Beállítja az adott tárgyhoz tartozó gazda karaktert, amit paraméterként kap
	 * és akinél a tárgy megtalálható lesz, amíg valamilyen módon meg nem válik
	 * tőle.
	 * 
	 * @param k - A tárgy birtokosa.
	 */
	public void setBirtokos(Karakter k) {
		birtokos = k;
	}

	/**
	 * Getter függvény a Birtokos attribútumra.
	 */
	public Karakter getBirtokos() {
		return birtokos;
	}

	/**
	 * Getter függvény az Id attribútumra.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter függvény az Id attribútumra.
	 * 
	 * @param i - Id string a setter függvényhez.
	 */
	public void setId(String i) {
		id = i;
	}

	/**
	 * Getter függvény a Funkcio attribútumra.
	 */
	public Funkcio getFunkcio() {
		return funkcio;
	}

	/**
	 * Setter függvény a Funkcio attribútumra.
	 */
	public void setFunkcio(Funkcio f) {
		funkcio = f;
	}

	/**
	 * Absztrakt függvény, amely a specifikus tárgyak esetében, azok használatáért
	 * felelős.
	 */
	public abstract void use();

	public abstract String toString(Funkcio funkcio);
}