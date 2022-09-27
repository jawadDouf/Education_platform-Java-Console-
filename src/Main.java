import education.actors.*;
import education.helpers.actorsSwitcher;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        //Imported Classes
        Scanner sc = new Scanner(System.in);
        actorsSwitcher as = new actorsSwitcher();
       //List des acteurs(Adminstrateurs,Formateurs,Apprenants)
         List<Person> acteurs = new ArrayList<>();
       //Login Menu
        System.out.print("Entrer votre email : ");
        String emailEntered = sc.nextLine();
        System.out.print("Entrer votre mot de passe : ");
        String motDePasseEntered = sc.nextLine();
       //Verification des données saiser par l'utilisateur
        for (Person pr : acteurs){
            if(pr.getEmail().equals(emailEntered) && pr.getPassword().equals(motDePasseEntered)){
                break;
            }
        }

      //Register Menu
        System.out.print("Entrer le nom : ");
        String nomEntered = sc.nextLine();
        System.out.print("Entrer le prénom : ");
        String prénomEnterd = sc.nextLine();
        System.out.print("Entrer l'email : ");
        String emailEnteredByAdmin = sc.nextLine();
        System.out.print("Entrer le mot de passe : ");
        String motDePasseEnteredByAdmin = sc.nextLine();
        System.out.print("Entrer le type d'utilisateur : ");
        String acteurNom = sc.nextLine();
        //entering the user
        acteurs.add(as.actorToRegister(acteurNom,nomEntered,prénomEnterd,emailEnteredByAdmin,motDePasseEnteredByAdmin));
        System.out.println(acteurs.get(0));

    }
}