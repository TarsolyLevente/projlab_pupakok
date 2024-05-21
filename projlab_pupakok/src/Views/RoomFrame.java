package Views;
import javax.swing.*;

import Szoba.Szoba;
import ViewModels.HallgatoViewModel;
import ViewModels.SzobaViewModel;

import java.awt.*;

//Hogyan adjuk át neki a szobát.

/**
 * A RoomFrame osztály, egy JFrame, amely megjeleníti a hallgató aktuális szobájának szomszédos szobáit.
 */
public class RoomFrame extends JFrame{
    //Ablak mérete statikus tagváltozókban.
    private final int height = 500;
    private final int width = 315;

    //Az ablakot felépítő panel, lista és gomb.
    private JPanel panel = new JPanel();
    private JScrollPane scrollpane;
    private JList<String> roomlist;
    private JButton movebutton = new JButton("Move");

    /**
     * A RoomFrame konstruktora, amely inicializálja az ablakot a megadott HallgatoViewModel alapján.
     * Beállítja az ablak méretét, lezárhatóságát, és alapértelmezett bezárási műveletét.
     * Létrehoz egy időzítőt, amely 400 milliszekundumonként ellenőrzi, hogy van-e kiválasztott szoba a listában,
     * és ennek megfelelően engedélyezi vagy letiltja a movebutton gombot.
     *
     * @param hvm a HallgatoViewModel objektum, amely a felhasználó aktuális állapotát tartalmazza
     */
    public RoomFrame(HallgatoViewModel hvm) {
        super("Room " + hvm.getHallgato().getSzoba().getid() + " szomszedjai");
        setSize(height, width);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        movebutton.setEnabled(false);
        Timer timer = new Timer(400, e -> {
            if(roomlist.getSelectedValue() != null){
                movebutton.setEnabled(true);
            } else {
                movebutton.setEnabled(false);
            }
        });
        timer.start();

        initComponents(hvm);
    }

    /**
     * Inicializálja és beállítja a RoomFrame komponenseit a megadott HallgatoViewModel alapján.
     *
     * @param hvm a HallgatoViewModel objektum, amely a felhasználó aktuális állapotát tartalmazza
     */
    private void initComponents(HallgatoViewModel hvm){
        this.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());

        SzobaViewModel ujSzobaViewModel = new SzobaViewModel(hvm.getHallgato().getSzoba());
        roomlist = new JList<>(ujSzobaViewModel.getNeighbouringRoomsNames());

        scrollpane = new JScrollPane(roomlist);

        movebutton.addActionListener(e -> {
            Szoba szoba = null;
            if (roomlist.getSelectedIndex() != -1) {
                szoba = hvm.getHallgato().getSzoba().getSzomszedok().get(roomlist.getSelectedIndex());
                hvm.mozgas(szoba);
                this.dispose();
            }
        });

        panel.add(scrollpane, BorderLayout.CENTER);
        panel.add(movebutton, BorderLayout.WEST);
        add(panel);
    }
}
