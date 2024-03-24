import java.util.Scanner;

public class Main {

    /**
     * Hallgató felveszi a rongyot a földről.
     */
    public static void test34(){
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Rongy rongy = new Rongy(szoba, h, Funkcio.oktatotol_ved);
        h.felvesz(rongy);
    }
    /**
     * Hallgató felveszi a maszkot a földről.
     */
    public static void test35(){
        Szoba szoba = new Szoba(false, 10);
        Hallgato h = new Hallgato(szoba);
        Maszk maszk = new Maszk(szoba, h, Funkcio.gaztol_ved);
        h.felvesz(maszk);
    }

    /**
     * Oktató felveszi a camembert a földről.
     */
    public static void test44(){
        Szoba szoba = new Szoba(false, 10);
        Oktato h = new Oktato(szoba);
        Camembert camembert = new Camembert(szoba, h, Funkcio.gaztol_ved);
        h.felvesz(camembert);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int szam;

        while((szam = scanner.nextInt()) != 100){
            switch (szam) {
                case 0:
                    
                    break;
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                    
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
                case 10:
                    
                    break;
                case 11:
                    
                    break;
                case 12:
                    
                    break;
                case 13:
                    
                    break;
                case 14:
                    
                    break;
                case 15:
                    
                    break;
                case 16:
                    
                    break;
                case 17:
                    
                    break;
                case 18:
                    
                    break;
                case 19:
                    
                    break;
                    
                //TODO

                case 34:
                    test34();
                 break;
                case 35:
                    test35();
                break;


                case 44:
                    test44();
                break;


                
                default:
                    break;
            }
        }

    }
}