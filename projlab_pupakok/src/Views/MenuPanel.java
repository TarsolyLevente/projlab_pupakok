package Views;

import javax.swing.*;

import ViewModels.GameViewModel;
import ViewModels.HallgatoViewModel;

import java.awt.*;

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
        timeLabel = new JLabel("Idő: 0");
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
        timeLabel.setText("Idő: " + Time);
    }

    public void update(HallgatoViewModel hVM){
        playerLabel = new JLabel("Játékos: " + hVM.getHallgatoID() );
        roomLabel = new JLabel("Szoba: "+ hVM.getSzobaID());
    }

}
