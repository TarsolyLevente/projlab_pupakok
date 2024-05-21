package ViewModels;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Targy.*;

/**
 * A MaszkViewModel osztály, egy ItemViewModel leszármazottja, amely a Maszk tárgyat reprezentálja a nézethez.
 */
public class MaszkViewModel extends ItemViewModel{
    private Maszk maszk;

    public MaszkViewModel(Maszk m){
        maszk = m;
    }


    /**
     * Az absztrakt getItemImage megvalósítása a Maszk által.
     */
    public ImageIcon getItemImage() {
        BufferedImage sicon;
        try {
            sicon = ImageIO.read(new File("projlab_pupakok/src/resources/maszk.png"));
            Image icon = sicon.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            return new ImageIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon();
    }
}
