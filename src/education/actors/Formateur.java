package education.actors;

public class Formateur extends Person{
    public Formateur(String nom, String prénom, String email, String password) {
        super(nom, prénom, email, password);
    }

    @Override
    public boolean login() {

        return false;
    }
}
