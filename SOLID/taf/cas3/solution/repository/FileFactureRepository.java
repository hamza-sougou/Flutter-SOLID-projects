package taf.cas3.solution.repository;

import taf.cas3.solution.domain.Facture;
import java.io.*;

public class FileFactureRepository implements FactureRepository {
    @Override
    public void sauvegarder(Facture facture, String nomFichier) throws IOException {
        try (PrintWriter writer = new PrintWriter(new File(nomFichier))) {
            writer.println("===== FACTURE =====");
            facture.getProduits().forEach(p ->
                writer.println(p.getNom() + " - " + p.getPrix() + "€")
            );
            writer.println("Total: " + facture.getTotal() + "€");
        }
    }
}
