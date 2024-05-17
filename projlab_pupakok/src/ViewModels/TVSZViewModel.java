package ViewModels;

import javax.swing.*;

import Targy.*;

public class TVSZViewModel extends ItemViewModel{
    private TVSZ tvsz;

    public TVSZViewModel(TVSZ t){
        tvsz = t;
    }


    /**
     * Az absztrakt getItemImage megvalósítása a TVSZ által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/tvsz.png");
    }
}
