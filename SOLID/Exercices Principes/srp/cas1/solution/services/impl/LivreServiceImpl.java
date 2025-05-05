package cours.srp.cas1.solution.services.impl;

import java.util.List;

import cours.srp.cas1.solution.entity.Livre;
import cours.srp.cas1.solution.repository.LivreRepository;
import cours.srp.cas1.solution.services.LivreService;

public class LivreServiceImpl implements LivreService {
    private List<Livre> livres;
    //Dependances
     private LivreRepository livreRepository;
   
     public LivreServiceImpl(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }
     // Gestion des livres
     @Override
     public void ajouterLivre(Livre livre) {
        livres.add(livre);
        livreRepository.sauvegarderDansBaseDeDonnees(livre);
    }
   @Override
    public Livre rechercherLivreParId(int livreId){
        return livreRepository.rechercherByIdDansBaseDeDonnees(livreId);
    }
    
}
