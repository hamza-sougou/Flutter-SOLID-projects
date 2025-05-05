package taf.cas2.solution.repository;

import taf.cas2.solution.Produit;
import java.util.List;

public interface ProduitRepository {
    void insert(Produit produit);
    List<Produit> findAll();
}
