package cours.sip.probleme;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int choix;
        Figure figure;
        do {
            System.out.println("1-Saisir un carre");
            System.out.println("2-Saisir un Rectangle"); 
            System.out.println("3-Saisir un Cercle"); 
            System.out.println("4-Quitter"); 
            System.out.println("Veuillez faire un choix:");
            choix =scanner.nextInt();
            switch (choix) {
                case 1:
                   figure=new CarreService();
                   System.out.println("Entrer le cote du carre");
                   CarreService carreService=(CarreService)figure;
                   carreService.setCote(scanner.nextDouble());
                   figure.surface();
                    break;
                case 2:
                 figure=new RectangleService();
                 System.out.println("Entrer La Longeur du Rectangle");
                 RectangleService rectangleService=(RectangleService)figure;
                 rectangleService.setLongeur(scanner.nextDouble());
                 System.out.println("Entrer la Largeur du Rectangle");
                 rectangleService.setLargeur(scanner.nextDouble());
                 figure.surface();
                    break;
                case 3:
                     figure=new CercleService();
                     System.out.println("Entrer Le Rayon du  Cercle");
                     CercleService cercleService =(CercleService)figure;
                     cercleService.setRayon(scanner.nextDouble());
                     figure.surface();
                       break;
                default:
                    break;
            }
        } while (choix!=4);
         scanner.close(); 
    }
    
}
