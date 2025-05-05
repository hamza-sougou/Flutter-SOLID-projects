package taf.cas2.probleme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ProduitRepository {
   private  List<Produit> produits;
   private  final  String nomFichier="produits.txt";
    DataSource dataSource;

    public ProduitRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Produit produit) throws FileNotFoundException{
        if (dataSource==DataSource.List) {
              produits.add(produit);
            } else  {
                      PrintWriter writer = new PrintWriter(new File(nomFichier));
                      produits.forEach(p -> writer.println(p.getNom() + " - " + p.getPrix() + "CFA"));
                
                }
            }
    
    public   List<Produit>  findAll(){
        if (dataSource==DataSource.List) {
             return  produits;
            } else  {
              List<Produit> produits = new ArrayList<>();
              try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
                String ligne;
                while ((ligne = br.readLine()) != null) {
                    String[] parts = ligne.split(" - ");
                    String nom = parts[0];
                    double prix = Double.parseDouble(parts[1].replace("CFA", "").trim());
                    produits.add(new Produit(nom, prix));
                    return produits;
                }
             } catch (IOException e) {
                e.printStackTrace();
             }
            }
            return null;
    }

  
}
