package Views;
import javax.swing.*;

import Szoba.Szoba;
import ViewModels.HallgatoViewModel;
import ViewModels.SzobaViewModel;

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
    private JList<String> roomlist;
    private JButton movebutton = new JButton("Move");

    /*
     * A Frame konstruktora.
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

    /*
     * A Framet inicializáló függvény.
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
                if(!hvm.mozgas(szoba)){
                    showKibukasDialog(hvm);
                }
                this.dispose();
            }
        });

        panel.add(scrollpane, BorderLayout.CENTER);
        panel.add(movebutton, BorderLayout.WEST);
        add(panel);
    }

    private void showKibukasDialog(HallgatoViewModel hvm){
        JOptionPane.showMessageDialog(this, "Hallgató " + hvm.getHallgatoID() + " kibukott!! :(");
    }
}
