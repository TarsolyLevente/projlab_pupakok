package Targy;

import Szoba.*;
import Karakter.*;

public abstract class Targy {
	/**
	 * Privát és protected tagváltozók.
	 */
	/**
	 * A szoba ahol a tárgy megtalálható.
	 */
	private Szoba szoba;
	/**
	 * A tárgy birtokosa.
	 */
	private Karakter birtokos;
	/**
	 * A tárgy funkciója.
	 */
	protected Funkcio funkcio;

	/**
	 * Targy konstruktora
	 * 
	 * @param sz Szoba értéke
	 * @param k  Birtokos értéke
	 * @param f  Funkcio értéke
	 */
	public Targy(Szoba sz, Funkcio f) {
		szoba = sz;
		birtokos = null;
		funkcio = f;
	}

	/**
	 * A szoba tagváltozó setter-e.
	 * 
	 * @param sz A szoba tagváltozó kapott értéke.
	 */
	public void setSzoba(Szoba sz) {
		szoba = sz;
		System.out.println("Targy -> setSzoba(Szoba)");
	}

	/**
	 * A birtokos tagváltozó setter-e.
	 * 
	 * @param k A birtokos tagváltozó kapott értéke.
	 */
	public void setBirtokos(Karakter k) {
		birtokos = k;
		System.out.println("Targy -> setBirtokos(Karakter)");
	}

	/**
	 * Getter a birtokos attribútumra.
	 * 
	 * @return birtokos
	 */
	public Karakter getBirtokos() {
		System.out.println("Targy -> getBirtokos()");
		return birtokos;
	}

	/**
	 * Abstract metódus, minden leszármazott felüldefiniálja a saját használatának
	 * megfelelően.
	 */
	public abstract void use();
}
