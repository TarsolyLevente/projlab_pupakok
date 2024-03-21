package targy;

public class Rongy extends PasszivTargy{
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
}