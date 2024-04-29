package Proto;

import Palya.Palya;
import Szoba.*;
import Karakter.*;
import Targy.*;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Proto {

    /**
     * Beolvassa egy szövegfájlból a tesztesetet és visszaadja az atomi parancsok
     * kimenetét egy listában.
     * 
     * @param fajlnev
     * @return
     */
    public ArrayList<String> load(String fajlnev) {
        Palya palya = new Palya();
        ArrayList<String> output = new ArrayList<String>();
        File f = new File("projlab_pupakok/src/Data/" + fajlnev + ".txt");
        File file = new File(f.getAbsolutePath());
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            int linenum = 0;
            while ((line = br.readLine()) != null) {
                linenum++;
                String[] str = line.split(";");
                if (str[0].equals("add_character")) {
                    String s = add_character(palya, str[1], str[2], str[3]);
                    output.add(s);
                } else if (str[0].equals("move")) {
                    String s = move(palya, str[1], str[2]);
                    output.add(s);
                } else if (str[0].equals("spawn_item")) {
                    String s = spawn_item(palya, str[1], str[2], str[3]);
                    output.add(s);
                } else if (str[0].equals("pick")) {
                    String s = pick(palya, str[1], str[2]);
                    output.add(s);
                } else if (str[0].equals("throw_item")) {
                    String s = throw_item(palya, str[1], str[2]);
                    output.add(s);
                } else if (str[0].equals("use")) {
                    String s = use(palya, str[1], str[2]);
                    output.add(s);
                } else if (str[0].equals("create_room")) {
                    String s = create_room(palya, str[1], str[2], str[3], str[4]);
                    output.add(s);
                } else if (str[0].equals("merge")) {
                    String s = merge(palya, str[1], str[2]);
                    output.add(s);
                } else if (str[0].equals("split")) {
                    String s = split(palya, str[1]);
                    output.add(s);
                } else if (str[0].equals("connect")) {
                    String s = connect(palya, str[1], str[2]);
                    output.add(s);
                } else if (str[0].equals("general")) {
                    String s = general();
                    output.add(s);
                } else if (str[0].equals("leptet")) {
                    String s = leptet();
                    output.add(s);
                } else {
                    String s = "Hiba az " + linenum + ". sorban.";
                    output.add(s);
                }
            }
            br.close();
        } catch (Exception e) {
            System.err.println("EZ KUTYAFASZLETT");
            // TODO ha kész lesz minden
        }

        return output;
    }

    public String add_character(Palya palya, String s1, String s2, String s3) {
        switch (s1) {
            case "hallgato":
                for (Szoba szoba1 : palya.getSzobak()) {
                    if (szoba1.getid().equals(s3)) {
                        Hallgato hallgato = new Hallgato(szoba1, s2);
                        palya.addHallgato(hallgato);
                        if (hallgato.getSzoba().getid().equals(s3))
                            return "Karakter sikeresen hozzáadva.";
                        else
                            return "Karakter hozzáadása sikertelen.";
                    }
                }
                break;
            case "oktato":
                for (Szoba szoba1 : palya.getSzobak()) {
                    if (szoba1.getid().equals(s3)) {
                        Oktato oktato = new Oktato(szoba1, s2);
                        palya.addOktato(oktato);
                        if (oktato.getSzoba().getid().equals(s3)) {

                            return "Karakter sikeresen hozzáadva.";
                        } else {

                            return "Karakter hozzáadása sikertelen.";
                        }

                    }
                }
                break;
            case "takarito":
                for (Szoba szoba1 : palya.getSzobak()) {
                    if (szoba1.getid().equals(s3)) {
                        Takarito takarito = new Takarito(szoba1, s2);
                        palya.getTakaritok().add(takarito);
                        if (takarito.getSzoba().getid().equals(s3))
                            return "Karakter sikeresen hozzáadva.";
                        else
                            return "Karakter hozzáadása sikertelen.";
                    }
                }
                break;
            default:
                return "Karakter hozzáadása sikertelen.";
        }
        return "Karakter hozzáadása sikertelen.";
    }

    public String move(Palya palya, String s1, String s2) {
        for (Szoba szoba1 : palya.getSzobak()) {
            if (szoba1.getid().equals(s2)) {
                for (Hallgato hallgato : palya.getHallgatok()) {
                    if (hallgato.getid().equals(s1)) {
                        hallgato.mozog(szoba1);
                        if (szoba1.getHallgatok().contains(hallgato))
                            return "Karakter mozgása sikeres.";
                        else
                            return "Karakter mozgása sikertelen.";
                    }
                }
                for (Oktato oktato : palya.getOktatok()) {
                    if (oktato.getid().equals(s1)) {
                        oktato.mozog(szoba1);
                        if (szoba1.getOktatok().contains(oktato))
                            return "Karakter mozgása sikeres.";
                        else
                            return "Karakter mozgása sikertelen.";
                    }
                }
                for (Takarito takarito : palya.getTakaritok()) {
                    if (takarito.getid().equals(s1)) {
                        takarito.mozog(szoba1);
                        if (szoba1.getTakaritok().contains(takarito) && szoba1.getTakaritok().size() == 1 && szoba1.getHallgatok().size() == 0 && szoba1.getOktatok().size() == 0 && szoba1.isRagacsos() == false && szoba1.isGazos() == false)
                            return "Karakter mozgása sikeres.";
                        else
                            return "Karakter mozgása sikertelen.";
                    }
                }
            }
        }
        return "Karakter mozgása sikertelen.";
    }

    public String spawn_item(Palya palya, String s1, String s2, String s3) {
        switch (s1) {
            case "camembert":
                for (Szoba szoba1 : palya.getSzobak()) {
                    if (szoba1.getid().equals(s3)) {
                        Camembert camembert = new Camembert(szoba1, s2);
                        camembert.setFunkcio(Funkcio.aktiv);
                        szoba1.targy_elhelyezese(camembert);
                        if (szoba1.getTargyak().contains(camembert))
                            return "Tárgy hozzáadása sikeres.";
                        else
                            return "Tárgy hozzáadása sikertelen.";
                    }
                }
                break;
            case "legfrissito":
                for (Szoba szoba1 : palya.getSzobak()) {
                    if (szoba1.getid().equals(s3)) {
                        Legfrissito legfrissito = new Legfrissito(szoba1, s2);
                        legfrissito.setFunkcio(Funkcio.aktiv);
                        szoba1.targy_elhelyezese(legfrissito);
                        if (szoba1.getTargyak().contains(legfrissito))
                            return "Tárgy hozzáadása sikeres.";
                        else
                            return "Tárgy hozzáadása sikertelen.";
                    }
                }
                break;
            case "tranzisztor":
                for (Szoba szoba1 : palya.getSzobak()) {
                    if (szoba1.getid().equals(s3)) {
                        Tranzisztor tranzisztor = new Tranzisztor(szoba1, s2);
                        tranzisztor.setFunkcio(Funkcio.aktiv);
                        szoba1.targy_elhelyezese(tranzisztor);
                        if (szoba1.getTargyak().contains(tranzisztor))
                            return "Tárgy hozzáadása sikeres.";
                        else
                            return "Tárgy hozzáadása sikertelen.";
                    }
                }
                break;
            case "rongy":
                for (Szoba szoba1 : palya.getSzobak()) {
                    if (szoba1.getid().equals(s3)) {
                        Rongy rongy = new Rongy(szoba1, s2);
                        rongy.setFunkcio(Funkcio.oktatotol_ved);
                        szoba1.targy_elhelyezese(rongy);
                        if (szoba1.getTargyak().contains(rongy))
                            return "Tárgy hozzáadása sikeres.";
                        else
                            return "Tárgy hozzáadása sikertelen.";
                    }
                }
                break;
            case "sorospohar":
                for (Szoba szoba1 : palya.getSzobak()) {
                    if (szoba1.getid().equals(s3)) {
                        Sorospohar sorospohar = new Sorospohar(szoba1, s2);
                        sorospohar.setFunkcio(Funkcio.oktatotol_ved);
                        szoba1.targy_elhelyezese(sorospohar);
                        if (szoba1.getTargyak().contains(sorospohar))
                            return "Tárgy hozzáadása sikeres.";
                        else
                            return "Tárgy hozzáadása sikertelen.";
                    }
                }
                break;
            case "tvsz":
                for (Szoba szoba1 : palya.getSzobak()) {
                    if (szoba1.getid().equals(s3)) {
                        TVSZ tvsz = new TVSZ(szoba1, s2);
                        tvsz.setFunkcio(Funkcio.oktatotol_ved);
                        szoba1.targy_elhelyezese(tvsz);
                        if (szoba1.getTargyak().contains(tvsz))
                            return "Tárgy hozzáadása sikeres.";
                        else
                            return "Tárgy hozzáadása sikertelen.";
                    }
                }
                break;
            case "maszk":
                for (Szoba szoba1 : palya.getSzobak()) {
                    if (szoba1.getid().equals(s3)) {
                        Maszk maszk = new Maszk(szoba1, s2);
                        maszk.setFunkcio(Funkcio.gaztol_ved);
                        if (szoba1.getTargyak().contains(maszk))
                            return "Tárgy hozzáadása sikeres.";
                        else
                            return "Tárgy hozzáadása sikertelen.";
                    }
                }
                break;
            default:
                return "Tárgy hozzáadása sikertelen.";
        }
        return "Tárgy hozzáadása sikertelen.";
    }

    public String pick(Palya palya, String s1, String s2) {
        for (Hallgato hallgato : palya.getHallgatok()) {
            if (hallgato.getid().equals(s1)) {
                for (int i = 0; i < hallgato.getSzoba().getTargyak().size(); i++) {
                    if (hallgato.getSzoba().getTargyak().get(i).getId().equals(s2)) {
                        Targy t = hallgato.getSzoba().getTargyak().get(i);
                        hallgato.felvesz(t);
                        if (hallgato.getTaska().contains(t))
                            return "Tárgy felvétele sikeres.";
                        else
                            return "Tárgy felvétele sikertelen.";
                    }
                }
            }
        }
        for (Oktato oktato : palya.getOktatok()) {
            if (oktato.getid().equals(s1)) {
                for (int i = 0; i < oktato.getSzoba().getTargyak().size(); i++) {
                    if (oktato.getSzoba().getTargyak().get(i).getId().equals(s2)) {
                        Targy t = oktato.getSzoba().getTargyak().get(i);
                        oktato.felvesz(t);
                        if (oktato.getTaska().contains(t))
                            return "Tárgy felvétele sikeres.";
                        else
                            return "Tárgy felvétele sikertelen.";
                    }
                }
            }
        }
        return "Tárgy felvétele sikertelen.";
    }

    public String throw_item(Palya palya, String s1, String s2) {
        for (Hallgato hallgato : palya.getHallgatok()) {
            if (hallgato.getid().equals(s1)) {
                for (int i = 0; i < hallgato.getTaska().size(); i++) {
                    if (hallgato.getTaska().get(i).getId().equals(s2)) {
                        Targy t = hallgato.getTaska().get(i);
                        hallgato.eldob(t);
                        if (!(hallgato.getTaska().contains(t)))
                            return "Tárgy sikeresen eltűnt.";
                        else
                            return "Tárgy eltűntetése sikertelen.";
                    }
                }
            }
        }
        return "Tárgy eltűntetése sikertelen.";
    }

    public String use(Palya palya, String s1, String s2) {
        for (Hallgato hallgato : palya.getHallgatok()) {
            if (hallgato.getid().equals(s1)) {
                for (int i = 0; i < hallgato.getTaska().size(); i++) {
                    if (hallgato.getTaska().get(i).getId().equals(s2)) {
                        Targy t = hallgato.getTaska().get(i);
                        t.use();
                        if ((t instanceof Camembert)) {
                            if (t.getSzoba().isGazos())
                                return "Tárgy használata sikeres.";
                            else
                                return "Tárgy használata sikertelen.";
                        }
                        if ((t instanceof Legfrissito)) {
                            if (!(t.getSzoba().isGazos()))
                                return "Tárgy használata sikeres.";
                            else
                                return "Tárgy használata sikertelen.";
                        }
                        if ((t instanceof Tranzisztor)) {
                            if (t.getSzoba().getTargyak().contains(t) && ((Tranzisztor) t).getAktiv()
                                    || hallgato.getSzoba() == ((Tranzisztor) t).getTars().getSzoba())
                                return "Tárgy használata sikeres.";
                            else
                                return "Tárgy használata sikertelen.";
                        }
                    }
                }
            }
        }
        return "A tárgy használata sikertelen.";
    }

    private String connect(Palya palya, String string, String string2) {
        for (Szoba Szoba1 : palya.getSzobak()) {
            if (Szoba1.getid().equals(string)) {
                for (Szoba Szoba2 : palya.getSzobak()) {
                    if (Szoba2.getid().equals(string2)) {
                        Szoba1.addSzomszed(Szoba2);
                    }
                }
            }
        }

        for (Szoba Szoba1 : palya.getSzobak()) {
            if (Szoba1.getid().equals(string)) {
                for (Szoba Szobaszomszed : Szoba1.getSzomszedok()) {
                    if (Szobaszomszed.getid().equals(string2)) {
                        return "Szobák összekapcsolása sikeres.";
                    }
                }
            }
        }
        return "Szobák összekapcsolása sikertelen.";

    }

    private String split(Palya palya, String string) {
        boolean siker = false;
        for (int i = 0; i < palya.getSzobak().size(); i++) {
            Szoba Szoba = palya.getSzobak().get(i);
            if (Szoba.getid().equals(string)) {
                siker = Szoba.osztodik();
                break; // Ha megtaláltuk a megfelelő szobát, kilépünk a ciklusból
            }
        }

        if (siker) {
            return "Osztódás sikeres.";
        } else {
            return "Osztódás sikertelen.";

        }

    }

    private String merge(Palya palya, String string, String string2) {
        for (int j = 0; j < palya.getSzobak().size(); j++) {
            Szoba Szoba1 = palya.getSzobak().get(j);
            if (Szoba1.getid().equals(string)) {
                for (int i = 0; i < palya.getSzobak().size(); i++) {
                    Szoba Szoba2 = palya.getSzobak().get(i);
                    if (Szoba2.getid().equals(string2)) {
                        Szoba1.egyesul(Szoba2);
                        // Ha megtaláltuk a megfelelő szobát, kiléphetünk a ciklusból

                    }
                }
            }
        }
        for (Szoba Szoba1 : palya.getSzobak()) {
            if (Szoba1.getid().equals(string)) {
                for (Szoba Szobaregi : Szoba1.getRegiszobak()) {
                    if (Szobaregi.getid().equals(string2)) {
                        return "Egyesülés sikeres.";
                    }
                }
            }
        }
        return "Egyesülés sikertelen.";

    }

    private String create_room(Palya palya, String string, String string2, String string3, String string4) {
        String c = string;
        int b = Integer.parseInt(string2);
        boolean a = Boolean.parseBoolean(string3);
        String ret = "Szoba hozzáadása sikertelen.";
        if ("0".equals(string4)) {
            Szoba sz = new Szoba(c, a, b, palya);
        } else {
            ElatkozottSzoba sz2 = new ElatkozottSzoba(c, a, b, palya);
        }

        for (Szoba szoba : palya.getSzobak()) {
            if (szoba.getid() == c && szoba.getBefogadokepesseg() == b && szoba.isGazos() == a) {

                if ((szoba instanceof ElatkozottSzoba) && "1".equals(string4)) {
                    ret = "Szoba hozzáadása sikeres.";
                } else if (!(szoba instanceof ElatkozottSzoba) && "0".equals(string4)) {
                    ret = "Szoba hozzáadása sikeres.";
                }
            }
        }
        return ret;
    }

    private String general() {
        Palya palya = new Palya();
        palya.setToggle_random(false);
        palya.general();
        if (palya.getSzobak().size() == 43 && palya.getHallgatok().size() == 1 && palya.getOktatok().size() == 1) {
            return "Pálya generálása sikeres";
        }
        return "Pálya generálása sikertelen";
    }

    private String leptet() {
        Palya palya = new Palya();
        palya.setToggle_random(false);
        palya.general();
        palya.leptet();
        if (palya.getOktatok().get(0).getSzoba().getSzomszedok().get(0).getid().equals("42")
                && palya.getTakaritok().get(0).getSzoba().getSzomszedok().get(0).getid().equals("24"))
            return "A léptetés sikeres";
        return "A léptetés sikertelen";
    }

    /**
     * A load függvény által visszaadott teszt kimenetet veti össze az elvárt
     * kimenettel, ha a kettő
     * megegyezik a visszatérési érték igaz.
     * 
     * @param output
     * @param fajlnev
     * @return
     */
    String checkoutput(String bemeneti, String elvart) {
        ArrayList<String> output = load(bemeneti);
        File f = new File("projlab_pupakok/src/Data/" + elvart + ".txt");
        File file = new File(f.getAbsolutePath());
        ArrayList<String> elvartfajl = new ArrayList<String>();
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                elvartfajl.add(line);
            }
            br.close();
        } catch (Exception e) {
        }
        String sikeres = "A teszt sikeres volt.";
        String sikertelen = "A teszt sikertelen volt.";
        if (elvartfajl.size() != output.size()) {
            return sikertelen;
        }
        for (int i = 0; i < elvartfajl.size(); ++i) {
            if (!elvartfajl.get(i).equals(output.get(i))) {
                return sikertelen;
            }
        }
        return sikeres;
    }

    /**
     * Egy szövegfájlból beolvassa a prototípus menüjét.
     * 
     * @return a beolvasott szövegfájl
     */
    private ArrayList<String> readMenu() {
        File f = new File("projlab_pupakok/src/Data/ProtoTestMenu.txt");
        File file = new File(f.getAbsolutePath());
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                // process the line
                lines.add(line);
            }
            br.close();
        } catch (Exception e) {
        }
        return lines;
    }

    /**
     * A beolvasott menüt írja ki a szabványos kimenetre.
     * 
     * @param lines
     */
    private void printMenu(ArrayList<String> lines) {
        for (String string : lines) {
            System.out.println(string);
        }
    }

    /**
     * A prototípus menüjét állítja elő.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int szam;
        ArrayList<String> lines = readMenu();
        printMenu(lines);
        while ((szam = scanner.nextInt()) != 100) {
            System.out.flush();
            switch (szam) {
                case 100:
                    scanner.close();
                    return;
                case 1000: /// Minden teszt futtatása.
                    boolean siker = true;
                    int counter = 0;
                    for (int i = 1; i <= 28; ++i) {
                        String kimenet = checkoutput("input" + i, "output" + i);
                        if (!kimenet.equals("A teszt sikeres volt.")) {
                            siker = false;
                            System.out.println(i + ". teszt sikertelen.");
                        } else {
                            counter++;
                        }
                    }
                    if (siker) {
                        System.out.println("Minden teszt sikeres volt. " + counter + "/28");
                    } else {
                        System.out.println("Nem minden teszt sikeres. " + counter + "/28");
                    }
                    break;
                case 1: /// 1-es teszt futtatása.
                    System.out.println(checkoutput("input1", "output1"));
                    break;
                case 2:
                    System.out.println(checkoutput("input2", "output2"));
                    break;
                case 3:
                    System.out.println(checkoutput("input3", "output3"));
                    break;
                case 4:
                    System.out.println(checkoutput("input4", "output4"));
                    break;
                case 5:
                    System.out.println(checkoutput("input5", "output5"));
                    break;
                case 6:
                    System.out.println(checkoutput("input6", "output6"));
                    break;
                case 7:
                    System.out.println(checkoutput("input7", "output7"));
                    break;
                case 8:
                    System.out.println(checkoutput("input8", "output8"));
                    break;
                case 9:
                    System.out.println(checkoutput("input9", "output9"));
                    break;
                case 10:
                    System.out.println(checkoutput("input10", "output10"));
                    break;
                case 11:
                    System.out.println(checkoutput("input11", "output11"));
                    break;
                case 12:
                    System.out.println(checkoutput("input12", "output12"));
                    break;
                case 13:
                    System.out.println(checkoutput("input13", "output13"));
                    break;
                case 14:
                    System.out.println(checkoutput("input14", "output14"));
                    break;
                case 15:
                    System.out.println(checkoutput("input15", "output15"));
                    break;
                case 16:
                    System.out.println(checkoutput("input16", "output16"));
                    break;
                case 17:
                    System.out.println(checkoutput("input17", "output17"));
                    break;
                case 18:
                    System.out.println(checkoutput("input18", "output18"));
                    break;
                case 19:
                    System.out.println(checkoutput("input19", "output19"));
                    break;
                case 20:
                    System.out.println(checkoutput("input20", "output20"));
                    break;
                case 21:
                    System.out.println(checkoutput("input21", "output21"));
                    break;
                case 22:
                    System.out.println(checkoutput("input22", "output22"));
                    break;
                case 23:
                    System.out.println(checkoutput("input23", "output23"));
                    break;
                case 24:
                    System.out.println(checkoutput("input24", "output24"));
                    break;
                case 25:
                    System.out.println(checkoutput("input25", "output25"));
                    break;
                case 26:
                    System.out.println(checkoutput("input26", "output26"));
                    break;
                case 27:
                    System.out.println(checkoutput("input27", "output27"));
                    break;
                case 28:
                    System.out.println(checkoutput("input28", "output28"));
                    break;
                case 29:
                    System.out.println(checkoutput("input29", "output29"));
                    break;
                case 30:
                    System.out.println(checkoutput("input30", "output30"));
                    break;
                case 31:
                    System.out.println(checkoutput("input31", "output31"));
                    break;
                case 32:
                    System.out.println(checkoutput("input32", "output32"));
                    break;
                
                // TODO hamis
                // TODO tranzisztor
                // TODO logarlec
                default:
                    System.out.println("Csak a menüben megadott számokat addj meg.");
                    break;
            }
        }
    }
}
