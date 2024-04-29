
public abstract class PasszivTargy extends Targy {
    /**
     * Egyes tárgyak felhasználásának száma egy bizonyos számhoz kötött.
     * A töltet ennek a felhasználási számnak a felügyeletéért felel.
     */
    protected int toltet;

    /**
     * Konstruktor a Passzív Tárgyakhoz
     */
    public PasszivTargy(Funkcio f, String id, Szoba sz, int t) {
        super(f, id, sz);
        toltet = t;
    }

    /**
     * Absztrakt függvény, ami beállítja, hogy az adott tárgy még mennyi alkalommal
     * használható mielőtt nem tudja többet használni a játékos.
     */
    public abstract void setToltet();

    /**
     * Getter függvény a Töltet attribútumra.
     */
    public int getToltet() {
        return toltet;
    }

    public abstract String toString(Funkcio funkcio);
}