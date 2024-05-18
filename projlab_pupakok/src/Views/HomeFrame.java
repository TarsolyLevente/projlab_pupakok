package Views;
import java.awt.*;
import javax.swing.*;

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

        startButton.addActionListener(e -> {showHallgatoCountDialog();this.setVisible(false); new GameFrame();});
        panel.add(startButton, gbc);

        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton, gbc);

        this.add(panel);

        this.setVisible(true);
    
    }

    private void showHallgatoCountDialog() {
        String temp = JOptionPane.showInputDialog(this, "Hallgatók száma:");
        hallagatocnt = Integer.valueOf(temp);
    }

}
