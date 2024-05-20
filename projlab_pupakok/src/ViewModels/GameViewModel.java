package ViewModels;

import Game.Game;
import Karakter.Hallgato;
import Views.GameFrame;

public class GameViewModel {
    private Game game;

    private MapViewModel mapViewModel;
    private GameFrame gameFrame;

    public GameViewModel(int jatekosokszama){
        
        game = new Game();
        mapViewModel = new MapViewModel(game.getPalya());
        gameFrame = new GameFrame();
        start(jatekosokszama);
        //jatekLeptetes();
        update(game.getPalya().getHallgatok().get(0));
    }

    public MapViewModel getMapViewModel(){
        return mapViewModel;
    }

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

    public void endgame(){
        game.endgame();
    }

    public int getTime() {
        return game.getSzamlalo();
    }

    /**
     * Ezt fogja a start() a végén meghívni, hogy folyamatosan futtathassa a játékot
     */
    public void jatekLeptetes() {
        while (game.getSzamlalo() < 900) {
            for (int i = 0; i < game.getPalya().getHallgatok().size(); ++i) {
                if (!game.getPalya().getHallgatok().get(i).getEszmeletvesztett()) {
                    update(game.getPalya().getHallgatok().get(i));
                }
            }
            boolean esz = true;
            for (Hallgato h : game.getPalya().getHallgatok()) {
                if (!h.getEszmeletvesztett()) {
                    esz = false;
                    break;
                }

            }
            if (esz) {
                if (game.getSzamlalo() % 30 == 0) {
                    game.getPalya().leptet();
                }
            } else
            game.getPalya().leptet();
        }
        endgame();
    }

    public void update(Hallgato h){
        SzobaViewModel szVW = new SzobaViewModel(h.getSzoba());
        HallgatoViewModel hVM = new HallgatoViewModel(h);
        gameFrame.updateGamePanel(szVW);
        gameFrame.updateMenuPanel(hVM);
        gameFrame.updateUserPanel(hVM);
    }


}
