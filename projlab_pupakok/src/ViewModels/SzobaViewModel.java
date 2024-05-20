package ViewModels;

import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
     * SzobaViewModel konstruktora, paraméterben az aktuális szoba.
     */
    public SzobaViewModel(Szoba sz) {
        szoba = sz;
    }

    public ArrayList<? extends ItemViewModel>[] createitemviewmodels(){
        ArrayList<? extends ItemViewModel>[] lists = (ArrayList<? extends ItemViewModel>[]) new ArrayList[2];
        ArrayList<ItemViewModel> itemviewmodels = new ArrayList<ItemViewModel>();
        ArrayList<TranzisztorViewModel> tranzisztorviewmodels = new ArrayList<TranzisztorViewModel>();
        Szoba sz = this.getSzoba();
        for(int i = 0; i < sz.getTargyak().size(); ++i){
            if(sz.getTargyak().get(i) instanceof Camembert) itemviewmodels.add(new CamembertViewModel((Camembert)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof Legfrissito) itemviewmodels.add(new LegfrissitoViewModel((Legfrissito)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof Maszk) itemviewmodels.add(new MaszkViewModel((Maszk)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof Rongy) itemviewmodels.add(new RongyViewModel((Rongy)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof Sorospohar) itemviewmodels.add(new SorospoharViewModel((Sorospohar)sz.getTargyak().get(i)));
            if (sz.getTargyak().get(i) instanceof Tranzisztor) {
                tranzisztorviewmodels.add(new TranzisztorViewModel((Tranzisztor) sz.getTargyak().get(i)));
                itemviewmodels.add(new TranzisztorViewModel((Tranzisztor) sz.getTargyak().get(i)));
            }
            if(sz.getTargyak().get(i) instanceof Logarlec) itemviewmodels.add(new LogarlecViewModel((Logarlec)sz.getTargyak().get(i)));
            if(sz.getTargyak().get(i) instanceof TVSZ) itemviewmodels.add(new TVSZViewModel((TVSZ)sz.getTargyak().get(i)));
        }
        lists[0] = itemviewmodels;
        lists[1] = tranzisztorviewmodels;
        return lists;
    }

    /*
     * visszaadja egy tömbben az adott szobában található tárgyak képeit.
     */
    public ImageIcon[] getItemsPictures(){
        ArrayList<? extends ItemViewModel>[] lists = createitemviewmodels();
        ArrayList<? extends ItemViewModel> itemviewmodels = lists[0];
        ArrayList<TranzisztorViewModel> tranzisztorviewmodels = (ArrayList<TranzisztorViewModel>)lists[1];
        int itemcount = itemviewmodels.size();
        int inactivtransistorcount = 0;
        for(int i = 0; i < tranzisztorviewmodels.size(); ++i){
            if(!tranzisztorviewmodels.get(i).getTranzisztor().getAktiv()){
                inactivtransistorcount++;
            }
        }
        ImageIcon[] images = new ImageIcon[inactivtransistorcount + itemcount];
        for(int i = 0; i < itemcount; ++i){
            images[i] = itemviewmodels.get(i).getItemImage();
        }
        for(int i = 0; i < tranzisztorviewmodels.size(); ++i){
            if(!tranzisztorviewmodels.get(i).getTranzisztor().getAktiv()){
                images[itemcount + i] = tranzisztorviewmodels.get(i).getItemImage(); 
            }
        }
        return images;
    }


    /*
     * Aktív tranzisztorok viewmodelleinek visszaadása.
     */
    public ArrayList<TranzisztorViewModel> getActiveTransistorViewModels(){
        ArrayList<? extends ItemViewModel>[] lists = createitemviewmodels();
        ArrayList<TranzisztorViewModel> tranzisztorviewmodels = (ArrayList<TranzisztorViewModel>)lists[1];
        ArrayList<TranzisztorViewModel> aktivtranzisztorviewmodels = new ArrayList<TranzisztorViewModel>();
        for(int i = 0; i < tranzisztorviewmodels.size(); ++i){
            if((tranzisztorviewmodels.get(i).getTranzisztor()).getAktiv()){
                aktivtranzisztorviewmodels.add(tranzisztorviewmodels.get(i));
            }
        }
        return aktivtranzisztorviewmodels;
    }


    /*
     * Visszaadja egy tömbben az adott szobában található karakterek képeit.
     */
    public ImageIcon[] getCharactersPictures() throws IOException {
        int h = szoba.getHallgatok().size();
        int o = szoba.getOktatok().size();
        int t = szoba.getTakaritok().size();
        int n = h + o + t;
        ImageIcon[] images = new ImageIcon[n];
        try{
            BufferedImage studenticon = ImageIO.read(new File("projlab_pupakok/src/resources/student.png"));
            BufferedImage teachericon = ImageIO.read(new File("projlab_pupakok/src/resources/teacher.png"));
            BufferedImage janitoricon = ImageIO.read(new File("projlab_pupakok/src/resources/janitor.png"));
            for (int i = 0; i < h; ++i) { // hallgatok
                images[i] = new ImageIcon(studenticon);
                
            }
            for (int i = 0; i < o; ++i) { // oktatok
                images[h + i] = new ImageIcon(teachericon);
            }
            for (int i = 0; i < t; ++i) { // takaritok
                images[h + o + i] = new ImageIcon(janitoricon);
            }
        }
        catch(IOException e){
            e.printStackTrace();
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
            szomszedokneve[i] = "Szoba " + szoba.getSzomszedok().get(i).getid();
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
