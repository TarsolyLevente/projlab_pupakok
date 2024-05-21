package ViewModels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import Game.Game;
import Karakter.Hallgato;
import Views.GameFrame;

/**
 * A GameViewModel osztály, amely a Game-t reprezentálja a nézethez.
 */
public class GameViewModel {
    private Game game;
    //hallgatók listája
    private ArrayList<Hallgato> gameHallgatok;
    private MapViewModel mapViewModel;
    private GameFrame gameFrame;

    /**
     * Visszaadja a játékablakot.
     * 
     * @return a játékablak
     */
    public GameFrame getGameFrame() {
        return gameFrame;
    }

    /**
     * A GameViewModel osztály konstruktora inicializálja a játékmodellt, a térképnézetmodellt és a játékablakot,
     * majd elindítja a játékot a megadott játékosok számával.
     * 
     * @param jatekosokszama a játékosok száma
     */
    public GameViewModel(int jatekosokszama){
        
        game = new Game();
        mapViewModel = new MapViewModel(game.getPalya());
        gameFrame = new GameFrame();
        start(jatekosokszama);
        gameHallgatok = new ArrayList<>(game.getPalya().getHallgatok());
    }

    /**
     * Visszaadja a térképnézetmodellt.
     * 
     * @return a térképnézetmodell
     */
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
        while (game.getSzamlalo() < 900000 && !game.getJatekVege()) {
            
            for (int i = 0; i < game.getPalya().getHallgatok().size(); ++i) {
                ArrayList<Hallgato> kibukottHallgatok = kibukottehallgato();
                for (Hallgato hallgato : kibukottHallgatok) {
                    getGameFrame().showKibukasDialog(new HallgatoViewModel(hallgato));
                }
                
                if (!game.getPalya().getHallgatok().get(i).getEszmeletvesztett()  && !game.getJatekVege()) {
                    update(game.getPalya().getHallgatok().get(i));
                }
            }
            boolean esz = true;
            for (int i = 0; i < game.getPalya().getHallgatok().size(); i++) {
                if (!game.getPalya().getHallgatok().get(i).getEszmeletvesztett()) {
                    esz = false;
                    break;
                }
            }
            if (esz) {
                if (game.getSzamlalo() % 30000 == 0) {
                    game.getPalya().leptet();
                    System.err.println("asdasgfasgasgasgassgaasgs");
                }
            } else {
                game.getPalya().leptet();
                System.err.println("asdasgfasgasgasgassgaasgs");
            }
        }
    }

    /**
     * Frissíti a játék keretét és paneljeit a megadott játékos állapotával és szobájával kapcsolatos információkkal.
     * 
     * @param h a játékos, akinek az állapotát frissíteni kell
     */
    public synchronized void update(Hallgato h) {
        SzobaViewModel szVW = new SzobaViewModel(h.getSzoba());
        HallgatoViewModel hVM = new HallgatoViewModel(h, this);
        gameFrame.updateGamePanel(szVW, hVM);
        gameFrame.updateMenuPanel(hVM);
        gameFrame.updateUserPanel(hVM);
        try {
            wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(h.getEszmeletvesztett()){
            getGameFrame().showEszmeletvesztesDialog(hVM);
            notifyAll();
        }
    }
    public ArrayList<Hallgato> kibukottehallgato() {
        ArrayList<Hallgato> akthallgatok = new ArrayList<>(game.getPalya().getHallgatok());
        ArrayList<Hallgato> kibukottHallgatok = new ArrayList<>();
    
        if (!gameHallgatok.equals(akthallgatok)) {
            for (Hallgato hallgato : gameHallgatok) {
                if (!akthallgatok.contains(hallgato)) {
                    kibukottHallgatok.add(hallgato);
                }
            }
            gameHallgatok = new ArrayList<>(game.getPalya().getHallgatok());
        }
    
        return kibukottHallgatok;
    }
}
