package taf.cas3.probleme;

import java.io.*;
import java.util.List;

public class Facture {
    private List<Produit> produits;
    private double total;
    
    public Facture(List<Produit> produits) {
        this.produits = produits;
    }
    
    public void calculerTotal() {
        total = produits.stream().mapToDouble(p -> p.getPrix()).sum();
        System.out.println("Total Facture "+total);
    }
    
    public void imprimerFacture() {
        System.out.println("===== FACTURE =====");
        produits.forEach(p -> 
            System.out.println(p.getNom() + " - " + p.getPrix() + "€"));
        System.out.println("Total: " + total + "€");
    }
    
    public void sauvegarderFichier(String nomFichier) throws IOException {
        try (PrintWriter writer = new PrintWriter(new File(nomFichier))) {
            writer.println("===== FACTURE =====");
            produits.forEach(p -> 
                writer.println(p.getNom() + " - " + p.getPrix() + "€"));
            writer.println("Total: " + total + "€");
        }
    }
}