package Views;
import java.awt.*;
import javax.swing.*;

public class HomeFrame extends JFrame {
    private final int height = 500;
    private final int width = 315;
    private JLabel nameLabel = new JLabel();
    private JTextField hallgatoCount = new JTextField();
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

        startButton.addActionListener(e -> {new GameFrame(); this.setVisible(false);});
        panel.add(startButton);

        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton);

        this.add(panel);

        this.setVisible(true);

    
    }

}
