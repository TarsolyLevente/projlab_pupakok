package ViewModels;

import Game.Game;
import Karakter.Hallgato;

public class GameViewModel {
    public Game game = new Game();

    public GameViewModel(Game g){
        game = g;
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
