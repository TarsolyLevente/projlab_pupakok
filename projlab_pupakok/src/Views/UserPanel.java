package Views;

import javax.swing.*;

import ViewModels.HallgatoViewModel;

import java.awt.Image; // Import the Image class from java.awt
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO; // Import the ImageIO class from javax.imageio
import java.awt.BorderLayout; // Import the BorderLayout class from java.awt
import java.awt.Dimension;

public class UserPanel extends JPanel {
    private JScrollPane scrollpane;
    private JList<ImageIcon> targyLista;
    private JButton useButton = new JButton("Használ");
    private JButton throwButton = new JButton("Eldob");
    private JButton roomButton = new JButton("Mozog");
    private HallgatoViewModel hVM;

    public UserPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        scrollpane = new JScrollPane(targyLista);


        try {
            BufferedImage buttonIcon = ImageIO.read(new File("projlab_pupakok/src/resources/move.png"));
            roomButton = new JButton(new ImageIcon(buttonIcon));
            //roomButton.setBorder(BorderFactory.createEmptyBorder()); - ezt kivettem
            roomButton.setContentAreaFilled(false);
            roomButton.setPreferredSize(new Dimension(90,25));
            //ezek meg nem biztos hogy kellenek
            throwButton.setPreferredSize(new Dimension(90,25));
            useButton.setPreferredSize(new Dimension(90,25));
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

        add(scrollpane);
        add(useButton);
        add(throwButton);
        add(roomButton);
    }

    public void update(HallgatoViewModel hVM) {
        this.hVM = hVM;
        this.revalidate();
        /*
         * DefaultListModel<ImageIcon> listModel = new DefaultListModel<>();
         * 
         * for (int i = 0; i < hVM.getHallgato().getTargyak().size(); i++) {
         * listModel.addElement(new
         * ImageIcon(hVM.getHallgato().getTargyak().get(i).getKep()));
         * }
         * targyLista = new JList<>(listModel);
         * scrollpane.setViewportView(targyLista);
         */
    }
}
