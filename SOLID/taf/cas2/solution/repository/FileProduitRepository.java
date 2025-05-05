package taf.cas2.solution.repository;

import taf.cas2.solution.Produit;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProduitRepository implements ProduitRepository {
    private static final String FILENAME = "produits.txt";

    @Override
    public void insert(Produit produit) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            writer.println(produit.toString());
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'écriture dans le fichier", e);
        }
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split(" - ");
                String nom = parts[0];
                double prix = Double.parseDouble(parts[1].replace("CFA", "").trim());
                produits.add(new Produit(nom, prix));
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la lecture du fichier", e);
        }
        return produits;
    }
}
