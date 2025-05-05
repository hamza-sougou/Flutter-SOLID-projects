package cours.srp.cas1.solution.views;

import cours.srp.cas1.solution.repository.AdherentRepository;
import cours.srp.cas1.solution.repository.EmpruntRepository;
import cours.srp.cas1.solution.repository.LivreRepository;
import cours.srp.cas1.solution.repository.impl.AdherentRepositoryImpl;
import cours.srp.cas1.solution.repository.impl.EmpruntRepositoryImpl;
import cours.srp.cas1.solution.repository.impl.LivreRepositoryImpl;
import cours.srp.cas1.solution.services.AdherentService;
import cours.srp.cas1.solution.services.EmpruntService;
import cours.srp.cas1.solution.services.LivreService;
import cours.srp.cas1.solution.services.impl.AdherentServiceImpl;
import cours.srp.cas1.solution.services.impl.EmpruntServiceImpl;
import cours.srp.cas1.solution.services.impl.LivreServiceImpl;

public class App {
    public static void main(String[] args) {
         AdherentRepository adherentRepository =new AdherentRepositoryImpl();
         LivreRepository livreRepository=new LivreRepositoryImpl();
         EmpruntRepository empruntRepository =new EmpruntRepositoryImpl();
         AdherentService adherentService=new AdherentServiceImpl(adherentRepository);  

         adherentService.rechercherAdherentParId(1);
         LivreService livreService=new LivreServiceImpl(livreRepository);

          EmpruntService empruntService=new EmpruntServiceImpl(livreService,adherentService,empruntRepository);
          empruntService.emprunterLivre(1, 1);
    }
}
