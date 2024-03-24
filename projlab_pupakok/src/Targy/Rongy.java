

public class Rongy extends PasszivTargy{
    public Rongy(Szoba sz, Karakter k, Funkcio f){
        super(sz, k, f);
    }

    /**
     * Az idő múlását határozza meg
     */
    public void tick() {
        System.out.println("Rongy -> tick()");
    }

    /**
     * Az absztrakt setToltet() függvény megvalósítása a Rongy által
     */
    public void setToltet() {
        System.out.println("Rongy -> setToltet()");
    }

    public void use(){
        
    }
}
