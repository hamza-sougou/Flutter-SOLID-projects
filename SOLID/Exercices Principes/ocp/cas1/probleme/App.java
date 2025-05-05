package cours.ocp.cas1.probleme;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int choix;
        FigureService figure;
        do {
            System.out.println("1-Saisir un carre");
            System.out.println("2-Saisir un Rectangle"); 
            System.out.println("3-Saisir un Cercle"); 
            System.out.println("4-Quitter"); 
            System.out.println("Veuillez faire un choix:");
            choix =scanner.nextInt();
            switch (choix) {
                case 1:
                   figure=new FigureService(TypeFigure.Carre);
                   System.out.println("Entrer le cote du carre");
                   figure.setCote(scanner.nextDouble());
                   figure.surface();
                    break;
                case 2:
                 figure=new FigureService(TypeFigure.Rectangle);
                 System.out.println("Entrer La Longeur du Rectangle");
                 figure.setLongeur(scanner.nextDouble());
                 System.out.println("Entrer la Largeur du Rectangle");
                 figure.setLargeur(scanner.nextDouble());
                 figure.surface();
                    break;
                    case 3:
                     figure=new FigureService(TypeFigure.Cercle);
                     System.out.println("Entrer Le Rayon du  Cercle");
                     figure.setRayon(scanner.nextDouble());
                     figure.surface();
                       break;
                default:
                    break;
            }
        } while (choix!=4);
         scanner.close(); 
    }
    
}
