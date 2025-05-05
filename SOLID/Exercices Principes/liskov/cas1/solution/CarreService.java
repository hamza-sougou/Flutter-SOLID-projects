package cours.liskov.cas1.solution;

public class CarreService extends Figure {
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

    @Override
    public double diametre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'diametre'");
    }

   
}
