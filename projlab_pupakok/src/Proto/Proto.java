package Proto;

import Game.Game;
import Palya.Palya;
import Szoba.*;
import Karakter.*;
import Palya.Palya;
import Targy.*;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Proto {

    /**
     * Beolvassa egy szövegfájlból a tesztesetet és visszaadja az atomi parancsok kimenetét egy listában.
     * @param fajlnev
     * @return
     */
    public ArrayList<String> load(String fajlnev){
        Palya palya = new Palya();
        ArrayList<String> output = new ArrayList<String>();
        File f = new File("src/Data/" + fajlnev);
        File file = new File(f.getAbsolutePath());
        try{
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            int linenum = 0;
            while ((line = br.readLine()) != null) {
                linenum++;
                String[] str = line.split(";");
                if(str[0].equals("add_character")){
                    String s = add_character(palya, str[1], str[2], str[3]);
                    output.add(s);
                } else if(str[0].equals("move")){
                    String s = move(palya, str[1], str[2]);
                    output.add(s);
                }else if(str[0].equals("spawn_item")){
                    String s = spawn_item(palya, str[1], str[2], str[3]);
                    output.add(s);
                }else if (str[0].equals("pick")){
                    String s = pick(palya, str[1], str[2]);
                    output.add(s);
                }else if(str[0].equals("throw")){
                    String s = throw(palya, str[1], str[2]);
                    output.add(s);
                } else if(str[0].equals("use")){
                    String s = use(palya, str[1], str[2]);
                    output.add(s);
                } else if(str[0].equals("create_room")){
                    String s = create_room(palya, str[1], str[2], str[3], str[4]);
                    output.add(s);
                }else if(str[0].equals("merge")){
                    String s = merge(palya, str[1], str[2]);
                    output.add(s);
                } else if(str[0].equals("split")){
                    String s = split(palya, str[1]);
                    output.add(s);
                } else if(str[0].equals("connect")){
                    String s = connect(palya, str[1], str[2]);
                    output.add(s);
                } else{
                    String s = "Hiba az " + linenum + ". sorban.";
                    output.add(s);
                }
            }
            br.close();
        } 
        catch (Exception e) {
        }
        return output;
    }

    private String connect(Palya palya, String string, String string2) {
        for (Szoba Szoba1 : palya.getSzobak()) {
            if(Szoba1.getid() == string){
                for (Szoba Szoba2 : palya.getSzobak()) {
                    if(Szoba2.getid() == string2){
                        Szoba1.addSzomszed(Szoba2);
                    }
                }
            }
        }

        for (Szoba Szoba1 : palya.getSzobak()) {
            if(Szoba1.getid() == string){
                for (Szoba Szobaszomszed : Szoba1.getSzomszedok()) {
                    if(Szobaszomszed.getid()==string2){
                        return "Szobák összekapcsolása sikeres.";
                    }
                }
            }
        }
        return "Szobák összekapcsolása sikertelen.";

    
    }

    private String split(Palya palya, String string) {
        boolean siker;
        for (Szoba Szoba : palya.getSzobak()) {
            if(Szoba.getid() == string){
                siker = Szoba.osztodik();
            }
        }
        
        if(siker){
            return"Osztódás sikeres.";
        }
        else{
            return"Osztódás sikertelen.";

        }
    
    }

    private String merge(Palya palya, String string, String string2) {
        for (Szoba Szoba1 : palya.getSzobak()) {
            if(Szoba1.getid() == string){
                for (Szoba Szoba2 : palya.getSzobak()) {
                    if(Szoba2.getid() == string2){
                        Szoba1.egyesul(Szoba2);
                    }
                }
            }
        }

        for (Szoba Szoba1 : palya.getSzobak()) {
            if(Szoba1.getid() == string){
                for (Szoba Szobaregi : Szoba1.getRegiszobak()) {
                    if(Szobaregi.getid()==string2){
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
        
        if ("0".equals(string4)) {
            Szoba sz = new Szoba(a, b);
            sz.setid(c);
            
        } else {
            ElatkozottSzoba sz2 = new ElatkozottSzoba(a, b);
            sz2.setid(c);
           
        }

        for (Szoba Szoba : Palya.getSzobak()) {
            if(Szoba.getid()==c  && Szoba.getBefogadokepesseg() == b && Szoba.isGazos() == a ){

                if ((Szoba instanceof ElatkozottSzoba) && "1".equals(string4)) {
                    return "Szoba hozzáadása sikeres.";
                } else if (!(Szoba instanceof ElatkozottSzoba) && "0".equals(string4)) {
                    return "Szoba hozzáadása sikeres.";
                }
                return "Szoba hozzáadása sikertelen.";
            }

            }
        }
    }
    

    /**
     * A load függvény által visszaadott teszt kimenetet veti össze az elvárt kimenettel, ha a kettő 
     * megegyezik a visszatérési érték igaz.
     * @param output
     * @param fajlnev
     * @return
     */
    String checkoutput(String bemeneti, String elvart){
        ArrayList<String> output = load(bemeneti);
        File f = new File("src/Data/" + elvart);
        File file = new File(f.getAbsolutePath());
        ArrayList<String> elvartfajl = new ArrayList<String>();
        try{
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                elvartfajl.add(line);
            }
            br.close();
        }
        catch(Exception e){
        }
        String sikeres = "A teszt sikeres volt.";
        String sikertelen = "A teszt sikertelen volt.";
        if(elvartfajl.size() != output.size()){
            return sikertelen;
        }
        for(int i = 0; i < elvartfajl.size(); ++i){
            if(!elvartfajl.get(i).equals(output.get(i))){
                return sikertelen;
            }
        }
        return sikeres;
    }

    /**
     * Egy szövegfájlból beolvassa a prototípus menüjét.
     * @return a beolvasott szövegfájl
     */
    private ArrayList<String> readMenu() {
        File f = new File("src/Data/ProtoTestMenu.txt");
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
                case 1000:  ///Minden teszt futtatása.
                    boolean siker = true;
                    for(int i = 0; i < /*Mennyi teszt lesz???????? */; ++i){
                        String kimenet = checkoutput("input" + i, "output" + i);
                        if(!kimenet.equals("A teszt sikeres volt.")){
                            siker = false;
                        }
                    }
                    if(sikrer){
                        System.out.println("Minden teszt sikeres volt.");
                    } else{
                        System.out.println("Nem minden teszt sikeres.");
                    }
                    break;
                case 1:     ///1-es teszt futtatása.
                    System.out.println(checkoutput("input" + 1, "output" + 1));
                    break;
                case 2:
                    System.out.println(checkoutput("input" + 2, "output" + 2));
                    break;
                case 3:
                    System.out.println(checkoutput("input" + 3, "output" + 3));
                    break;
                case 4:
                    System.out.println(checkoutput("input" + 4, "output" + 4));
                    break;
                case 5:
                    System.out.println(checkoutput("input" + 5, "output" + 5));
                    break;
                
                //TODO

                default:
                    System.out.println("Csak a menüben megadott számokat addj meg.");
                    break;
            }
        }
    }
}
