package ViewModels;

import javax.swing.*;

import Targy.*;

public class RongyViewModel extends ItemViewModel{
    private Rongy rongy;

    public RongyViewModel(Rongy r){
        rongy = r;
    }

    /**
     * Az absztrakt getItemImage megvalósítása a Rongy által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/rongy.png");
    }
}
