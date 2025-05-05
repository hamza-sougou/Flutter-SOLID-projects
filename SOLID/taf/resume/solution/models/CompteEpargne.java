package taf.resume.solution.models;

import java.time.LocalDate;

public class CompteEpargne extends Compte {
    private LocalDate dateDebutBlocage;
    private int dureeBlocage;

    public CompteEpargne(int id, String numero, int dureeBlocage) {
        super(id, numero);
        this.dureeBlocage = dureeBlocage;
        this.dateDebutBlocage = this.dateCreation;
    }

    public boolean estBloque() {
        LocalDate finBlocage = dateDebutBlocage.plusMonths(dureeBlocage);
        return LocalDate.now().isBefore(finBlocage);
    }

    @Override
    public boolean ajouterTransaction(Transaction transaction) {
        if (transaction.getType().equals("Retrait") && estBloque()) {
            return false;
        }

        if (transaction.getType().equals("Retrait")) {
            if (solde >= transaction.getMontant()) {
                solde -= transaction.getMontant();
                transactions.add(transaction);
                return true;
            } else {
                return false;
            }
        } else if (transaction.getType().equals("Depot")) {
            solde += transaction.getMontant();
            transactions.add(transaction);
            return true;
        }

        return false;
    }

    public int getDureeBlocage() {
        return dureeBlocage;
    }

    @Override
    public String toString() {
        return super.toString() + " | Epargne (blocage: " + dureeBlocage + " mois)";
    }
}
