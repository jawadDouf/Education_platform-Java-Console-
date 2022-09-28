package education.nonActors;

public class Promotion {

    private String nom;
    private int size;

    public Promotion(String nom,int size){
        this.nom = nom;
        this.size = size;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
