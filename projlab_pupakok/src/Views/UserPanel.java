package Views;

import javax.swing.*;

import ViewModels.HallgatoViewModel;

import java.awt.Image; // Import the Image class from java.awt
import javax.imageio.ImageIO; // Import the ImageIO class from javax.imageio
import java.awt.BorderLayout; // Import the BorderLayout class from java.awt

public class UserPanel extends JPanel {
    private JScrollPane scrollpane;
    private JList<ImageIcon> targyLista;
    private JButton useButton = new JButton("Használ");
    private JButton throwButton = new JButton("Eldob");
    private JButton roomButton = new JButton("Mozog");
    private HallgatoViewModel hVM;

    public UserPanel(HallgatoViewModel viewModel) {
        hVM = viewModel;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        scrollpane = new JScrollPane(targyLista);


        try {
            Image img = ImageIO.read(getClass().getResource("resources/move.png"));
            roomButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        useButton.addActionListener(e -> {
            hVM.hasznal(targyLista.getSelectedIndex());
        });
        throwButton.addActionListener(e -> {
            hVM.hasznal(targyLista.getSelectedIndex());
        });
        roomButton.addActionListener(e -> {
            hVM.mozgas();
        });

        add(scrollpane, BorderLayout.NORTH);
        add(useButton, BorderLayout.CENTER);
        add(throwButton, BorderLayout.CENTER);
        add(roomButton, BorderLayout.SOUTH);
    }
}
