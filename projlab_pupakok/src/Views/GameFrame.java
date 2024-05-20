package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.MenuEvent;

import Game.Game;
import Karakter.Hallgato;
import Szoba.Szoba;
import Targy.Camembert;
import Targy.Legfrissito;
import Targy.Tranzisztor;
import ViewModels.GameViewModel;
import ViewModels.HallgatoViewModel;
import ViewModels.SzobaViewModel;

public class GameFrame extends JFrame
{
    private UserPanel userPanel;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private final int height = 600;
    private final int width = 600;
    
    private ArrayList<JLabel> characterLabels = new ArrayList<JLabel>();
    private ArrayList<JButton> transistorButtons = new ArrayList<JButton>();
    
        


    public GameFrame() {
        setLayout(new BorderLayout());
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        initComponents();
    };


    
    public void initComponents() 
    {
        

        gamePanel = new GamePanel();
        userPanel = new UserPanel();
        menuPanel = new MenuPanel();

        menuPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        userPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        this.add(menuPanel, BorderLayout.NORTH);
        this.add(userPanel, BorderLayout.EAST);
        this.add(gamePanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void updateGamePanel(SzobaViewModel szvm, HallgatoViewModel hvm){
        gamePanel.update(szvm, hvm);
    }

    public void updateUserPanel(HallgatoViewModel hvm){
        userPanel.update(hvm);
    }

    public void updateMenuPanel(HallgatoViewModel hvm){
        menuPanel.update(hvm);
    }


}
