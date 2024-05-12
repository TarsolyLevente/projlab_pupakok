package Views;
import Game;

import javax.swing.*;

public class GameFrame extends JFrame
{
    private JPanel gamePanel = new JPanel();
    public Game game;
    private JButton chestButton = new JButton("Chest");
    private ArrayList<JLabel> characterLabels = new ArrayList<JLabel>();
    private ArrayList<JButton> transistorButtons = new ArrayList<JButton>();
}