package Views;

public class HomeFrame extends JFrame {
    private JLabel nameLabel = new JLabel();
    private JTextField hallgatoCount = new JTextField();
    private JButton startButton = new JButton("Start");
    private JButton exitButton = new JButton("Exit");
    private JPanel panel = new JPanel();


    public HomeFrame() {
        initComponents();
    }
    private void initComponents() {
        setLayout(new BorderLayout());
        startButton.addActionListener(e -> {
            // TODO
        });
        exitButton.addActionListener(e -> {
            // TODO
        });
    }
}
