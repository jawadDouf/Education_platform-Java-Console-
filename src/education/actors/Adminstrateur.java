package education.actors;

public class Adminstrateur extends Person{



    public Adminstrateur(String nom, String prénom, String email, String password) {
        super(nom, prénom, email, password);
    }

    @Override
    public boolean login() {

        return false;
    }
}
