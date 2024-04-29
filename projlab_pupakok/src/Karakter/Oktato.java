package Karakter;

import java.util.Timer;
import java.util.TimerTask;

import Szoba.*;
import Targy.*;

public class Oktato extends Karakter {
    /**
     * Megbénult-e tárgy hatására.
     */
    private boolean megbenult;

    /**
     * Oktató konstruktor függvénye
     * 
     * 
     */
    public Oktato(Szoba sz, String id) {
        super(sz, id);
        sz.getOktatok().add(this);
    }

    /**
     * OKtató mozgásért felelős függvénye
     * 
     * @param sz Ebbe a szobába mozog át.
     */
    public void mozog(Szoba sz) {

        if (sz.addOktato(this)) {
            for (Targy targy : taska) {
                targy.setSzoba(sz);
            }
            getSzoba().removeOktato(this);
            this.setSzoba(sz);
            if(getSzoba().getRagacs_cnt() != -1){
                getSzoba().setRagacs_cnt(getSzoba().getRagacs_cnt()+1);
            }

            if (sz.getHallgatok().size() != 0) {
                for (Hallgato hallgato : sz.getHallgatok()) {
                    hallgato.vedette(Vedettseg.oktatotol);
                }

            }
        }
    }

    /**
     * Oktató megbénul függvénye
     */
    public void megbenul() {
        megbenult = true;
        System.out.println("Oktató " + getid() + " megbénult!");

        Timer timer = new Timer();
            
        // Schedule the task to be executed after 1 minute
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                megbenult = false;
            }
        }, 30000);
    }

    /**
     * Oktató felvesz függvénye
     * 
     * @param t Ezt veszi fel
     */
    public void felvesz(Targy t) {
        if(!getSzoba().isRagacsos()){
            t.setBirtokos(this);
            t.setSzoba(getSzoba());
            getSzoba().targy_eltuntetese(t);
            taska.add(t);

            if((t instanceof Tranzisztor) && (((Tranzisztor)t).getTars() != null)){
                return;
            }
            
            if(getSzoba().getRegiszobak().size() != 0){
                for(int i = 0; i < getSzoba().getRegiszobak().size(); ++i){
                    for(int j = 0; j < getSzoba().getRegiszobak().get(i).getTargyak().size(); ++j){
                        if(getSzoba().getTargyak().get(j).getId().equals(t.getId())){
                            getSzoba().getRegiszobak().get(j).getTargyak().remove(t);
                        }
                    }
                }
            }
    
        }
    }
}
