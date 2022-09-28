import education.actors.*;
import education.helpers.ActorsFactory;
import education.nonActors.Promotion;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        //Imported Classes
         Scanner sc = new Scanner(System.in);
         ActorsFactory af = new ActorsFactory();

       //List des acteurs(Adminstrateurs,Formateurs,Apprenants)
         List<Person> acteurs = new ArrayList<>();
         acteurs.add(new Adminstrateur("Jawad","DOUFARE","JD@gmail.com","12345678"));
         acteurs.add(new Formateur("TOUILEB","Ilyass","TI@gmail.com","AZERTYUI"));
         List<Promotion> promotions = new ArrayList<>();
         promotions.add(new Promotion("Java 2",20));
         // Starting Menu



        do{
        System.out.print("Entrer votre email : ");
        String emailEntered = sc.nextLine();
        System.out.print("Entrer votre mot de passe : ");
        String motDePasseEntered = sc.nextLine();
       //Verification des données saiser par l'utilisateur
        for (Person pr : acteurs){
            if(pr.getEmail().equals(emailEntered) && pr.getPassword().equals(motDePasseEntered)){
                System.out.println("Bienvenu dans votre compte Mr." + pr.getNom() + " " + pr.getPrénom());
                if (pr instanceof Adminstrateur){
                    menuAdmin();
                    int choix = sc.nextInt();
                    switch (choix){
                        case 1 -> ((Adminstrateur) pr).ajouterActeur(sc,acteurs,af);
                        case 2 -> ((Adminstrateur) pr).creerPromo(promotions,sc);
                        case 3 -> {
                            listsDesPromotions(promotions);
                            System.out.print("Choisissez La promotion : ");
                            int choix2 = sc.nextInt();
                            while (choix2>0 && choix2 < promotions.size()){
                                System.out.print("Choisissez Le promotion");
                                choix2 = sc.nextInt();
                            }
                            listsDesFormateurs(acteurs);
                            System.out.print("Choisissez Le formateur : ");
                            int choix3 = sc.nextInt();
                            while (choix3 <=0 && choix3 >= acteurs.size()){
                                System.out.print("Choisissez Le formateur : ");
                                choix3 = sc.nextInt();
                            }
                            ((Formateur) acteurs.get(choix3)).setFormateurPromo(promotions.get(choix2));

                        }
                        default -> System.out.println();
                    }
                }else if(pr instanceof Formateur){
                    menuFormateur();
                }else{
                    menuApprenant();
                }
                break;
            } else if (acteurs.indexOf(pr) == acteurs.size()-1) {
                System.out.println("Email ou Mot de passe est faux");
                continue;
            }
        }}while(1<2);





    }
    //les menus
// Adminstrateur Menu
    public static void menuAdmin(){
        System.out.println("1.Ajouter un apprenant/Formateur.");
        System.out.println("2.Creer Un promo .");
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

    //Promotions menu

    public static void listsDesPromotions(List<Promotion> promotions){
        for (Promotion promo: promotions
             ) {
            System.out.println(promotions.indexOf(promo)+"."+promo.getNom()+".");
        }
    }

    public static void listsDesFormateurs(List<Person> acteurs) {
        for (Person acteur : acteurs
        ) {
            if (acteur instanceof Formateur)
                System.out.println(acteurs.indexOf(acteur) + "." + acteur.getNom() + ".");
        }
    }

}


