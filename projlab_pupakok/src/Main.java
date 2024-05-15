import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Game.Game;
import Proto.Proto;
import Views.HomeFrame;

public class Main {
    public static void main(String[] args) {
        HomeFrame test = new HomeFrame();
        InputStreamReader str = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(str);
        String val = "";
        System.out.println("1: Játék indítása");
        System.out.println("2: Tesztek indítása");
        System.out.println("3: Kilépés");
        try {
            val = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!"3".equals(val)) {
            Proto p = new Proto();
            Game g = new Game();
            switch (val) {
                case "1":
                    g.start();
                    break;
                case "2":
                    p.start();
                    break;
                default:
                    System.out.println("Rossz bemenet");
                    break;
            }
            System.out.flush();
            System.out.println("1: Játék indítása");
            System.out.println("2: Tesztek indítása");
            System.out.println("3: Kilépés");
            try {
                val = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}