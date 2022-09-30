package education.helpers;

import education.actors.Apprenant;
import education.actors.Formateur;
import education.actors.Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ActorsFactory {

    public static InputStreamReader r = new InputStreamReader(System.in);
    public static BufferedReader br = new BufferedReader(r);


    public Person actorToRegister(String acteurName,String nom ,String prénom,String email,String password){
        switch (acteurName){
            case "Formateur" -> {
                return new Formateur(nom,prénom,email,password);
            }
            case "Apprenant"-> {
                return new Apprenant(nom,prénom,email,password);
            }
            default ->{
                return null;
            }
        }
    }
}
