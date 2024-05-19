package ViewModels;

import Game.Game;
import Karakter.Hallgato;

public class GameViewModel {
    private Game game;

    private MapViewModel mapviewmodel;

    public GameViewModel(Game g){
        game = g;
        mapviewmodel = new MapViewModel(game.getPalya());
    }

    public MapViewModel getMapViewModel(){
        return mapviewmodel;
    }

    public void start(){
        game.start();
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
}
