package Views;

import java.awt.*;

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

        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                if((row  == (GRID_SIZE-1)) && (col == (GRID_SIZE-1)))
                {   
                    //TODO tranzisztor
                    try{
                        Image img = ImageIO.read(getClass().getResource("resources/chest.png"));
                        chestButton.setIcon(new ImageIcon(img));
                        cells[row][col] = chestButton;
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                else{
                cells[row][col] = new JLabel();
                
                cells[row][col].setBackground(szVM.giveSzobaBackgroundColor());
                cp.add(cells[row][col]);
                }
            }
        }
         //cellák feltöltése a karakterek képeivel.
        ImageIcon[] characterpictures = szVM.getCharactersPictures();
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                ((JLabel)cells[row][col]).setIcon(characterpictures[col]);
            }
        }
    }
}
