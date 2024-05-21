package Views;
import java.awt.*;
import javax.swing.*;

import ViewModels.GameViewModel;

public class HomeFrame extends JFrame {
    private final int height = 600;
    private final int width = 600;
    String title = "<html>" + "<font size='100' color='red'><strong>Logarléc \n</strong></font>" +"</html>";
    private JLabel nameLabel = new JLabel(title);
    private JButton startButton = new JButton("Start");
    private JButton exitButton = new JButton("Exit");
    private JPanel panel = new JPanel();
    int hallagatocnt = 0;


    public HomeFrame() {
        setSize(height, width);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        initComponents();
    }
    private void initComponents() {
        this.setLayout(new BorderLayout());
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        panel.add(nameLabel, gbc);

        startButton.addActionListener(e -> {
            int jatekosokszama = showHallgatoCountDialog();
            if(jatekosokszama > 0){
                this.setVisible(false);
            GameViewModel gameViewModel = new GameViewModel(jatekosokszama);
            Timer timer = new Timer(400, d -> {
                if(gameViewModel.getGame().getJatekVege())
                {
                    showEndGameDialog(gameViewModel.getGame().endgame());
                    gameViewModel.getGameFrame().dispose();
                    ((Timer)d.getSource()).stop();
                }
            });
            timer.start();
            SwingUtilities.invokeLater(() -> {
                Thread gThread = new Thread(() -> {
                        gameViewModel.jatekLeptetes();
                });
                gThread.start();
            });
            }
            
        });

        
        
        panel.add(startButton, gbc);

        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton, gbc);

        this.add(panel);

        this.setVisible(true);
    
    }

    private int showHallgatoCountDialog() {
        String temp = JOptionPane.showInputDialog(this, "Hallgatók száma:");
        
        // Ha a felhasználó megnyomta a "Mégsem" gombot vagy bezárta az ablakot, a temp null lesz.
        if (temp == null) {

            return -1; // Speciális érték a "Mégsem" gomb vagy az ablak bezárásának jelzésére.
        }
        try {
            hallagatocnt = Integer.valueOf(temp);
            if(hallagatocnt <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            hallagatocnt = showHallgatoCountDialog();
        }
        return hallagatocnt;
    }

    private void showEndGameDialog(int endgameType) {
        if(endgameType == 1)
            JOptionPane.showMessageDialog(this, "Letelt az idő!");
        else if(endgameType == 2)
            JOptionPane.showMessageDialog(this, "Az utolsó hallgató is kibukott!");
        else
            JOptionPane.showMessageDialog(this, "Szép volt pupákok!");
    }


}
