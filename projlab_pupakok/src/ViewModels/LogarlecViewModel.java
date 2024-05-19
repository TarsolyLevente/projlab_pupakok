package ViewModels;

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
        return new ImageIcon("resources/logarlec.png");
    }
}
