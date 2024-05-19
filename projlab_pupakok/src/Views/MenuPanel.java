package Views;

import javax.swing.*;

import ViewModels.GameViewModel;
import ViewModels.HallgatoViewModel;

import java.awt.*;
import java.util.concurrent.TimeoutException;

public class MenuPanel extends JPanel {
    private JLabel timeLabel;
    private JLabel playerLabel;
    private JLabel roomLabel;
    private Timer updateTimer;
    private int Time;

    public MenuPanel() {

        initComponents();
    }

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

    
    private void updateLabels() {
        Time++;
        timeLabel.setText("Idő: " + formatTime(Time));
    }

    public void update(HallgatoViewModel hVM){
        playerLabel = new JLabel("Játékos: " + hVM.getHallgatoID() );
        roomLabel = new JLabel("Szoba: "+ hVM.getSzobaID());
    }

    String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

}
