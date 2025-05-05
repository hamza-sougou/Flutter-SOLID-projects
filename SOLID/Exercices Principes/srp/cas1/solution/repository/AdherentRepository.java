package cours.srp.cas1.solution.repository;

import cours.srp.cas1.solution.entity.Adherent;

public interface AdherentRepository  {
      public Adherent rechercherByIdDansBaseDeDonnees(int adherentId);   
}
