
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
        t.setBirtokos(this);
        t.setSzoba(null);
        System.out.println("felvesz fv lefutott");
    }
}
