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


    public GamePanel(SzobaViewModel szvm)
    {
        
        initComponents(szvm);
    }
    
    public void initComponents(SzobaViewModel szvm)
    {
        setLayout(new BorderLayout());
        cp.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        // Konténer feltöltése a cellákkal
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                if((row  == (GRID_SIZE-1)) && (col == (GRID_SIZE-1)))
                {   
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
                
                cells[row][col].setBackground(szvm.giveSzobaBackgroundColor());
                cp.add(cells[row][col]);
                //TODO Lehet fel lehet használni ezért itt hagyom
                //cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                //cells[row][col].setFont(FONT_NUMBERS);

                // DocumentListener hozzáadása minden egyes JTextField-hez
                //cells[row][col].getDocument().addDocumentListener(new SudokuDocumentListener(row, col));

                // ActionListener hozzáadása minden egyes JTextField-hez
                //cells[row][col].addActionListener(new SudokuActionListener(row, col));
                }
            }
        }

        //cellák feltöltése a karakterek képeivel.
        ImageIcon[] characterpictures = szvm.getCharactersPictures();
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                ((JLabel)cells[row][col]).setIcon(characterpictures[col]);
            }
        }

        this.add(cp);
    }
}
