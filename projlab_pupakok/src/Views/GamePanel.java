package Views;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.*;

import ViewModels.HallgatoViewModel;
import ViewModels.SzobaViewModel;
import ViewModels.TranzisztorViewModel;

/**
 * A GamePanel osztály, egy JPanel, amely a játék tábláját reprezentálja.
 */
public class GamePanel extends JPanel{
    private Container cp = new Container();
    public static final int GRID_SIZE = 9;
    private JComponent[][] cells = new JComponent[GRID_SIZE][GRID_SIZE];
    private JButton chestButton = new JButton("Chest");
    private HallgatoViewModel hVM;
    private ArrayList<JButton> transistorButtons = new ArrayList<JButton>();

    /**
     * A GamePanel osztály konstruktora, amely inicializálja a komponenseket.
     */
    public GamePanel()
    {
        initComponents();
    }
    
    /**
     * Inicializálja a GamePanel komponenseit és elrendezését.
     */
    public void initComponents()
    {
        setLayout(new BorderLayout());
        cp.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        
        Timer chestbuttontimer = new Timer(400, e -> {
            if(hVM != null)
            {
                if(hVM.getHallgato().getEszmeletvesztett())
                    chestButton.setEnabled(false);
                else
                chestButton.setEnabled(true);
            }
            else
            {
                chestButton.setEnabled(true);
                ((Timer)e.getSource()).stop();
            }
        });
        chestbuttontimer.start();

        Timer transistorbuttonstimer = new Timer(400, f -> {
            if(hVM != null)
            {
                if(hVM.getHallgato().getEszmeletvesztett()){
                    for(JButton button : transistorButtons){
                        button.setEnabled(false);
                    }
                }
                else{
                    for(JButton button : transistorButtons){
                        button.setEnabled(true);
                    }
                }
            }
            else
            {
                for(JButton button : transistorButtons){
                    button.setEnabled(true);
                }
                ((Timer)f.getSource()).stop();
            }
        });
        transistorbuttonstimer.start();

        // Konténer feltöltése a cellákkal
        this.add(cp);
    }

    /**
     * A GamePanel osztály update metódusa frissíti a panel tartalmát a kapott szoba és hallgatói viewmodell alapján.
     * 
     * @param szVM a SzobaViewModel, amely a szoba állapotát reprezentálja
     * @param hVM a HallgatoViewModel, amely a játékos állapotát reprezentálja
     */
    public void update(SzobaViewModel szVM, HallgatoViewModel hVM){
        this.hVM = hVM;
        setBackground(szVM.giveSzobaBackgroundColor());
        setBorder(BorderFactory.createLineBorder(szVM.giveSzobaFrameColor(), 5));

        

        cp.removeAll();

        //cellák feltöltése a karakterek képeivel.
        ImageIcon[] characterpictures;
        ArrayList<TranzisztorViewModel> transistorCount;
        try {
            characterpictures = szVM.getCharactersPictures();
            transistorCount = szVM.getActiveTransistorViewModels();
            ArrayList<ImageIcon> charactersTemp = new ArrayList<>(Arrays.asList(characterpictures));

        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                if((row  == (GRID_SIZE-1)) && (col == (GRID_SIZE-1)))
                {
                    try{
                        BufferedImage buttonIcon = ImageIO.read(new File("projlab_pupakok/src/resources/chest.png"));
                        Image scaledIcon = buttonIcon.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                        chestButton.setBorder(BorderFactory.createEmptyBorder());
                        chestButton = new JButton(new ImageIcon(scaledIcon));
                        chestButton.addActionListener(e ->{
                            Window[] windows = Window.getWindows();
                            for (Window window : windows) {
                                if (window instanceof RoomFrame || window instanceof ItemFrame) {
                                    ((JFrame) window).dispose();
                                }
                            }
                            hVM.createItemFrame(szVM);
                        });
                        cells[row][col] = chestButton;
                        cp.add(cells[row][col]);
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                else if(!charactersTemp.isEmpty()){
                    cells[row][col] = new JLabel(charactersTemp.get(0));
                    cp.add(cells[row][col]);
                    charactersTemp.remove(0);
                }
                else if (!transistorCount.isEmpty()) {
                    transistorButtons.add(new JButton(transistorCount.get(0).getItemImage()));
                    cells[row][col] = transistorButtons.get(transistorButtons.size() - 1);
                    cp.add(cells[row][col]);
                    transistorCount.remove(0);
                }
                else{
                    cells[row][col] = new JLabel();
                    cp.add(cells[row][col]);
                }
            }
        }

        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
}
