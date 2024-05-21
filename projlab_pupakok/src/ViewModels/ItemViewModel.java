package ViewModels;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;

import Targy.*;

/**
 * A ItemViewModel osztály, amelyből származtathatóak tárgyakar reprezentáló a nézetek.
 */
public abstract class ItemViewModel {
    /**
     * Absztrakt függvény, amit minden tárgy külön-külön megvalósít és visszaad egy kép ikont a megfelelő megjelenítéshez.
     */
    public abstract ImageIcon getItemImage();
}
