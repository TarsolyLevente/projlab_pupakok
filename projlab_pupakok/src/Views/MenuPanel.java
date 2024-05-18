package Views;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private JLabel timeLabel;
    private JLabel playerLabel;
    private JLabel roomLabel;
    

    public MenuPanel() {
        // Panel inicializálása és elrendezése
        setLayout(new GridLayout());
        timeLabel = new JLabel("Idő: ");
        playerLabel = new JLabel("Játékos: ");
        roomLabel = new JLabel("Szoba: ");


        // Panel elemeinek hozzáadása a panelhez
        add(timeLabel);
        add(playerLabel);
        add(roomLabel);
        
    }

}
