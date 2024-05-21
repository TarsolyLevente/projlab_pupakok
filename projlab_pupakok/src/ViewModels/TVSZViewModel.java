package ViewModels;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Targy.*;

/**
 * A TVSZViewModel osztály, egy ItemViewModel leszármazottja, amely a TVSZ tárgyat reprezentálja a nézethez.
 */
public class TVSZViewModel extends ItemViewModel{
    private TVSZ tvsz;

    public TVSZViewModel(TVSZ t){
        tvsz = t;
    }


    /**
     * Az absztrakt getItemImage megvalósítása a TVSZ által.
     */
    public ImageIcon getItemImage() {
        BufferedImage sicon;
        try {
            sicon = ImageIO.read(new File("projlab_pupakok/src/resources/tvsz.png"));
            Image icon = sicon.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            return new ImageIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon();
    }
}
