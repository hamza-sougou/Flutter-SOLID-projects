package taf.cas3.probleme;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
         List<Produit> produits =Arrays.asList(new Produit("Lait",1000),new Produit("Sucre",700));
         Facture facture =new Facture(produits);
         facture.calculerTotal();
         facture.imprimerFacture();
       
         try {
            facture.sauvegarderFichier("data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
