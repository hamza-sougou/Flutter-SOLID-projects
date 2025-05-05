package main;

import database.MySQLDatabase;
import entity.Commande;
import entity.Article;
import entity.LigneCommande;
import services.OrderProcessor;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor(new MySQLDatabase());

        Article article = new Article("Laptop", 1000.00);
        LigneCommande ligneCommande = new LigneCommande(article, 1);

        Commande commande = new Commande();
        commande.setArticles(Arrays.asList(ligneCommande));

        processor.processOrder(commande);
    }
}