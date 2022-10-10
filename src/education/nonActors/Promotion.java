package education.nonActors;

import education.actors.Formateur;

public class Promotion {

    private int id;
    private String nom;
    private int size;

    private Formateur formateur;

    public Promotion(int id,String nom,int size){
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
