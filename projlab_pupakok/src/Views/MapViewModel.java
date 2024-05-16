package Views;
import Palya.Palya;

public class MapViewModel {
    private Palya palya = new Palya();

    public MapViewModel(Palya p){
        palya = p;
    }

    public void general() {
        palya.general();
    }

    public void leptet(){
        palya.leptet();
    }

}