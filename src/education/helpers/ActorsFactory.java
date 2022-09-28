package education.helpers;

import education.actors.Apprenant;
import education.actors.Formateur;
import education.actors.Person;

public class ActorsFactory {



    public Person actorToRegister(String acteurName,String nom ,String prénom,String email,String password){
        switch (acteurName){
            case "Formateur"-> {
                return new Formateur(nom,prénom,email,password);
            }
            case "Acteur"-> {
                return new Apprenant(nom,prénom,email,password);
            }
            default ->{
                return null;
            }
        }
    }
}
