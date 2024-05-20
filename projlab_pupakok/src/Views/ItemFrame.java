package Views;
import javax.swing.*;

import ViewModels.HallgatoViewModel;
import ViewModels.SzobaViewModel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//TODO
//Hogyan adjuk át neki a szobát.
public class ItemFrame extends JFrame{
    //Ablak mérete statikus tagváltozókban.
    private final int height = 500;
    private final int width = 315;

    //Az ablakot felépítő panel, lista és gomb.
    private JPanel panel = new JPanel();
    private JScrollPane scrollpane;
    private JList<ImageIcon> itemlist;
    private JButton pickupbutton = new JButton("Felvesz");

    public ItemFrame(SzobaViewModel szvm, HallgatoViewModel hvm){
        super("Room " + szvm.getSzoba().getid() + " targyai");
        setSize(height, width);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents(szvm, hvm);
        this.setVisible(true);
    }

    /*
    * A Framet inicializáló függvény.
    */
    private void initComponents(SzobaViewModel szvm, HallgatoViewModel hvm){
        this.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());

        itemlist = new JList<ImageIcon>(szvm.getItemsPictures());
        itemlist.setCellRenderer(new ImageListCellRenderer());


        scrollpane = new JScrollPane(itemlist);

        pickupbutton.addActionListener(e -> {
            //összerendeljük a képet a tárggyal
            hvm.felvesz(szvm.getSzoba().getTargyak().get(itemlist.getSelectedIndex()));
            this.dispose();
            
        });

        panel.add(scrollpane, BorderLayout.CENTER);
        panel.add(pickupbutton, BorderLayout.WEST);
        add(panel);
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

