package cours.srp.cas1.solution.services;

import cours.srp.cas1.solution.entity.Livre;

public interface LivreService {
    public void ajouterLivre(Livre livre);
    public Livre rechercherLivreParId(int livreId);
}
