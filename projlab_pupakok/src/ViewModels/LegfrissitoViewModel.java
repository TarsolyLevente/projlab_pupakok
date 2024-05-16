package ViewModels;

import javax.swing.ImageIcon;

import Targy.*;

public class LegfrissitoViewModel extends ItemViewModel{
    /**
     * Légfrissítő attribútum
     */
    private Legfrissito legfrissito;

    /**
     * Setter függvény a Légfrissítő attribútumhoz.
     * @param l - A beállítandó tárgy.
     */
    public void setLegfrissito(Legfrissito l) {
        legfrissito = l;
    }

    /**
     * Getter függvény a Légfrissítő attribútumhoz.
     */
    public Targy getLegfrissito() {
        return legfrissito;
    }

    /**
     * Használja a Légfrissítő tárgyat.
     */
    public void useLegfrissito() {
        legfrissito.use();
    }

    /**
     * Az absztrakt getItemImage megvalósítása a Légfrissítő által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/legfrissito.png");
    }
}
