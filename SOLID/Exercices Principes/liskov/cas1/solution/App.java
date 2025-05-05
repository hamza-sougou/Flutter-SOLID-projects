package cours.liskov.cas1.solution;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int choix;
         //Objet de la classe mere ou classe de Base 
          Figure figure;
        do {
            System.out.println("1-Saisir un carre");
            System.out.println("2-Saisir un Rectangle"); 
            System.out.println("3-Saisir un Cercle"); 
            System.out.println("4-Quitter"); 
            System.out.println("Veuillez faire un choix:");
            choix =scanner.nextInt();
            switch (choix) {
                /*
                 * Heritage (Une Mere(A) et des Filles(B,C)) ==> Convertir une fille en Mere et Mere en Fille
                 * //Convertir une fille en Mere  B ==> A   C ==>A   ==>Liskov
                 *   Mere mere=new Fille() ==>Liskow  ==> A a =new B();  A a=new C();
                 * //Convertir  Mere en Fille   ==> A==> B  A ==> C     ==> DownCasting
                 *  (Fille)mere ==>DownCasting      A a ;    B b=(B)a;    C c =(C)a;
                 */
                case 1:
                   //Stocke dans figure un objet de type CarreService(Classe Fille ou classe Derivee de Figure)
                   //Convertit un objet de type CarreService en un Objet de type Figure => car  CarreService herite de Figure
                     figure=new CarreService();
                      System.out.println("Entrer le cote du carre");
                   //Convertit un objet de type Figure  en un Objet de type  CarreService ==>downCasting
                     figure=new CarreService();
                     CarreService carreService=(CarreService) figure;
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
                     CercleService cercleService=(CercleService)figure;
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
