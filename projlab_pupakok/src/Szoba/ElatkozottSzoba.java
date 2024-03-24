package Szoba;

import Palya.*;
import Karakter.*;
import Targy.*;

import java.util.ArrayList;
/**
* Olyan szoba, amely ajtajai képesek eltűnni és előtűnni
*/
public class ElatkozottSzoba extends Szoba{
    /**
	 * Az eltűnt ajtók listája
	 */
    private ArrayList<Szoba> eltuntajto;

    /**
     * Elatkozott szoba konstruktora
     */
    public ElatkozottSzoba(boolean gaz, int bef){
        super(gaz, bef);
        System.out.println("ElatkozottSzoba -> create");
    }

    /**
	 * Ajtó eltűnésének függvénye
	 * @param sz Eltűnő szomszéd
	 */
    public void eltunik(Szoba sz){
        System.out.println("ElatkozottSzoba -> eltunik()");
    }
    /**
	 * Ajtó előtűnésének függvénye
	 * @param sz Előtűnő szomszéd
	 */
    public void elotunik(Szoba sz){
        System.out.println("ElatkozottSzoba -> elotunik()");
    }
}
