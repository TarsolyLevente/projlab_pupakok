

public class Maszk extends PasszivTargy {
    public Maszk(Szoba sz, Karakter k, Funkcio f){
        super(sz, k, f);
    }

    /**
     * Az absztrakt setToltet() függvény megvalósítása a Maszk által
     */
    public void setToltet() {
        System.out.println("Maszk -> setToltet()");
    }

    public void use(){
        
    }
}