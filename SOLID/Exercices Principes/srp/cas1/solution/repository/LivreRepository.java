package cours.srp.cas1.solution.repository;

import cours.srp.cas1.solution.entity.Livre;

public interface LivreRepository {
       public void sauvegarderDansBaseDeDonnees(Livre livre);
       public Livre rechercherByIdDansBaseDeDonnees(int livreId);
}