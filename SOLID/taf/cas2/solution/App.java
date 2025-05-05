package taf.cas2.solution;

import taf.cas2.solution.service.ProduitService;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProduitService service = new ProduitService(DataSource.FILE);

        // Exemple d'utilisation
        Produit p1 = new Produit("Ordinateur", 1500);
        Produit p2 = new Produit("Téléphone", 800);

        service.ajouterProduit(p1);
        service.ajouterProduit(p2);

        List<Produit> produits = service.obtenirTousLesProduits();
        produits.forEach(System.out::println);
    }
}