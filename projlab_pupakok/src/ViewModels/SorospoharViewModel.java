package ViewModels;

import javax.swing.*;

public class SorospoharViewModel extends ItemViewModel{
    /**
     * Az absztrakt getItemImage megvalósítása a Söröspohár által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/sorospohar.png");
    }
}
