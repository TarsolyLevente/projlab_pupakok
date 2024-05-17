package ViewModels;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;

import Szoba.*;
import Targy.Camembert;
import Targy.Legfrissito;
import Targy.Logarlec;
import Targy.Maszk;
import Targy.Rongy;
import Targy.Sorospohar;
import Targy.TVSZ;
import Targy.Tranzisztor;

public class SzobaViewModel {
    /*
     * Az adott szoba osztály elérése a modellben.
     */
    private Szoba szoba;

    /*
     * A szobában található tárgyak viewmodellei
     */
    private ArrayList<ItemViewModel> itemviewmodels;

    /*
     * SzobaViewModel konstruktora, paraméterben az aktuális szoba.
     */
    public SzobaViewModel(Szoba sz) {
        szoba = sz;
        for(int i = 0; i < sz.getTargyak().size(); ++i){
            if(sz.getTargyak().get(i) instanceof Camembert) itemviewmodels.add(new CamembertViewModel((Camembert)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof Legfrissito) itemviewmodels.add(new LegfrissitoViewModel((Legfrissito)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof Maszk) itemviewmodels.add(new MaszkViewModel((Maszk)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof Rongy) itemviewmodels.add(new RongyViewModel((Rongy)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof Sorospohar) itemviewmodels.add(new SorospoharViewModel((Sorospohar)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof Tranzisztor) itemviewmodels.add(new TranzisztorViewModel((Tranzisztor)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof Logarlec) itemviewmodels.add(new LogarlecViewModel((Logarlec)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof TVSZ) itemviewmodels.add(new TVSZViewModel((TVSZ)sz.getTargyak().get(i)));
        }
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
     * Aktív tranzisztorok viewmodelleinek visszaadása.
     */
    public ArrayList<TranzisztorViewModel> getActiveTransistorViewModels(){
        
    }


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
