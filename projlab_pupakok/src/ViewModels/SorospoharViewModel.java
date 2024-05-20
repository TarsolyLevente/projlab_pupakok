package ViewModels;

import javax.swing.*;

import Targy.*;

public class SorospoharViewModel extends ItemViewModel{
    private Sorospohar sorospohar;

    public SorospoharViewModel(Sorospohar s){
        sorospohar = s;
    }

    /**
     * Az absztrakt getItemImage megvalósítása a Söröspohár által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/sorospohar.png");
    }
}
