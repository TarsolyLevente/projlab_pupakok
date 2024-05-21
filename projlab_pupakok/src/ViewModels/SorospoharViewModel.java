package ViewModels;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Targy.*;

/**
 * A SorospoharViewModel osztály, egy ItemViewModel leszármazottja, amely a Sorospohar tárgyat reprezentálja a nézethez.
 */
public class SorospoharViewModel extends ItemViewModel{
    private Sorospohar sorospohar;

    public SorospoharViewModel(Sorospohar s){
        sorospohar = s;
    }

    /**
     * Az absztrakt getItemImage megvalósítása a Söröspohár által.
     */
    public ImageIcon getItemImage() {
        BufferedImage sicon;
        try {
            sicon = ImageIO.read(new File("resources/sorospohar.png"));
            Image icon = sicon.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            return new ImageIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon();
    }
}
