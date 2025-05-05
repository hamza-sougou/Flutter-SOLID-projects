package cours.liskov.cas1.solution;

/*
 *  Interface ne contient que des methodes abstraites
 *  Classe abstraite contient au moins une methode abstraite mais peut contenir des methodes concretes +attributs 
 */
public abstract class Figure {
    public  abstract void surface();
    public abstract double demiPerimetre();
    public abstract double diametre();
}
