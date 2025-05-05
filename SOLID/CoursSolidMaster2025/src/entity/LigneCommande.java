package entity;

public class LigneCommande {
    private Article article;
    private int quantity;

    public LigneCommande(Article article, int quantity) {
        this.article = article;
        this.quantity = quantity;
    }

    public Article getArticle() {
        return article;
    }

    public int getQuantity() {
        return quantity;
    }
}