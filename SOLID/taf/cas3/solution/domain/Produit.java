package taf.cas3.solution.domain;

public class Produit {
    private final String nom;
    private final double prix;

    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }
}
