
public class Maszk extends PasszivTargy {
    /**
     * Maszk osztály konstruktora.
     */
    public Maszk(Szoba sz, String id) {
        super(Funkcio.gaztol_ved, id, sz, 4);
    }

    /**
     * A Maszk tárgy általi megvalósítása az absztrakt setToltet() függvénynek.
     */
    public void setToltet() {
        if (toltet > 0) {
            toltet--;
        } else {
            getBirtokos().getTaska().remove(this);
        }
    }

    /**
     * A Maszk tárgy általi megvalósítása az absztrakt use() függvénynek.
     */
    public void use() {
        if (this.getFunkcio() != Funkcio.hamis) {
            setToltet();
        }
    }

    public String toString(Funkcio funkcio) {
        if (funkcio == null || funkcio == this.funkcio)
            return "Maszk";
        return "";
    }
}