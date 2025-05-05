package taf.cas3.solution.domain;

import java.util.List;

public class Facture {
    private final List<Produit> produits;
    private final double total;

    public Facture(List<Produit> produits, double total) {
        this.produits = produits;
        this.total = total;
    }

    public List<Produit> getProduits() {
        return List.copyOf(produits);
    }

    public double getTotal() {
        return total;
    }
}
