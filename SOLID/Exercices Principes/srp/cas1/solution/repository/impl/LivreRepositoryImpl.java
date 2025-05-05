package cours.srp.cas1.solution.repository.impl;

import cours.srp.cas1.solution.entity.Livre;
import cours.srp.cas1.solution.repository.LivreRepository;

public class LivreRepositoryImpl  implements LivreRepository{
        @Override
        public void sauvegarderDansBaseDeDonnees(Livre livre) {
            //Requete Select 
          // Code complexe de sauvegarde en base
         }

         @Override
          public Livre rechercherByIdDansBaseDeDonnees(int livreId) {
          //Requete Select 
            return null;
         }


}
