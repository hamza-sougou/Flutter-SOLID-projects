package taf.cas3.solution;

import taf.cas3.solution.domain.Produit;
import taf.cas3.solution.service.CalculService;
import taf.cas3.solution.service.PrintService;
import taf.cas3.solution.service.FileService;
import taf.cas3.solution.repository.FileFactureRepository;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        List<Produit> produits = Arrays.asList(
            new Produit("Lait", 1000),
            new Produit("Sucre", 700)
        );

        CalculService calculService = new CalculService();
        PrintService printService = new PrintService();
        FileService fileService = new FileService(new FileFactureRepository());

        var facture = calculService.creerFacture(produits);
        printService.imprimerFacture(facture);

        try {
            fileService.sauvegarderFacture(facture, "data.txt");
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde: " + e.getMessage());
        }
    }
}
