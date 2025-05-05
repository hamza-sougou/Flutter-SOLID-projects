package cours.sip.probleme;

public class CarreService implements Figure {
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

    //Probleme  CarreService n'a pas besoin de la methode diametre()
    //Pour resoudre le probleme Interface Segregation Principle  
    @Override
    public double diametre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'diametre'");
    }

    
   
}
