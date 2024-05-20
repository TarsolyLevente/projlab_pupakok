package ViewModels;

import javax.swing.ImageIcon;

import Targy.*;

public class LegfrissitoViewModel extends ItemViewModel{
    /**
     * Légfrissítő attribútum
     */
    private Legfrissito legfrissito;

    public LegfrissitoViewModel(Legfrissito l){
        legfrissito = l;
    }

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
    public Legfrissito getLegfrissito() {
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
