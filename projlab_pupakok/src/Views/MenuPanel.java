package Views;

import javax.swing.*;

import Karakter.Hallgato;
import Szoba.Szoba;
import ViewModels.GameViewModel;
import ViewModels.HallgatoViewModel;

import java.awt.*;
import java.util.concurrent.TimeoutException;

/**
 * A MenuPanel osztály, egy JPanel, amely a játék menüjének elemeit tartalmazza, mint például az idő, a játékos és a szoba információit.
 */
public class MenuPanel extends JPanel {
    private JLabel timeLabel;
    private JLabel playerLabel;
    private JLabel roomLabel;
    private Timer updateTimer;
    private int Time;

    /**
     * A MenuPanel konstruktora, amely inicializálja a komponenseket és elindítja az időzítőt.
     */
    public MenuPanel() {

        initComponents();
    }

    /**
     * Inicializálja a panel komponenseit és elrendezését.
     * Létrehozza és beállítja az idő labelt, a játékos labelt és a szoba labelt.
     * Hozzáadja ezeket a komponenseket a panelhez, majd elindít egy időzítőt, amely másodpercenként frissíti az idő labelt.
     */
    private void initComponents() {
        // Panel inicializálása és elrendezése
        setLayout(new GridLayout());
        timeLabel = new JLabel("Idő: 00:00");
        playerLabel = new JLabel("Játékos: " );
        roomLabel = new JLabel("Szoba: ");
        Time=0;

        

        // Panel elemeinek hozzáadása a panelhez
        add(timeLabel);
        add(playerLabel);
        add(roomLabel);
        
        // Timer to update the time label every second
        updateTimer = new Timer(1000, e -> updateLabels());
        updateTimer.start();
    }

    /**
     * Frissíti az idő labelt az eltelt idő alapján.
     */
    private void updateLabels() {
        Time++;
        timeLabel.setText("Idő: " + formatTime(Time));
    }

    /**
     * Frissíti a játékos és a szoba labeleket a megadott HallgatoViewModel alapján.
     *
     * @param hVM a HallgatoViewModel objektum, amely a felhasználó aktuális állapotát tartalmazza
     */
    public void update(HallgatoViewModel hVM){
        
        playerLabel.setText("Játékos: " + hVM.getHallgatoID());
        roomLabel.setText("Szoba: "+ hVM.getSzobaID());
    }

    /**
     * Az időt másodpercben átalakítja "mm:ss" formátumra.
     *
     * @param seconds az eltelt idő másodpercben
     * @return az eltelt idő "mm:ss" formátumban
     */
    String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

}
