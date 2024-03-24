

public class TVSZ extends PasszivTargy {
    public TVSZ(Szoba sz, Karakter k, Funkcio f){
        super(sz, k, f);
    }
    /**
     * Az absztrakt setToltet() függvény megvalósítása a TVSZ által
     */
    public void setToltet() {
        System.out.println("TVSZ -> setToltet()");
    }

    public void use(){
        
    }

}