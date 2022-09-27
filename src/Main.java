import education.actors.*;
import education.helpers.actorsSwitcher;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
       //List des Formateurs
        List<Formateur> formateurs = new ArrayList<>();
        formateurs.add(new Formateur("Jawad","DOUFARE"));
        //List des apprenants
        List<Apprenant> apprenants = new ArrayList<>();


        actorsSwitcher as = new actorsSwitcher();
        Person person = as.loginActor(2);
        System.out.println(person.getClass());




    }
}