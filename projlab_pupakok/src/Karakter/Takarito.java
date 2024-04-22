package Karakter;

import java.util.List;

import Palya.*;
import Szoba.*;
import Targy.*;

public class Takarito extends Karakter {
    
    /**
     * Oktató mozog függvénye
     * @param sz Ide mozog át
     */
    public Takarito(Szoba sz, String id){
        super(sz, id);
        sz.addTakarito(this);
        System.out.println("Takarito -> create");
    }

    /**
     * Takarító mozgásért felelős függvénye
     * @param sz Ebbe a szobába mozog át.
     */
    public void mozog(Szoba sz){
        System.out.println("Takarito -> mozog()");
        
        if(sz.addTakarito(this)){
            for (Targy targy : taska) {
                targy.setSzoba(sz);
            }
            getSzoba().removeOTakarito(this);
            this.setSzoba(sz);

                 }
        }
    }

    //TODO VÉLETLENSÉG

    /**
     * Takarító felvesz függvénye
     * @param t Ezt veszi fel
     */
    public void felvesz(Targy t)
    {
        System.out.println("Takarito -> felvesz()");
        t.setBirtokos(this);
        t.setSzoba(getSzoba());
        getSzoba().targy_eltuntetese(t);
    }

       
    /**
     * Takarító takarit függvénye
     * A szoba ragacs számlálóját nullára állítja.
     */
    void takarit(){
        getSzoba().setragacscnt = 0;

    }


    /**
     * Takarító kikuld függvénye
     * A szobába tarkozkodókat áthelyezi egy szomszéd szobába
     */
    //TODO import list??
    public void kikuld() {
        List<Szoba> szomszedok = getSzoba().getSzomszedok();
        while (!szomszedok.isEmpty() && (!getSzoba().getHallgatok().isEmpty() || !getSzoba().getOktatok().isEmpty())) {
            for (Szoba szomszedSzoba : szomszedok) {
                for (Hallgato hallgato : szomszedSzoba.getHallgatok()) {
                    hallgato.mozog(szomszedSzoba);
                }
                for (Oktato oktato : szomszedSzoba.getOktatok()) {
                    oktato.mozog(szomszedSzoba);
                }
            }
            
        }
    }



}
