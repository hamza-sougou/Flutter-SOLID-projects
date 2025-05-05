package services;

import database.DatabaseService;
import entity.Commande;
import exceptions.DatabaseException;

public class OrderProcessor {
    private DatabaseService database;
    
    public OrderProcessor(DatabaseService database) {
        this.database = database;
    }
    
    public void processOrder(Commande commande) {
        if (commande.getArticles().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        
        double totalPrice = commande.getArticles().stream()
            .mapToDouble(item -> item.getArticle().getPrice())
            .sum();
        
        commande.setTotalPrice(totalPrice);
        
        try {
            database.saveOrder(commande);
        } catch (DatabaseException e) {
            System.err.println("Error saving order: " + e.getMessage());
        }
    }
}