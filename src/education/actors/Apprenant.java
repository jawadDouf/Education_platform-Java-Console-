package education.actors;

import education.nonActors.Brief;
import education.nonActors.Promotion;

public class Apprenant extends Person{

    {
        this.setRole(3);
    }
    private Promotion apprenantPromo;
    private Brief briefActuel;
    public Apprenant() {

    }



    public Apprenant(int id,String nom,String prénom,String email,String password){
        super(id,nom,prénom,email,password);
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


    public Brief getBriefActuel() {
        return briefActuel;
    }

    public void setBriefActuel(Brief actualBrief) {
        this.briefActuel = actualBrief;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
