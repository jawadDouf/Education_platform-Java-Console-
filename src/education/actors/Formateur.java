package education.actors;

import education.nonActors.Promotion;

public class Formateur extends Person{


    private Promotion formateurPromo;

    {

    }
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

    public Promotion getFormateurPromo() {
        return formateurPromo;
    }

    public void setFormateurPromo(Promotion formateurPromo) {
        this.formateurPromo = formateurPromo;
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
