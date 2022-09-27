package education.actors;

public class Formateur extends Person{



    public Formateur() {

    }

    public Formateur(String nom,String password){
        super(nom,password);
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

    @Override
    public String toString() {
        return super.toString();
    }
}
