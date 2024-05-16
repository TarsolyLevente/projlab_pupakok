package ViewModels;

import javax.swing.*;

public class TVSZViewModel extends ItemViewModel{
    /**
     * Az absztrakt getItemImage megvalósítása a TVSZ által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/tvsz.png");
    }
}
