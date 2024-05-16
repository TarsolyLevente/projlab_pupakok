package Views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Game.Game;
import Karakter.Hallgato;
import Szoba.Szoba;
import ViewModels.GameViewModel;
import ViewModels.HallgatoViewModel;
import ViewModels.SzobaViewModel;

public class GameFrame extends JFrame
{
    private GameViewModel viewModel= new GameViewModel(new Game());
    private UserPanel userPanel = new UserPanel(new HallgatoViewModel());
    private final int height = 500;
    private final int width = 315;
    private JPanel gamePanel = new JPanel();
    public Game game = new Game();
    private JButton chestButton = new JButton("Chest");
    private ArrayList<JLabel> characterLabels = new ArrayList<JLabel>();
    private ArrayList<JButton> transistorButtons = new ArrayList<JButton>();


    public GameFrame() {
        setSize(height, width);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(this.MAXIMIZED_BOTH);
        initComponents();
    };

    public void initComponents() 
    {
        this.setLayout(new GridLayout());
        gamePanel.setLayout(new GridLayout());

        gamePanel.add(chestButton);
        for (Hallgato hallgato: game.getPalya().getHallgatok()) 
        {
            characterLabels.add(new JLabel("" + hallgato.getid()));
            //Mit mutasson épp?
        }
        

        chestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
      //          new ItemFrame(new SzobaViewModel(new Szoba(true, 2), ));
            }
        });

        //viewModel.start();
        this.add(gamePanel, BorderLayout.SOUTH);
        this.add(userPanel, BorderLayout.EAST);
        this.setVisible(true);
        //TODO aktiv tranzisztorok?

        
    }
}
