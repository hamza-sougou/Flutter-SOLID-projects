package database;
import entity.Commande;
import exceptions.DatabaseException;

public class MySQLDatabase implements DatabaseService {
    @Override
    public void saveOrder(Commande commande) throws DatabaseException {
        System.out.println("Cher client, votre commande à été traitée");
    }
}