package cours.sip.solution;
import java.util.Scanner;

import cours.sip.solution.impl.CarreServiceImpl;
import cours.sip.solution.impl.CercleServiceImpl;
import cours.sip.solution.impl.RectangleServiceImpl;

public class App {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int choix;
      
        do {
            System.out.println("1-Saisir un carre");
            System.out.println("2-Saisir un Rectangle"); 
            System.out.println("3-Saisir un Cercle"); 
            System.out.println("4-Quitter"); 
            System.out.println("Veuillez faire un choix:");
            choix =scanner.nextInt();
            switch (choix) {
                case 1:
                   CarreRectangleService figure=new CarreServiceImpl();
                   System.out.println("Entrer le cote du carre");
                   CarreServiceImpl carreService=(CarreServiceImpl)figure;
                   carreService.setCote(scanner.nextDouble());
                   figure.surface();
                    break;
                case 2:
                   figure=new CarreServiceImpl();
                   System.out.println("Entrer La Longeur du Rectangle");
                   RectangleServiceImpl rectangleService=(RectangleServiceImpl)figure;
                   rectangleService.setLongeur(scanner.nextDouble());
                  System.out.println("Entrer la Largeur du Rectangle");
                  rectangleService.setLargeur(scanner.nextDouble());
                  figure.surface();
                    break;
                case 3:
                    CercleService cercleService=new CercleServiceImpl();
                     System.out.println("Entrer Le Rayon du  Cercle");
                     CercleServiceImpl cercleServiceImpl =(CercleServiceImpl)cercleService;
                     cercleServiceImpl.setRayon(scanner.nextDouble());
                     cercleService.surface();
                       break;
                default:
                    break;
            }
        } while (choix!=4);
         scanner.close(); 
    }
    
}
