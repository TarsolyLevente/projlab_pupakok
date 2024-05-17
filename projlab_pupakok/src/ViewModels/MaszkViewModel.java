package ViewModels;

import javax.swing.*;

import Targy.*;

public class MaszkViewModel extends ItemViewModel{
    private Maszk maszk;

    public MaszkViewModel(Maszk m){
        maszk = m;
    }


    /**
     * Az absztrakt getItemImage megvalósítása a Maszk által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/maszk.png");
    }
}
