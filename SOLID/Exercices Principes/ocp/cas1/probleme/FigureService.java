package cours.ocp.cas1.probleme;

//Rectangle ou Carre ou 
//Evolution Cercle 
public class FigureService {
   
    private double longeur,largeur,cote,rayon;
    private TypeFigure type;
    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }
 
    
        public double getCote() {
        return cote;
    }

    public void setCote(double cote) {
        this.cote = cote;
    }

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
     
         public FigureService(TypeFigure type) {
            this.type = type;
         }
        
        public void surface() {
            if (type==TypeFigure.Carre) {
                surfaceCarre();
            } else if(type==TypeFigure.Rectangle)  {
                surfaceRectangle();
            }else{
                surfaceCercle();
            }
        }
        
        private void surfaceCarre() { 
            double surface =cote*cote;
            System.out.println("Surface "+surface);
         }
        private void surfaceRectangle() {  
            double surface =longeur*largeur;
            System.out.println("Surface "+surface);
        }
        private void surfaceCercle() {  
            double surface =Math.PI*rayon*rayon;
            System.out.println("Surface "+surface);
        }
       }

       

