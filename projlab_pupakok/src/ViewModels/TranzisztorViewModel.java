package ViewModels;

import javax.swing.ImageIcon;

import Targy.*;

public class TranzisztorViewModel extends ItemViewModel{
    /**
     * Tranzisztor attribútum
     */
    private Tranzisztor tranzisztor;

    /**
     * Setter függvény a Tranzisztor attribútumhoz.
     * @param t - A beállítandó tárgy.
     */
    public void setTranzisztor(Tranzisztor t) {
        tranzisztor = t;
    }

    /**
     * Getter függvény a Tranzisztor attribútumhoz.
     */
    public Targy getTranzisztor() {
        return tranzisztor;
    }

    /**
     * Használja a Tranzisztor tárgyat.
     */
    public void useTranzisztor() {
        tranzisztor.use();
    }

    /**
     * A Tranzisztor társát állítja be.
     */
    public void tarsTranzisztor(Tranzisztor t) {
        tranzisztor.setTars(t);
    }

    /**
     * Az absztrakt getItemImage megvalósítása a Tranzisztor által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/tranzisztor.png");
    }
}
