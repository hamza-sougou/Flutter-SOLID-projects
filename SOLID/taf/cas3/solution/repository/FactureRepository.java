package taf.cas3.solution.repository;

import taf.cas3.solution.domain.Facture;
import java.io.IOException;

public interface FactureRepository {
    void sauvegarder(Facture facture, String nomFichier) throws IOException;
}
