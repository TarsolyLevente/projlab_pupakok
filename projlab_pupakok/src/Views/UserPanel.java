package Views;

import javax.swing.*;

import Targy.Camembert;
import Targy.Funkcio;
import Targy.Legfrissito;
import Targy.Tranzisztor;
import ViewModels.HallgatoViewModel;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;

/**
 * A felhasználói felület panelje, amely különböző gombokat és egy listát tartalmaz.
 * A panel lehetőséget biztosít a felhasználónak tárgyak használatára vagy eldobására.
 */
public class UserPanel extends JPanel {
    private JScrollPane scrollpane;
    private JList<ImageIcon> targyLista;
    private JButton useButton = new JButton("Használ");
    private JButton throwButton = new JButton("Eldob");
    private JButton roomButton;
    private HallgatoViewModel hVM;

    /**
     * A UserPanel osztály konstruktora, amely inicializálja a panel komponenseit.
     */
    public UserPanel() {
        targyLista = new JList<ImageIcon>();
        useButton.setEnabled(false);
        throwButton.setEnabled(false);

        initComponents();
    }

    /**
     * Inicializálja és beállítja a panel komponenseit és elrendezését.
     */
    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        if(hVM != null){
            targyLista = new JList<ImageIcon>(hVM.giveTaskabanLevoTargyakKepe());
            targyLista.setCellRenderer(new ImageListCellRenderer());
        }
        scrollpane = new JScrollPane(targyLista);
        scrollpane.setPreferredSize(new Dimension(90, 400));

        try {
            BufferedImage buttonIcon = ImageIO.read(new File("resources/move.png"));
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

        /**
         * Timer objektum, amely időzített eseményeket kezel a UserPanel frissítéséhez.
         * A Timer minden 400 milliszekundumban ellenőrzi a kiválasztott tárgyakat és a felhasználó állapotát,
         * majd ennek megfelelően engedélyezi vagy letiltja a gombokat.
         */
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

        /**
         * A gomb, amely lehetővé teszi a kiválasztott tárgy használatát.
         * Ha a tárgy hamis funkcióval rendelkezik, akkor egy figyelmeztető párbeszédablakot jelenít meg.
         * A tárgy használata után frissíti a felhasználói felületet.
         */
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

    /**
     * Frissíti a felhasználói felületet a megadott HallgatoViewModel alapján.
     * Beállítja a tárgylistát a hallgató táskájában lévő tárgyak képeivel és frissíti a listát.
     *
     * @param hVM a HallgatoViewModel objektum, amely a felhasználó aktuális állapotát tartalmazza
     */
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

    /**
     * ListCellRenderer osztály, amely képeket jelenít meg a JList elemeiként.
     */
    private class ImageListCellRenderer extends JLabel implements ListCellRenderer<ImageIcon> {
        /**
         * Az ImageListCellRenderer konstruktora, amely beállítja az alapértelmezett igazításokat és átlátszóságot.
         */
        public ImageListCellRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        /**
         * Az egyes listaelemek megjelenítéséért felelős komponens létrehozása.
         * Beállítja az ikon képét, valamint a háttér- és előtérszíneket a kiválasztás állapotától függően.
         *
         * @param list a JList, amelynek egy elemét meg kell jeleníteni
         * @param value az aktuális listaelem értéke, ebben az esetben egy ImageIcon
         * @param index az aktuális listaelem indexe
         * @param isSelected igaz, ha az aktuális listaelem ki van választva
         * @param cellHasFocus igaz, ha az aktuális listaelem fókuszban van
         * @return a komponens, amely megjeleníti a listaelemet
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

    /**
     * Figyelmeztető párbeszédablak megjelenítése, amely jelzi, hogy a kiválasztott tárgy hamis.
     */
    private void showFakeItemDialog(){
        JOptionPane.showMessageDialog(this, "A targy hamis, ezt jól be****");
    }
}
