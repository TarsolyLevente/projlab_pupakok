package Views;

import javax.swing.*;

import Targy.Camembert;
import Targy.Funkcio;
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
import java.awt.Window;

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

        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        if(hVM != null){
            targyLista = new JList<ImageIcon>(hVM.giveTaskabanLevoTargyakKepe());
            targyLista.setCellRenderer(new ImageListCellRenderer());
        }
        scrollpane = new JScrollPane(targyLista);
        scrollpane.setPreferredSize(new Dimension(90, 400));

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

        Timer timer = new Timer(400, e -> {
            if(targyLista.getSelectedValue() != null && !hVM.getHallgato().getEszmeletvesztett()){
                throwButton.setEnabled(true);
            } else{
                throwButton.setEnabled(false);
            }
            if(hVM != null && targyLista.getSelectedValue() != null && !hVM.getHallgato().getEszmeletvesztett()){
                if(hVM.getHallgato().getTaska().get(targyLista.getSelectedIndex()) instanceof Tranzisztor ||
                hVM.getHallgato().getTaska().get(targyLista.getSelectedIndex()) instanceof Legfrissito ||
                hVM.getHallgato().getTaska().get(targyLista.getSelectedIndex()) instanceof Camembert){
                    useButton.setEnabled(true);
                } else{
                    useButton.setEnabled(false);
                }
            } else {
                useButton.setEnabled(false);
            }
            if(hVM != null){
                if(hVM.getHallgato().getEszmeletvesztett()){
                    roomButton.setEnabled(false);
                } else {
                    roomButton.setEnabled(true);
                }
            } else {
                roomButton.setEnabled(true);
            }
        });
        timer.start();

        useButton.addActionListener(e -> {
            if(hVM.getHallgato().getTaska().get(targyLista.getSelectedIndex()).getFunkcio() == Funkcio.hamis){
                showFakeItemDialog();
            }
            if(targyLista.getSelectedIndex() != -1){
                hVM.hasznal(targyLista.getSelectedIndex());
                update(hVM);
            }
        });
        throwButton.addActionListener(e -> {
            if(targyLista.getSelectedIndex() != -1){
                hVM.eldob(targyLista.getSelectedIndex());
                update(hVM);
            }
        });
        roomButton.addActionListener(e -> {
            Window[] windows = Window.getWindows();
            for (Window window : windows) {
                if (window instanceof ItemFrame || window instanceof RoomFrame) {
                    ((JFrame) window).dispose();
                }
            }
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

    private void showFakeItemDialog(){
        JOptionPane.showMessageDialog(this, "A targy hamis, ezt jól be****");
    }
}
