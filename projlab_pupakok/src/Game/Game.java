public class Game {
    /**
	 * A játékba lévő pálya
	 */
    private Palya palya;
    /**
	 * Idő számláló
	 */
    private int szamlalo;

    Game(Palya p){
        palya= p;
        
    }

    /**
	 * le generálja a pályát és folyton meghívja a léptet függvényt a pályán
	 */

    public void start(){
        System.out.println("Game -> start()");
        palya.general();
        //while(valameddig)
        palya.leptet();
    }


    /**
	 * Befejezi a játékot
	 */
    public void endgame(){
        System.out.println("Game -> endgame()");
    }


    
}
