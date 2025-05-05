package taf.resume.solution.models;

public class CompteCheque extends Compte {

    public CompteCheque(int id, String numero) {
        super(id, numero);
    }

    @Override
    public boolean ajouterTransaction(Transaction transaction) {
        double frais = 0.008 * transaction.getMontant();
        double montantTotal = transaction.getMontant() + (transaction.getType().equals("Retrait") ? frais : 0);

        if (transaction.getType().equals("Retrait")) {
            if (solde >= montantTotal) {
                solde -= montantTotal;
                transactions.add(transaction);
                return true;
            } else {
                return false;
            }
        } else if (transaction.getType().equals("Depot")) {
            solde += transaction.getMontant() - frais;
            transactions.add(transaction);
            return true;
        }
        return false;
    }
}
