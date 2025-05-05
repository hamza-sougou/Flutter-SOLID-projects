package cours.srp.cas1.solution.services.impl;

import java.util.ArrayList;
import java.util.List;

import cours.srp.cas1.solution.entity.Adherent;
import cours.srp.cas1.solution.entity.Emprunt;
import cours.srp.cas1.solution.entity.Livre;
import cours.srp.cas1.solution.repository.EmpruntRepository;
import cours.srp.cas1.solution.services.AdherentService;
import cours.srp.cas1.solution.services.EmpruntService;
import cours.srp.cas1.solution.services.LivreService;


public class EmpruntServiceImpl implements EmpruntService {
     private List<Emprunt> emprunts =new ArrayList<>();
     //Dependances
      private LivreService livreService;
      private AdherentService adherentService;
      private EmpruntRepository empruntRepository;
    
     public EmpruntServiceImpl(LivreService livreService, AdherentService adherentService,
          EmpruntRepository empruntRepository) {
          this.livreService = livreService;
          this.adherentService = adherentService;
          this.empruntRepository = empruntRepository;
      }

     @Override
      public void emprunterLivre(int livreId, int adherentId) {
        // Logique complexe d'emprunt
            //1-Rechercher le Livre
              Livre livre=livreService.rechercherLivreParId(livreId);
            //2-Recherche Adherent
             Adherent adherent= adherentService.rechercherAdherentParId(adherentId);
            //-3 Creer Emprunt
              Emprunt emprunt =new Emprunt(adherent, livre);
               emprunts.add(emprunt);
            //4-Sauvevarge Emprunt
              empruntRepository.sauvegarderDansBaseDeDonnees(emprunt);

    }
    
}
