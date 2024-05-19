package Views;

import javax.swing.*;

import ViewModels.GameViewModel;
import ViewModels.HallgatoViewModel;

import java.awt.*;

public class MenuPanel extends JPanel {
    private JLabel timeLabel;
    private JLabel playerLabel;
    private JLabel roomLabel;
    private HallgatoViewModel hVM;
    private GameViewModel gVM;
    private Timer updateTimer;

    public MenuPanel(HallgatoViewModel viewModel,GameViewModel gameViewModel ) {
        hVM = viewModel;
        gVM = gameViewModel;
        initComponents();
    }

    private void initComponents() {
        // Panel inicializálása és elrendezése
        setLayout(new GridLayout());
        timeLabel = new JLabel("Idő: 0");
        playerLabel = new JLabel("Játékos: " + hVM.getHallgato().getid());
        roomLabel = new JLabel("Szoba: "+ hVM.getHallgato().getSzoba().getid());


        

        // Panel elemeinek hozzáadása a panelhez
        add(timeLabel);
        add(playerLabel);
        add(roomLabel);
        
        // Timer to update the time label every second
        updateTimer = new Timer(1000, e -> updateLabels());
        updateTimer.start();
    }

    
    private void updateLabels() {
        timeLabel.setText("Idő: " + gVM.getTime());
    }

}
