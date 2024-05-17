package ViewModels;

import javax.swing.*;

public class LogarlecViewModel extends ItemViewModel{
    /**
     * Az absztrakt getItemImage megvalósítása a Logarlec által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/logarlec.png");
    }
}
