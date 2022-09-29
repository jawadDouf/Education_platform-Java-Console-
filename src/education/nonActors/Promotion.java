package education.nonActors;

import education.actors.Formateur;

public class Promotion {

    private String nom;
    private int size;

    private Formateur formateur;

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

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
