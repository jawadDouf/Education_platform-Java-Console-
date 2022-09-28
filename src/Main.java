import education.actors.*;
import education.helpers.ActorsFactory;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        //Imported Classes
         Scanner sc = new Scanner(System.in);
        ActorsFactory af = new ActorsFactory();
       //List des acteurs(Adminstrateurs,Formateurs,Apprenants)
         List<Person> acteurs = new ArrayList<>();

         // Starting Menu
        System.out.print("Entrer votre email : ");
        String emailEntered = sc.nextLine();
        System.out.print("Entrer votre mot de passe : ");
        String motDePasseEntered = sc.nextLine();
       //Verification des données saiser par l'utilisateur


        for (Person pr : acteurs){
            if(pr.getEmail().equals(emailEntered) && pr.getPassword().equals(motDePasseEntered)){
                System.out.println("Bienvenu dans votre compte Mr" + pr.getNom() + " " + pr.getPrénom());
                if (pr.getRole().equals("Administrateur")){
                    menuAdmin();
                    int choix = sc.nextInt();
                    switch (choix){
                        case 1 -> ajouterActeur(sc,acteurs,af);
                        case 2 -> System.out.println();
                        default -> System.out.println();
                    }
                }else if(pr.getRole().equals("Formateur")){
                    menuFormateur();
                }else{
                    menuApprenant();
                }
                break;
            }
        }






    }
    //les menus
// Adminstrateur Menu
    public static void menuAdmin(){
        System.out.println("1.Ajouter un apprenant.");
        System.out.println("2.Ajouter un formateur. ");
        System.out.println("3.Attribue une promo à chaque formateur.");
        System.out.print("Entrer votre choix : ");

    }
    //Formateur Menu
    public static void menuFormateur(){
        System.out.println("1.Ajoute les apprenants à sa propre promo");
        System.out.println("2.Crée des briefs");
        System.out.println("3.Adistribue un ou plusieurs briefs à la promo.");
        System.out.print("Entrer votre choix : ");

    }
    //Apprenant Menu
    public static void menuApprenant(){
        System.out.println("1.Voir Les Briefs");
        System.out.print("Entrer votre choix : ");
    }

    //les opération
    //Adminstrateur Opération
    public static void ajouterActeur(Scanner sc,List<Person> acteurs,ActorsFactory af){
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
        acteurs.add(af.actorToRegister(acteurNom,nomEntered,prénomEnterd,emailEnteredByAdmin,motDePasseEnteredByAdmin));
        System.out.println(acteurs.get(0));
    }
}


