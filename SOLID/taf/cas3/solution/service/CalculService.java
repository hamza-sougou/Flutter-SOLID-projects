package taf.cas3.solution.service;

import taf.cas3.solution.domain.Facture;
import taf.cas3.solution.domain.Produit;
import java.util.List;

public class CalculService {
    public Facture creerFacture(List<Produit> produits) {
        double total = produits.stream()
            .mapToDouble(Produit::getPrix)
            .sum();
        return new Facture(produits, total);
    }
}
