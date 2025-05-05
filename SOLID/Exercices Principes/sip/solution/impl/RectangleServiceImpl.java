package cours.sip.solution.impl;

import cours.sip.solution.CarreRectangleService;

public class RectangleServiceImpl implements CarreRectangleService  {
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

   
}
