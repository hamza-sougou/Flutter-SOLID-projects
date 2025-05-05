package cours.srp.cas1.solution.services.impl;

import cours.srp.cas1.solution.entity.Adherent;
import cours.srp.cas1.solution.repository.AdherentRepository;
import cours.srp.cas1.solution.services.AdherentService;

public class AdherentServiceImpl  implements AdherentService{
    //Dependance 
     private AdherentRepository adherentRepository;
     //Injection de la Dependance  adherentRepository  a travers le Constructeur 
     public AdherentServiceImpl(AdherentRepository adherentRepository) {
        //Probleme==> la classe AdherentServiceImpl cree la Dependance
         // adherentRepository=new AdherentRepositoryImpl();
        // donc on a pas respecter l'inversion de controle
         //Solution : 
           //Application du Principe Inversion de Dependance   a travers Injection de Dependance
             //Constructeurs 
               this.adherentRepository=adherentRepository;
             //Setters
        
    }

    @Override
    public Adherent rechercherAdherentParId(int adherentId ){
        return adherentRepository.rechercherByIdDansBaseDeDonnees(adherentId);
    }
}
