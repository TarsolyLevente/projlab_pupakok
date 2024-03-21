package targy;

public class Sorospohar extends PasszivTargy{
    /**
     * Az idő múlását határozza meg
     */
    public void tick() {
        System.out.println("Sorospohar -> tick()");
    }

    /**
     * Az absztrakt setToltet() függvény megvalósítása a Söröspohár által
     */
    public void setToltet() {
        System.out.println("Sorospohar -> setToltet()");
    }
}