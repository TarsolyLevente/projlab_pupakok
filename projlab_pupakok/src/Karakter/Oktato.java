
public class Oktato extends Karakter
{
    private boolean megbenult;

    public Oktato(Szoba sz){
        super(sz);
    }

    public void megbenul() 
    {
        System.out.println("megbenul fv lefutott");
    }

    public void felvesz(Targy t)
    {
        System.out.println("felvesz fv lefutott");
        t.setBirtokos(this);
        t.setSzoba(null);
        szoba.targy_eltuntetese(t);
    }
}
