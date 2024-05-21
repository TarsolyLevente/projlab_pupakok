package Views;
import javax.swing.*;

import ViewModels.HallgatoViewModel;
import ViewModels.SzobaViewModel;

import java.awt.*;

//Hogyan adjuk át neki a szobát.

/**
 * Az ItemFrame osztály, egy JFrame, amely megjeleníti a szoba tárgyait és lehetőséget biztosít azok felvételére.
 */
public class ItemFrame extends JFrame{
    //Ablak mérete statikus tagváltozókban.
    private final int height = 500;
    private final int width = 315;

    //Az ablakot felépítő panel, lista és gomb.
    private JPanel panel = new JPanel();
    private JScrollPane scrollpane;
    private JList<ImageIcon> itemlist;
    private JButton pickupbutton = new JButton("Felvesz");

    /**
     * Az ItemFrame konstruktora, amely inicializálja az ablakot a megadott SzobaViewModel és HallgatoViewModel alapján.
     * Beállítja az ablak méretét, lezárhatóságát, és alapértelmezett bezárási műveletét.
     * Létrehoz egy időzítőt, amely 400 milliszekundumonként ellenőrzi, hogy van-e kiválasztott tárgy a listában,
     * és ennek megfelelően engedélyezi vagy letiltja a pickupbutton gombot.
     *
     * @param szvm a SzobaViewModel objektum, amely a szoba aktuális állapotát tartalmazza
     * @param hvm a HallgatoViewModel objektum, amely a felhasználó aktuális állapotát tartalmazza
     */
    public ItemFrame(SzobaViewModel szvm, HallgatoViewModel hvm){
        super("Szoba " + szvm.getSzoba().getid() + " targyai");
        setSize(height, width);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pickupbutton.setEnabled(false);
        Timer timer = new Timer(400, e -> {
            if(itemlist.getSelectedValue() != null){
                pickupbutton.setEnabled(true);
            } else {
                pickupbutton.setEnabled(false);
            }
        });
        timer.start();

        initComponents(szvm, hvm);
        this.setVisible(true);
    }

    /**
     * Inicializálja és beállítja az ItemFrame komponenseit a megadott SzobaViewModel és HallgatoViewModel alapján.
     *
     * @param szvm a SzobaViewModel objektum, amely a szoba aktuális állapotát tartalmazza
     * @param hvm a HallgatoViewModel objektum, amely a felhasználó aktuális állapotát tartalmazza
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

    /**
     * Az ImageListCellRenderer osztály, egy JLabel, amely egyedi listacella megjelenítést biztosít ImageIcon elemekhez.
     */
    private class ImageListCellRenderer extends JLabel implements ListCellRenderer<ImageIcon> {
        public ImageListCellRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        /**
         * Visszaad egy komponenst, amely az aktuális cella megjelenítésére szolgál a listában.
         * Beállítja a cella ikonját és a háttér- és előtérszínt a kiválasztás állapotának megfelelően.
         *
         * @param list a JList, amely tartalmazza a cellát
         * @param value az ImageIcon érték, amely a cellában megjelenik
         * @param index a cella indexe a listában
         * @param isSelected true, ha a cella ki van választva
         * @param cellHasFocus true, ha a cellának van fókusza
         * @return a komponens, amely a cellát megjeleníti
         */
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

