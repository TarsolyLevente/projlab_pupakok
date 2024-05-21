package Views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import ViewModels.HallgatoViewModel;
import ViewModels.SzobaViewModel;

/**
 * A GameFrame osztály egy JFrame, amely a játék fő ablakát reprezentálja.
 */
public class GameFrame extends JFrame
{
    private UserPanel userPanel;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private final int height = 600;
    private final int width = 600;
    
    /**
     * A GameFrame osztály konstruktora, inicializálja az ablakot és a komponenseket.
     */
    public GameFrame() {
        setLayout(new BorderLayout());
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        initComponents();
    };

    /**
     * A GameFrame osztály konstruktora, inicializálja az ablakot és a komponenseket.
     */
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

    /**
     * Frissíti a GamePanel tartalmát a kapott szoba és hallgatói modell alapján.
     * 
     * @param szvm a SzobaViewModel, amely a szoba állapotát reprezentálja
     * @param hvm a HallgatoViewModel, amely a játékos állapotát reprezentálja
     */
    public void updateGamePanel(SzobaViewModel szvm, HallgatoViewModel hvm){
        gamePanel.update(szvm, hvm);
    }

    /**
     * Frissíti a UserPanel tartalmát a kapott hallgatói modell alapján.
     * 
     * @param hvm a HallgatoViewModel, amely a játékos állapotát reprezentálja
     */
    public void updateUserPanel(HallgatoViewModel hvm){
        userPanel.update(hvm);
    }

    /**
     * Frissíti a MenuPanel tartalmát a kapott hallgatói modell alapján.
     * 
     * @param hvm a HallgatoViewModel, amely a játékos állapotát reprezentálja
     */
    public void updateMenuPanel(HallgatoViewModel hvm){
        menuPanel.update(hvm);
    }

    /**
     * Megjeleníti az eszméletvesztés dialógusablakot a kapott hallgatói modell alapján.
     * 
     * @param hvm a HallgatoViewModel, amely a játékos állapotát reprezentálja
     */
    public void showEszmeletvesztesDialog(HallgatoViewModel hvm){
        JOptionPane.showMessageDialog(this, "Hallgató " + hvm.getHallgatoID() + " elvesztette az eszméletét:(");
    }

    /**
     * Megjeleníti a kibukás dialógusablakot a kapott hallgatói modell alapján.
     * 
     * @param hvm a HallgatoViewModel, amely a játékos állapotát reprezentálja
     */
    public void showKibukasDialog(HallgatoViewModel hvm){
        JOptionPane.showMessageDialog(this, "Hallgató " + hvm.getHallgatoID() + " kibukott!! :(");
    }
}
