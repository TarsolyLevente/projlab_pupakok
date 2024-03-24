public abstract class AktivTargy extends Targy {
    public AktivTargy(Szoba sz, Karakter k, Funkcio f){
        super(sz, k, f);
    }


    /**
     * Abstract metódus, minden leszármazott felüldefiniálja a saját használatának megfelelően.
     */
    public abstract void use();
}