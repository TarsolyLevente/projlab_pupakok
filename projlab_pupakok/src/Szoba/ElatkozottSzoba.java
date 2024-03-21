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
	 * Ajtó eltűnésének függvénye
	 * @param sz Eltűnő szomszéd
	 */
    public void eltunik(Szoba sz){
        System.out.println("Ajtó eltűnt");
    }
    /**
	 * Ajtó előtűnésének függvénye
	 * @param sz Előtűnő szomszéd
	 */
    public void elotunik(Szoba sz){
        System.out.println("Ajtó előtűnt");
    }
}
