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

    public MenuPanel(HallgatoViewModel viewModel,GameViewModel gVM ) {
        hVM = viewModel;
        initComponents();
    }

    private void initComponents() {
        // Panel inicializálása és elrendezése
        setLayout(new GridLayout());
        timeLabel = new JLabel("Idő: ");
        playerLabel = new JLabel("Játékos: " + hVM.getHallgato().getid());
        roomLabel = new JLabel("Szoba: "+ hVM.getHallgato().getSzoba().getid());


        

        // Panel elemeinek hozzáadása a panelhez
        add(timeLabel);
        add(playerLabel);
        add(roomLabel);
        
    }

}
