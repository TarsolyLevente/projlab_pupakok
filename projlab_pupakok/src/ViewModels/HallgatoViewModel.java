package ViewModels;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Karakter.Hallgato;
import Szoba.Szoba;
import Targy.Camembert;
import Targy.Legfrissito;
import Targy.Logarlec;
import Targy.Maszk;
import Targy.Rongy;
import Targy.Sorospohar;
import Targy.TVSZ;
import Targy.Targy;
import Targy.Tranzisztor;
import Views.ItemFrame;
import Views.RoomFrame;

/**
 * A HallgatoViewModel osztály, amely egy Hallgatót reprezentál a nézethez.
 */
public class HallgatoViewModel {
    private Hallgato hallgato;
    private GameViewModel gameViewModel;

    public HallgatoViewModel(Hallgato h, GameViewModel gVM) {
        hallgato = h;
        gameViewModel = gVM;
    }

    public HallgatoViewModel(Hallgato h) {
        hallgato = h;
    }

    /**
     * Visszaadja a Hallgato objektumot.
     * 
     * @return A Hallgato objektum.
     */
    public Hallgato getHallgato() {
        return hallgato;
    }

    /**
     * Beállítja a Hallgato objektumot.
     * 
     * @param hallgato A beállítandó Hallgato objektum.
     */
    public void setHallgato(Hallgato hallgato) {
        this.hallgato = hallgato;
    }

    /**
     * Mozgatja a Hallgato objektumot a megadott Szoba objektumba.
     * 
     * @param szoba A Szoba objektum, amelybe mozgatni kell.
     */
    public void mozgas() {
        RoomFrame rf = new RoomFrame(this);
        rf.setVisible(true);
        rf.setLocationRelativeTo(null);
    }

    public void mozgas(Szoba szoba) {
        hallgato.mozog(szoba);
        gameViewModel.getGameFrame().updateGamePanel(new SzobaViewModel(hallgato.getSzoba()), this);
        gameViewModel.getGameFrame().updateUserPanel(this);
        gameViewModel.getGameFrame().updateMenuPanel(this);
        synchronized (gameViewModel) {
            gameViewModel.notifyAll();
        }
    }
    
    /**
     * Használja a megadott Targy objektumot.
     * 
     * @param targy A használandó Targy objektum.
     */
    public void hasznal(int i) {
        hallgato.getTaska().get(i).use();
        gameViewModel.getGameFrame().updateGamePanel(new SzobaViewModel(hallgato.getSzoba()), this);
        gameViewModel.getGameFrame().updateMenuPanel(this);
        gameViewModel.getGameFrame().updateUserPanel(this);
    }

    /**
     * Elhagyja a Hallgato által tartott megadott Targy objektumot.
     * 
     * @param targy Az eldobandó Targy objektum.
     */
    public void eldob(int i) {
        hallgato.eldob(hallgato.getTaska().get(i));
        gameViewModel.getGameFrame().updateGamePanel(new SzobaViewModel(hallgato.getSzoba()), this);
    }

    /**
     * Felveszi a megadott Targy objektumot és hozzáadja a Hallgato tárgyainak
     * listájához.
     * 
     * @param targy A felveendő Targy objektum.
     */
    public void felvesz(Targy targy) {
        hallgato.felvesz(targy);
        gameViewModel.getGameFrame().updateUserPanel(this);
    }

    /**
     * Teleportálja a Hallgato objektumot a megadott Tranzisztor objektum
     * segítségével.
     * 
     * @param t A teleportáláshoz használt Tranzisztor objektum.
     */
    public void teleportal(Tranzisztor t) {
        if (hallgato.teleport(t)) {
            gameViewModel.getGameFrame().updateGamePanel(new SzobaViewModel(hallgato.getSzoba()), this);
            gameViewModel.getGameFrame().updateUserPanel(this);
            gameViewModel.getGameFrame().updateMenuPanel(this);
            synchronized (gameViewModel) {
                gameViewModel.notifyAll();
            }
        }
    }

    public String getSzobaID(){
        return hallgato.getSzoba().getid();

    }
    public String getHallgatoID(){
        return hallgato.getid();

    }

    /*
     * Létrehozza az itemframet.
     */
    public void createItemFrame(SzobaViewModel szobaViewModel){
        ItemFrame itemframe = new ItemFrame(szobaViewModel, this);
        itemframe.setLocationRelativeTo(null);
    }

    /*
     * Visszaadja a hallgatónál lévő tárgyak képeit.
     */
    public ArrayList<ItemViewModel> createitemviewmodels(){
        ArrayList<ItemViewModel> itemviewmodels = new ArrayList<ItemViewModel>();
        ArrayList<Targy> sz = this.getHallgato().getTaska();
        for(int i = 0; i < sz.size(); ++i){
            if(sz.get(i) instanceof Camembert) itemviewmodels.add(new CamembertViewModel((Camembert)sz.get(i)));
            if(sz.get(i) instanceof Legfrissito) itemviewmodels.add(new LegfrissitoViewModel((Legfrissito)sz.get(i)));
            if(sz.get(i) instanceof Maszk) itemviewmodels.add(new MaszkViewModel((Maszk)sz.get(i)));
            if(sz.get(i) instanceof Rongy) itemviewmodels.add(new RongyViewModel((Rongy)sz.get(i)));
            if(sz.get(i) instanceof Sorospohar) itemviewmodels.add(new SorospoharViewModel((Sorospohar)sz.get(i)));
            if(sz.get(i) instanceof Tranzisztor) itemviewmodels.add(new TranzisztorViewModel((Tranzisztor)sz.get(i)));
            if(sz.get(i) instanceof Logarlec) itemviewmodels.add(new LogarlecViewModel((Logarlec)sz.get(i)));
            if(sz.get(i) instanceof TVSZ) itemviewmodels.add(new TVSZViewModel((TVSZ)sz.get(i)));
        }
        return itemviewmodels;
    }

    /**
     * Visszaadja a feladatban lévő tárgyak képeit.
     * 
     * @return a feladatban lévő tárgyak képeinek tömbje
     */
    public ImageIcon[] giveTaskabanLevoTargyakKepe(){
        ArrayList<ItemViewModel> itemviewmodels = createitemviewmodels();
        ImageIcon[] images = new ImageIcon[itemviewmodels.size()];
        for(int i = 0; i < itemviewmodels.size(); ++i){
            images[i] = itemviewmodels.get(i).getItemImage();
        }
        return images;
    }
}
