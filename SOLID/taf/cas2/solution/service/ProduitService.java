package taf.cas2.solution.service;

import taf.cas2.solution.Produit;
import taf.cas2.solution.DataSource;
import taf.cas2.solution.repository.ProduitRepository;
import taf.cas2.solution.repository.FileProduitRepository;
import taf.cas2.solution.repository.MemoryProduitRepository;

import java.util.List;

public class ProduitService {
    private final ProduitRepository repository;

    public ProduitService(DataSource dataSource) {
        this.repository = dataSource == DataSource.FILE 
            ? new FileProduitRepository() 
            : new MemoryProduitRepository();
    }

    public void ajouterProduit(Produit produit) {
        repository.insert(produit);
    }

    public List<Produit> obtenirTousLesProduits() {
        return repository.findAll();
    }
}
