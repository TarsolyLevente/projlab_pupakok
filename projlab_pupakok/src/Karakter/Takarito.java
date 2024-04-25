package Karakter;

import java.util.ArrayList;

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
    }

    /**
     * Takarító mozgásért felelős függvénye
     * @param sz Ebbe a szobába mozog át.
     */
    public void mozog(Szoba sz){
        
        if(sz.addTakarito(this)){
            for (Targy targy : taska) {
                targy.setSzoba(sz);
            }
            getSzoba().removeOTakarito(this);
            this.setSzoba(sz);

                 
        }
    }

    

    /**
     * Takarító felvesz függvénye
     * @param t Ezt veszi fel
     */
    public void felvesz(Targy t)
    {
        t.setBirtokos(this);
        t.setSzoba(getSzoba());
        getSzoba().targy_eltuntetese(t);
    }

       
    /**
     * Takarító takarit függvénye
     * A szoba ragacs számlálóját nullára állítja.
     */
    void takarit(){
        getSzoba().setRagacs_cnt(0);

    }


    /**
     * Takarító kikuld függvénye
     * A szobába tarkozkodókat áthelyezi egy szomszéd szobába
     */
    
    public void kikuld() {
        ArrayList<Szoba> szomszedok = new ArrayList<>();
        szomszedok = getSzoba().getSzomszedok();
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
