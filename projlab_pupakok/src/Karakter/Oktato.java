package Karakter;

import Palya.*;
import Szoba.*;
import Targy.*;

public class Oktato extends Karakter
{
    /**
     * Megbénult-e tárgy hatására.
     */
    private boolean megbenult;

    /**
     * Oktató mozog függvénye
     * @param sz Ide mozog át
     */
    public Oktato(Szoba sz, String id){
        super(sz, id);
        sz.addOktato(this);
        System.out.println("Oktato -> create");
    }

    /**
     * Hallgató mozgásért felelős függvénye
     * @param sz Ebbe a szobába mozog át.
     */
    public void mozog(Szoba sz){
        System.out.println("Oktato -> mozog()");
        
        if(sz.addOktato(this)){
            for (Targy targy : taska) {
                targy.setSzoba(sz);
            }
            getSzoba().removeOktato(this);
            this.setSzoba(sz);

            if (sz.getHallgatok().size() != 0) {
                    for (Hallgato hallgato : sz.getHallgatok()) {
                        hallgato.kibukik();
                    }     
                
                 }
        }
    }

    /**
     * Oktató megbénul függvénye
     */
    public void megbenul() 
    {
        megbenult=true;
        System.out.println("Oktato -> megbenul()");
    }

    /**
     * Oktató felvesz függvénye
     * @param t Ezt veszi fel
     */
    public void felvesz(Targy t)
    {
        System.out.println("Oktato -> felvesz()");
        t.setBirtokos(this);
        t.setSzoba(getSzoba());
        getSzoba().targy_eltuntetese(t);
    }
}
