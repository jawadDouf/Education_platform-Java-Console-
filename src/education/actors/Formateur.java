package education.actors;

public class Formateur extends Person{

    private String role = "Formateur";

    public Formateur() {

    }

    public Formateur(String nom,String prénom,String email,String password){
        super(nom,prénom,email,password);
    }
    @Override
    public boolean login(String email,String password) {
        if(this.email.equals(email) && this.password.equals(password)){
            this.toString();
            return true;
        }else {
            return false;
        }

    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
