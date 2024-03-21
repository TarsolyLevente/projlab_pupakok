package targy;

public abstract class PasszivTargy extends Targy {
    /**
     * A tárgy mennyiszer használható még.
     */
    protected int toltet;

    /**
     * Abstract metódus, minden leszármazott felüldefiniálja a saját használatának megfelelően.
     */
    public void setToltet();
}