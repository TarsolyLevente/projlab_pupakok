package ViewModels;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Targy.*;

/**
 * A LegfrissitoViewModel osztály, egy ItemViewModel leszármazottja, amely a Legfrissito tárgyat reprezentálja a nézethez.
 */
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
        BufferedImage sicon;
        try {
            sicon = ImageIO.read(new File("projlab_pupakok/src/resources/legfrissito.png"));
            Image icon = sicon.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            return new ImageIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon();
    }
}
