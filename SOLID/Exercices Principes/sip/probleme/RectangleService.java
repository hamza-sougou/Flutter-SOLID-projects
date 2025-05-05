package cours.sip.probleme;

public class RectangleService implements Figure  {
    private double longeur,largeur;
    public double getLongeur() {
        return longeur;
    }

    public void setLongeur(double longeur) {
        this.longeur = longeur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    @Override
    public void surface() {
        double surface =longeur*largeur;
        System.out.println("Surface Rectangle : "+surface);
    }

    @Override
    public double demiPerimetre() {
      return longeur+largeur;
    }

    //Probleme  RectangleService n'a pas besoin de la methode diametre()
    //Pour resoudre le probleme Interface Segregation Principle  
    @Override
    public double diametre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'diametre'");
    }
}
