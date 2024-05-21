package ViewModels;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Targy.*;

/**
 * A RongyViewModel osztály, egy ItemViewModel leszármazottja, amely a Rongy tárgyat reprezentálja a nézethez.
 */
public class RongyViewModel extends ItemViewModel{
    private Rongy rongy;

    public RongyViewModel(Rongy r){
        rongy = r;
    }

    /**
     * Az absztrakt getItemImage megvalósítása a Rongy által.
     */
    public ImageIcon getItemImage() {
        BufferedImage sicon;
        try {
            sicon = ImageIO.read(new File("projlab_pupakok/src/resources/rongy.png"));
            Image icon = sicon.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            return new ImageIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon();
    }
}
