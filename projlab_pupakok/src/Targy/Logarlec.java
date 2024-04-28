package Targy;

import Szoba.*;
import Karakter.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Logarlec extends Targy{
	/**
	 * PropertyChangeSupport attribútum
	 */
	private final PropertyChangeSupport support = new PropertyChangeSupport(this);
	/**
	 * Logarlec konstruktora
	 * @param sz Szoba értéke
	 * @param k Birtokos értéke
	 * @param f Funkcio értéke
	 */
	public Logarlec(Szoba sz) {
		super(Funkcio.logarlec, "0", sz);
		System.out.println("Logarlec -> create");
	}
	
	/**
	 * Logarlec setBirtokos függvénye, benne a propertyChange-hez szükséges firePropertyChange.
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
		System.out.println("Logarlec -> use()");
	}

	/**
	 * addPropertyChangeListener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) { support.addPropertyChangeListener(listener); }

	public String toString(Funkcio funkcio) {
		if (funkcio == null || funkcio == this.funkcio)
			return "Logarléc";
		return "";
	}
}
