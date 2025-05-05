package taf.cas3.solution.service;

import taf.cas3.solution.domain.Facture;
import taf.cas3.solution.repository.FactureRepository;
import java.io.IOException;

public class FileService {
    private final FactureRepository repository;

    public FileService(FactureRepository repository) {
        this.repository = repository;
    }

    public void sauvegarderFacture(Facture facture, String nomFichier) throws IOException {
        repository.sauvegarder(facture, nomFichier);
    }
}
