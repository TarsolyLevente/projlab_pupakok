package Views;

import javax.swing.*;

import Targy.Camembert;
import Targy.Legfrissito;
import Targy.Tranzisztor;
import ViewModels.HallgatoViewModel;

import java.awt.Image; // Import the Image class from java.awt
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO; // Import the ImageIO class from javax.imageio
import java.awt.BorderLayout; // Import the BorderLayout class from java.awt
import java.awt.Component;
import java.awt.Dimension;

public class UserPanel extends JPanel {
    private JScrollPane scrollpane;
    private JList<ImageIcon> targyLista;
    private JButton useButton = new JButton("Használ");
    private JButton throwButton = new JButton("Eldob");
    private JButton roomButton;
    private HallgatoViewModel hVM;

    public UserPanel() {
        targyLista = new JList<ImageIcon>();
        useButton.setEnabled(false);
        throwButton.setEnabled(false);

        Timer timer = new Timer(400, e -> {
            if(targyLista.getSelectedValue() != null){
                throwButton.setEnabled(true);
            } else{
                throwButton.setEnabled(false);
            }
            if(hVM != null && hVM.getHallgato().getTaska().size() != 0){
                if(hVM.getHallgato().getTaska().get(targyLista.getSelectedIndex()) instanceof Tranzisztor ||
                hVM.getHallgato().getTaska().get(targyLista.getSelectedIndex()) instanceof Legfrissito ||
                hVM.getHallgato().getTaska().get(targyLista.getSelectedIndex()) instanceof Camembert){
                    useButton.setEnabled(true);
                } else{
                    useButton.setEnabled(false);
                }
            }
        });
        timer.start();

        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        if(hVM != null){
            targyLista = new JList<ImageIcon>(hVM.giveTaskabanLevoTargyakKepe());
            targyLista.setCellRenderer(new ImageListCellRenderer());
        }
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
            update(hVM);
        });
        throwButton.addActionListener(e -> {
            hVM.eldob(targyLista.getSelectedIndex());
            update(hVM);
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
        DefaultListModel<ImageIcon> LM = new DefaultListModel<>();
        for (ImageIcon icon : hVM.giveTaskabanLevoTargyakKepe()) {
            LM.addElement(icon);
        }
        targyLista.setModel(LM);
        targyLista.setCellRenderer(new ImageListCellRenderer());
        scrollpane.setViewportView(targyLista);

    }

    private class ImageListCellRenderer extends JLabel implements ListCellRenderer<ImageIcon> {
        public ImageListCellRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends ImageIcon> list, ImageIcon value, int index, boolean isSelected, boolean cellHasFocus) {
            setIcon(value);
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            return this;
        }
    }
}
