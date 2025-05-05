package cours.ocp.cas1.solution;

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

    @Override
    public double diametre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'diametre'");
    }
}
