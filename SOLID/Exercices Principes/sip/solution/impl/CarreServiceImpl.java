package cours.sip.solution.impl;

import cours.sip.solution.CarreRectangleService;

public class CarreServiceImpl implements CarreRectangleService {
    private double cote;
    public double getCote() {
        return cote;
    }
    public void setCote(double cote) {
        this.cote = cote;
    }
    @Override
    public void surface() {
        double surface =cote*cote;
        System.out.println("Surface Carre: "+surface);
    }
    @Override
    public double demiPerimetre() {
       return cote*2;
    }
   
}
