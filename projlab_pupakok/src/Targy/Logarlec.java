package Targy;

import Szoba.*;
import Karakter.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Logarlec extends Targy {
	/**
	 * PropertyChangeSupport attribútum
	 */
	private final PropertyChangeSupport support = new PropertyChangeSupport(this);

	/**
	 * Logarlec konstruktora
	 * 
	 * @param sz Szoba értéke
	 * @param k  Birtokos értéke
	 * @param f  Funkcio értéke
	 */
	public Logarlec(Funkcio f, Szoba sz, String id) {
		super(f, id, sz);
	}

	/**
	 * Logarlec setBirtokos függvénye, benne a propertyChange-hez szükséges
	 * firePropertyChange.
	 */
	public void setBirtokos(Karakter k) {
		Karakter oldBirtokos = this.getBirtokos();
		super.setBirtokos(k);
		Karakter ujBirtokos = this.getBirtokos();

		support.firePropertyChange("birtokos", oldBirtokos, ujBirtokos);
	}

	/**
	 * Logarléc use függvénye.
	 */
	public void use() {
	}

	/**
	 * addPropertyChangeListener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	/**
     * Visszaadja az objektum szöveges reprezentációját a Funkcio attribútum alapján.
     */
	public String toString(Funkcio funkcio) {
		if (funkcio == null || funkcio == this.funkcio)
			return "Logarléc";
		return "";
	}
}
