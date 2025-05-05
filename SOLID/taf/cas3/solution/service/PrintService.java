package taf.cas3.solution.service;

import taf.cas3.solution.domain.Facture;

public class PrintService {
    public void imprimerFacture(Facture facture) {
        System.out.println("===== FACTURE =====");
        facture.getProduits().forEach(p ->
            System.out.println(p.getNom() + " - " + p.getPrix() + "€")
        );
        System.out.println("Total: " + facture.getTotal() + "€");
    }
}
