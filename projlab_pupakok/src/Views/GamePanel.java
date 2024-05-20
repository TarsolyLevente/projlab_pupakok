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

public class GamePanel extends JPanel{
    private Container cp = new Container();
    public static final int GRID_SIZE = 9;
    private JComponent[][] cells = new JComponent[GRID_SIZE][GRID_SIZE];
    private JButton chestButton = new JButton("Chest");


    public GamePanel()
    {
        
        initComponents();
    }
    
    public void initComponents()
    {
        setLayout(new BorderLayout());
        cp.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        // Konténer feltöltése a cellákkal
        this.add(cp);
    }

    public void update(SzobaViewModel szVM, HallgatoViewModel hVM){
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
                    cells[row][col] = new JButton(transistorCount.get(0).getItemImage());
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
