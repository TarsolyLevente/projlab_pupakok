package Views;

import javax.swing.*;

public class GameFrame extends JFrame
{
    private JPanel gamePanel = new JPanel();
    public Game game;
    private JButton chestButton = new JButton("Chest");
    private ArrayList<JLabel> characterLabels = new ArrayList<JLabel>();
    private ArrayList<JButton> transistorButtons = new ArrayList<JButton>();


    public GameFrame() {initComponents();}
    private void initComponents() {
        chestButton.addActionListener(e -> {
            //TODO
        });
        for (JButton b : transistorButtons) {
            b.addActionListener(e -> {
                //TODO
            });
        }
    }
    // TODO labels

}