package education.actors;

import education.services.ComptesDB;
import education.services.PromotionsDB;
import education.helpers.ActorsFactory;
import education.nonActors.Promotion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Adminstrateur extends Person{



    {
        this.setRole(1);
    }
    public Adminstrateur() {

    }

    public Adminstrateur(int id,String nom,String prénom,String email,String password){

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







    @Override
    public String toString() {
        return super.toString();
    }
}
