import javax.swing.*;
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

    public ItemFrame(){
        super("Room " + room_id + " targyai");
        setSize(height, width);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    /*
    * A Framet inicializáló függvény.
    */
    private void initComponents(){
        this.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());


        //TODO
        //Elő kell állítani a megjelenítendő ImageIcon tömböt.
        itemlist = new JList<>();
        itemlist.setCellRenderer(new ImageListCellRenderer());


        scrollpane = new JScrollPane(itemlist);

        pickupbutton.addActionListener(e -> {
            //TODO
        });

        panel.add(scrollpane, BorderLayout.EAST);
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

