package database;
import entity.Commande;
import exceptions.DatabaseException;

public interface DatabaseService {
    void saveOrder(Commande commande) throws DatabaseException;
}