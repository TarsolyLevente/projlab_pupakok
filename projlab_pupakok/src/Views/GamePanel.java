package Views;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import ViewModels.SzobaViewModel;

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

    public void update(SzobaViewModel szVM){
        setBackground(szVM.giveSzobaBackgroundColor());
        setBorder(BorderFactory.createLineBorder(szVM.giveSzobaFrameColor(), 5));

        //cellák feltöltése a karakterek képeivel.
        ImageIcon[] characterpictures;
        try {
            characterpictures = szVM.getCharactersPictures();  


        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                if((row  == (GRID_SIZE-1)) && (col == (GRID_SIZE-1)))
                {   
                    //TODO tranzisztor
                    try{
                        BufferedImage buttonIcon = ImageIO.read(new File("projlab_pupakok/src/resources/chest.png"));
                        chestButton.setBorder(BorderFactory.createEmptyBorder());
                        cells[row][col] = new JButton(new ImageIcon(buttonIcon));
                        cp.add(cells[row][col]);
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                else if(row == 0 && col < characterpictures.length){
                    cells[row][col] = new JLabel(characterpictures[col]);
                    cp.add(cells[row][col]);
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
