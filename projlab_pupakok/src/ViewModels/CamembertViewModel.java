package ViewModels;

import javax.swing.ImageIcon;

import Targy.*;

public class CamembertViewModel extends ItemViewModel{
    /**
     * Camembert attribútum
     */
    private Camembert camembert;

    public CamembertViewModel(Camembert c){
        camembert = c;
    }

    /**
     * Setter függvény a Camembert attribútumhoz.
     * @param c - A beállítandó tárgy.
     */
    public void setCamembert(Camembert c) {
        camembert = c;
    }

    /**
     * Getter függvény a Camembert attribútumhoz.
     */
    public Targy getCamembert() {
        return camembert;
    }

    /**
     * Használja a Camembert tárgyat.
     */
    public void useCamembert() {
        camembert.use();
    }

    /**
     * Az absztrakt getItemImage megvalósítása a Camembert által.
     */
    public ImageIcon getItemImage() {
        return new ImageIcon("resources/camembert.png");
    }
}
