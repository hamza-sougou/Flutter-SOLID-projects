package taf.resume.solution.models;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private String type;
    private double montant;
    private LocalDate date;

    public Transaction(int id, String type, double montant) {
        this.id = id;
        this.type = type;
        this.montant = montant;
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getMontant() {
        return montant;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + type + " de " + montant + " le " + date;
    }
}
