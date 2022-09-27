package education.helpers;

import education.actors.Adminstrateur;
import education.actors.Apprenant;
import education.actors.Formateur;
import education.actors.Person;

public class actorsSwitcher {



    public Person loginActor(int actorNumber){
        switch (actorNumber){
            case 1 -> {
                return new Adminstrateur();
            }
            case 2 -> {
                return new Formateur();
            }
            case 3 -> {
                return new Apprenant();
            }
            default ->{
                return null;
            }
        }
    }
}
