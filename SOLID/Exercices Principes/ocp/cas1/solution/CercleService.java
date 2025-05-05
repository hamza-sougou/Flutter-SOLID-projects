package cours.ocp.cas1.solution;

public class CercleService  implements Figure {
    private double rayon;

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public void surface() {
        double surface =Math.PI*rayon*rayon;
        System.out.println("Surface "+surface); 
    }

    @Override
    public double demiPerimetre() {
       return  Math.PI*2*rayon/2;
    }

    @Override
    public double diametre() {
       return 2*rayon;
    }
}
