package ViewModels;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Targy.*;

public class TranzisztorViewModel extends ItemViewModel{
    /**
     * Tranzisztor attribútum
     */
    private Tranzisztor tranzisztor;

    public TranzisztorViewModel(Tranzisztor t){
        tranzisztor = t;
    }

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
    public Tranzisztor getTranzisztor() {
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
        BufferedImage sicon;
        try {
            sicon = ImageIO.read(new File("projlab_pupakok/src/resources/tranzisztor.png"));
            Image icon = sicon.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            return new ImageIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon();
    }
}
