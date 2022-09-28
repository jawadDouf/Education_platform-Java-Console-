package education.actors;

import education.nonActors.Promotion;

public class Apprenant extends Person{

    private Promotion apprenantPromo;
    public Apprenant() {

    }

    public Apprenant(String nom,String prénom,String email,String password){

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

    public Promotion getApprenantPromo() {
        return apprenantPromo;
    }

    public void setApprenantPromo(Promotion apprenantPromo) {
        this.apprenantPromo = apprenantPromo;
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
