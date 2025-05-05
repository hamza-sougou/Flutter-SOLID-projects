package taf.resume.solution.services;

import taf.resume.solution.models.Compte;
import taf.resume.solution.models.Transaction;
import taf.resume.solution.utils.IdGenerator;

public class TransactionService {

    public boolean ajouterTransaction(Compte compte, String type, double montant) {
        int id = IdGenerator.generateId();
        Transaction transaction = new Transaction(id, type, montant);
        return compte.ajouterTransaction(transaction);
    }
}
