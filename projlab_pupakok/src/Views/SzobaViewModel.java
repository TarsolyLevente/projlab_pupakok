package Views;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;

import Szoba.*;

public class SzobaViewModel{
    /*
     * Az adott szoba osztály elérése a modellben.
     */
    protected Szoba szoba;

    /*
     * SzobaViewModel konstruktora, paraméterben az aktuális szoba.
     */
    public SzobaViewModel(Szoba sz){
        szoba = sz;
    }

    /*
     * visszaadja egy tömbben az adott szobában található tárgyak képeit.
     */
    public ImageIcon[] getItemsPictures(){
        int n = szoba.getTargyak().size();
        ImageIcon[] images = new ImageIcon[n];
        for(int i = 0; i < n; ++i){
            images[i] = //TODO
        }
        return images;
    }
    /*
     * Visszaadja a szomszédos szobák 
     */
    public String[] getNeighbouringRoomsNames(){
        int n = szoba.getSzomszedok().size();
        String[] szomszedokneve = new String[n];
        for(int i = 0; i < n; ++i){
            szomszedokneve[i] = "Szoba " + szoba.getSzomszedok().get(0).getid();
        }
        return szomszedokneve;
    }

    /*
     * Visszaadja a szoba háttérszínét annak függvényében, hogy a szoba gázos-e vagy nem.
     */
    public Color setSzobaBackgroundColor(){
        Color green = Color.GREEN;
        Color defa = UIManager.getColor("Panel.background");
        if(szoba.isGazos()){
            return green;
        } else{
            return defa;
        }
    }

    /*
     * Visszaadja a szoba keretének a színét annak függvényében, hogy a szoba elátkozott-e vagy nem.
     */
    public Color setSzobaFrameColor(){
        Color pink = Color.PINK;
        Color defa = UIManager.getColor("Panel.background");
        if(szoba instanceof ElatkozottSzoba){
            return pink;
        } else{
            return defa;
        }
    }
    
}
