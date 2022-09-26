package education.actors;

public class Apprenant extends Person{

    public Apprenant(String nom, String prénom, String email, String password) {
        super(nom, prénom, email, password);
    }

    @Override
    public boolean login() {
        return false;
    }
}
