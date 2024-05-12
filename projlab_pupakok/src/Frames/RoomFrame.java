import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//TODO
//Hogyan adjuk át neki a szobát.
public class RoomFrame extends JFrame{
    //Ablak mérete statikus tagváltozókban.
    private final int height = 500;
    private final int width = 315;

    //Az ablakot felépítő panel, lista és gomb.
    private JPanel panel = new JPanel();
    private JScrollPane scrollpane;
    private JList<ImageIcon> roomlist;
    private JButton movebutton = new JButton("Move");

    /*
     * A Frame konstruktora.
     */
    public RoomFrame(){
        super("Room " + room_id + " szomszedjai");
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
        roomlist = new JList<>();
        roomlist.setCellRenderer(new ImageListCellRenderer());


        scrollpane = new JScrollPane(roomlist);

        movebutton.addActionListener(e -> {
            //TODO
        });

        panel.add(scrollpane, BorderLayout.EAST);
        panel.add(movebutton, BorderLayout.WEST);
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
