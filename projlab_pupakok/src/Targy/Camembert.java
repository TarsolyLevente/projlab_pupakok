public class Camembert extends AktivTargy {
    public Camembert(Szoba sz, Karakter k, Funkcio f){
        super(sz, k, f);
    }

    /**
     * A Camembert tárgy megvalósítása az absztrakt use() függvénynek.
     */
    public void use() {
        System.out.println("Camembert -> use()");
    }
}