package ViewModels;

import javax.swing.*;

public class RongyViewModel extends ItemViewModel{
    /**
     * Az absztrakt getItemImage megvalósítása a Rongy által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/rongy.png");
    }
}
