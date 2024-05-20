package ViewModels;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Targy.Logarlec;

public class LogarlecViewModel extends ItemViewModel{
    private Logarlec logarlec;

    public LogarlecViewModel(Logarlec l){
        logarlec = l;
    }
    /**
     * Az absztrakt getItemImage megvalósítása a Logarlec által.
     */
    public ImageIcon getItemImage() {
        BufferedImage sicon;
        try {
            sicon = ImageIO.read(new File("projlab_pupakok/src/resources/logarlec.png"));
            Image icon = sicon.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            return new ImageIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon();
    }
}
