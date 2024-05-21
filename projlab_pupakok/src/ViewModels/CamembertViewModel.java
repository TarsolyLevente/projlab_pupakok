package ViewModels;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Targy.*;

/**
 * A CamembertViewModel osztály, egy ItemViewModel leszármazottja, amely a Camembert tárgyat reprezentálja a nézethez.
 */
public class CamembertViewModel extends ItemViewModel{
    /**
     * Camembert attribútum
     */
    private Camembert camembert;

    public CamembertViewModel(Camembert c){
        camembert = c;
    }

    /**
     * Setter függvény a Camembert attribútumhoz.
     * @param c - A beállítandó tárgy.
     */
    public void setCamembert(Camembert c) {
        camembert = c;
    }

    /**
     * Getter függvény a Camembert attribútumhoz.
     */
    public Camembert getCamembert() {
        return camembert;
    }

    /**
     * Használja a Camembert tárgyat.
     */
    public void useCamembert() {
        camembert.use();
    }

    /**
     * Az absztrakt getItemImage megvalósítása a Camembert által.
     */
    public ImageIcon getItemImage() {
        BufferedImage sicon;
        try {
            sicon = ImageIO.read(new File("resources/camembert.png"));
            Image icon = sicon.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            return new ImageIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon();
    }
}
