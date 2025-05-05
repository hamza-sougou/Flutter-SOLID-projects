package cours.srp.cas1.probleme;

import java.io.OutputStream;
import java.util.List;

public class BibliothequeService {

    private List<Livre> livres;
    private List<Emprunt> emprunts;
    
    // Constructeur, getters, setters...
    
    // Gestion des livres
    public void ajouterLivre(Livre livre) {
        livres.add(livre);
        sauvegarderDansBaseDeDonnees(livre);
    }
    
    private void sauvegarderDansBaseDeDonnees(Livre livre) {
        // Code complexe de sauvegarde en base
    }
    
    // Gestion des emprunts
    public void emprunterLivre(int livreId, int membreId) {
        // Logique complexe d'emprunt
    }
   
    /*
     * Reste a faire apres la pause 
     */
    public void retournerLivre(int empruntId) {
        // Logique complexe de retour
    }
    
    // Génération de rapports
    public void genererRapportLivres(OutputStream output) {
        // Génération PDF complexe
    }
    
    public void genererRapportEmprunts(OutputStream output) {
        // Génération Excel complexe
    }
    
    // Notification
    public void envoyerRappelRetard(int empruntId) {
        // Logique d'envoi d'email
    }
}

