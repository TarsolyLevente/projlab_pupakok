

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Logarlec extends Targy{
	/**
	 * Logarlec konstruktora
	 * @param sz Szoba értéke
	 * @param k Birtokos értéke
	 * @param f Funkcio értéke
	 */
	public Logarlec(Szoba sz, Hallgato k, Funkcio f) {
		super(sz, k, f);
		System.out.println("Logarlec -> create");
	}
	
	/**
	 * Logarlec setBirtokos függvénye, benne a propertyChange-hez szükséges firePropertyChange.
	 */
	public void setBirtokos(Karakter k) {
		Karakter oldBirtokos = this.getBirtokos();
		super.setBirtokos(k);
		Karakter ujBirtokos = this.getBirtokos();
		
		firePropertyChange("birtokos", oldBirtokos, ujBirtokos);
	}
	
	/**
	 * firePropertyChange metódus, hogy nyomon lehessen követni, mikor veszik fel a Logarlecet.
	 * @param propertyName
	 * @param oldValue
	 * @param newValue
	 */
    private void firePropertyChange(String propertyName, Karakter oldValue, Karakter newValue) {
        PropertyChangeEvent event = new PropertyChangeEvent(this, propertyName, oldValue, newValue);
        
        new LogarlecPropertyChangeListener().propertyChange(event);
    }
	
	/**
	 * Logarléc use függvénye.
	 */
	public void use() {
		System.out.println("Logarlec -> use()");
	}
}
