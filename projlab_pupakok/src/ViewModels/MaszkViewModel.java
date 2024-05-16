package ViewModels;

import javax.swing.*;

public class MaszkViewModel extends ItemViewModel{
    /**
     * Az absztrakt getItemImage megvalósítása a Maszk által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/maszk.png");
    }
}
