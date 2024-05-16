package ViewModels;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;

import Targy.*;

public abstract class ItemViewModel {
    /**
     * Tárgy attribútum
     */
    private Targy targy;

    /**
     * Setter függvény a Tárgy attribútumhoz.
     * @param t - A beállítandó tárgy.
     */
    public void setTargy(Targy t) {
        targy = t;
    }

    /**
     * Getter függvény a Tárgy attribútumhoz.
     */
    public Targy getTargy() {
        return targy;
    }

    /**
     * Absztrakt függvény, amit minden tárgy külön-külön megvalósít és visszaad egy kép ikont a megfelelő megjelenítéshez.
     */
    public abstract ImageIcon getItemImage();
}
