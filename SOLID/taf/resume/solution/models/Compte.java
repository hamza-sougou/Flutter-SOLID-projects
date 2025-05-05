package taf.resume.solution.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
    protected int id;
    protected String numero;
    protected LocalDate dateCreation;
    protected double solde;
    protected List<Transaction> transactions;

    public Compte(int id, String numero) {
        this.id = id;
        this.numero = numero;
        this.dateCreation = LocalDate.now();
        this.solde = 0;
        this.transactions = new ArrayList<>();
    }

    public abstract boolean ajouterTransaction(Transaction transaction);

    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return numero + " | Solde: " + solde + " | Date: " + dateCreation;
    }
}
