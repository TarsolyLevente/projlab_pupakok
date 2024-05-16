package Views;
import java.awt.*;
import javax.swing.*;

public class HomeFrame extends JFrame {
    private final int height = 500;
    private final int width = 315;
    private JLabel nameLabel = new JLabel("Logarléc");
    private JTextField hallgatoCount = new JTextField("hallgatok szama");
    private JButton startButton = new JButton("Start");
    private JButton exitButton = new JButton("Exit");
    private JPanel panel = new JPanel();


    public HomeFrame() {
        setSize(height, width);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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

        startButton.addActionListener(e -> {this.setVisible(false); new GameFrame();});
        panel.add(startButton, gbc);

        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton, gbc);

        panel.add(hallgatoCount, gbc);
        

        this.add(panel);

        this.setVisible(true);

    
    }

}
