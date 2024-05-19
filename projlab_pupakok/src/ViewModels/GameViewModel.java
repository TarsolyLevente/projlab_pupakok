package ViewModels;

import Game.Game;
import Karakter.Hallgato;

public class GameViewModel {
    private Game game;

    //private MapViewModel mapviewmodel;

    public GameViewModel(Game g){
        game = g;
        //mapviewmodel = new MapViewModel(game.getPalya());
    }

    // public MapViewModel getMapViewModel(){
    //     return mapviewmodel;
    // }

    /**
     * Visszaadja a Game objektumot.
     * 
     * @return A Game objektum.
     */
    public Game getGame() {
        return game;
    }

    public void start(int jatekosokszama){
        game.start(jatekosokszama);
    }

    public void hallgatoLep(Hallgato hallgato){
        game.hallgatoLep(hallgato);
    }
    public void jatekLeptetes(){
        game.jatekLeptetes();
    }
    public void endgame(){
        game.endgame();
    }

    public int getTime() {
        return game.getSzamlalo();
    }


}
