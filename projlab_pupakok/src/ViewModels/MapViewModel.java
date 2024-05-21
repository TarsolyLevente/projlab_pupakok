package ViewModels;

import java.util.ArrayList;

import Palya.Palya;

/**
 * A MapViewModel osztály, amely a Pályát reprezentálja a nézethez.
 */
public class MapViewModel {
    private Palya palya;

    private ArrayList<SzobaViewModel> szobaviewmodels;

    private ArrayList<HallgatoViewModel> hallgatoviewmodels;

    /*
     * MapViewModel konstruktora
     * Létrehozza a pálya szobáihoz a ViewModelleket.
     */
    public MapViewModel(Palya p){
        palya = p;
        szobaviewmodels = new ArrayList<SzobaViewModel>();
        for(int i = 0; i < palya.getSzobak().size(); ++i){
            szobaviewmodels.add(new SzobaViewModel(palya.getSzobak().get(i)));
        }
        hallgatoviewmodels = new ArrayList<HallgatoViewModel>();
        for(int i = 0; i < palya.getHallgatok().size(); ++i){
            hallgatoviewmodels.add(new HallgatoViewModel(palya.getHallgatok().get(i)));
        }
    }

    public Palya getPalya(){
        return palya;
    }

    // public void general() {
    //     palya.general();
    // }

    public void leptet(){
        palya.leptet();
    }

}