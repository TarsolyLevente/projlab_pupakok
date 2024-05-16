package ViewModels;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;

import Szoba.*;

public class SzobaViewModel {
    /*
     * Az adott szoba osztály elérése a modellben.
     */
    protected Szoba szoba;

    /*
     * SzobaViewModel konstruktora, paraméterben az aktuális szoba.
     */
    public SzobaViewModel(Szoba sz) {
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
     * Aktív tranzisztorok képeinek visszaadása.
     */
    //TODO


    /*
     * Visszaadja egy tömbben az adott szobában található karakterek képeit.
     */
    public ImageIcon[] getCharactersPictures() {
        int h = szoba.getHallgatok().size();
        int o = szoba.getOktatok().size();
        int t = szoba.getTakaritok().size();
        int n = h + o + t;
        ImageIcon[] images = new ImageIcon[n];
        for (int i = 0; i < h; ++i) { // hallgatok
            images[i] = new ImageIcon("resources/student.png");
        }
        for (int i = 0; i < o; ++i) { // oktatok
            images[h + i] = new ImageIcon("resources/teacher.png");
        }
        for (int i = 0; i < t; ++i) { // takaritok
            images[h + o + i] = new ImageIcon("resources/janitor.png");
        }
        return images;
    }

    /*
     * Visszaadja a szomszédos szobák
     */
    public String[] getNeighbouringRoomsNames() {
        int n = szoba.getSzomszedok().size();
        String[] szomszedokneve = new String[n];
        for (int i = 0; i < n; ++i) {
            szomszedokneve[i] = "Szoba " + szoba.getSzomszedok().get(0).getid();
        }
        return szomszedokneve;
    }

    /*
     * Visszaadja a szoba háttérszínét annak függvényében, hogy a szoba gázos-e vagy
     * nem.
     */
    public Color giveSzobaBackgroundColor() {
        Color green = Color.GREEN;
        Color defa = UIManager.getColor("Panel.background");
        if (szoba.isGazos()) {
            return green;
        } else {
            return defa;
        }
    }

    /*
     * Visszaadja a szoba keretének a színét annak függvényében, hogy a szoba
     * elátkozott-e vagy nem.
     */
    public Color giveSzobaFrameColor() {
        Color pink = Color.PINK;
        Color defa = UIManager.getColor("Panel.background");
        if (szoba instanceof ElatkozottSzoba) {
            return pink;
        } else {
            return defa;
        }
    }

    /*
     * getter a szoba attribútumra
     */
    public Szoba getSzoba(){
        return szoba;
    }
}
