package taf.cas2.solution.repository;

import taf.cas2.solution.Produit;
import java.util.ArrayList;
import java.util.List;

public class MemoryProduitRepository implements ProduitRepository {
    private final List<Produit> produits = new ArrayList<>();

    @Override
    public void insert(Produit produit) {
        produits.add(produit);
    }

    @Override
    public List<Produit> findAll() {
        return new ArrayList<>(produits);
    }
}
