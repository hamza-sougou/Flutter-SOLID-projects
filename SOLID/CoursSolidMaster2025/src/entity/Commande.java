package entity;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private List<LigneCommande> articles;
    private double totalPrice;

    public Commande() {
        this.articles = new ArrayList<>();
    }

    public List<LigneCommande> getArticles() {
        return articles;
    }

    public void setArticles(List<LigneCommande> articles) {
        if (articles == null) {
            this.articles = new ArrayList<>();
        } else {
            this.articles = articles;
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
