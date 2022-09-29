import education.actors.*;
import education.helpers.ActorsFactory;
import education.nonActors.Promotion;

import java.util.*;


public class Main {
    //Global Variables
    static List<Integer> listDesIndexes = new ArrayList<>();
    public static void main(String[] args) {
        //Imported Classes
         Scanner sc = new Scanner(System.in);
         ActorsFactory af = new ActorsFactory();

       //List des acteurs(Adminstrateurs,Formateurs,Apprenants)
         List<Person> acteurs = new ArrayList<>();
         acteurs.add(new Adminstrateur("Jawad","DOUFARE","JD@gmail.com","12345678"));
         acteurs.add(new Formateur("TOUILEB","Ilyass","TI@gmail.com","AZERTYUI"));
         //List des promotions
         List<Promotion> promotions = new ArrayList<>();
         promotions.add(new Promotion("Java 2",20));


         // Starting Menu



        do{
        System.out.print("Entrer votre email : ");
        String emailEntered = sc.nextLine();
        sc.nextLine();
        System.out.print("Entrer votre mot de passe : ");
        String motDePasseEntered = sc.nextLine();
       //Verification des données saiser par l'utilisateur
        for (Person pr : acteurs){
            if(pr.getEmail().equals(emailEntered) && pr.getPassword().equals(motDePasseEntered)){
                System.out.println("Bienvenu dans votre compte Mr." + pr.getNom() + " " + pr.getPrénom());
                int choix = 9;
                if (pr instanceof Adminstrateur){
                    while (choix != 0) {
                        menuAdmin();
                        choix = sc.nextInt();
                        switch (choix) {
                            case 1 -> ((Adminstrateur) pr).ajouterActeur(sc, acteurs, af);
                            case 2 -> ((Adminstrateur) pr).creerPromo(promotions, sc);
                            case 3 -> {
                                listsDesPromotionsSansFormateur(promotions);

                                int choix2 = -3;
                                while (!listDesIndexes.contains(choix2)) {
                                    System.out.print("Choisissez Le promotion");
                                    choix2 = sc.nextInt();
                                }
                                listsDesFormateursSansPromo(acteurs);
                                int choix3 = -1;
                                while (!listDesIndexes.contains(choix3)) {
                                    System.out.print("Choisissez Le formateur : ");
                                    choix3 = sc.nextInt();
                                }
                                ((Formateur) acteurs.get(choix3)).setFormateurPromo(promotions.get(choix2));

                            }
                            default -> System.out.println();
                        }
                    }
                }else if(pr instanceof Formateur){


                    while (choix!=0){
                        menuFormateur();
                        choix = sc.nextInt();
                        switch (choix){
                            case 1 -> {
                                System.out.println("Nom de Promo : " + ((Formateur) pr).getFormateurPromo().getNom());
                                listDesApprenantsDePromo(acteurs,((Formateur) pr).getFormateurPromo().getNom());
                            }
                            case 2 -> {
                                System.out.println("-Les Apprenants Vallable est : ");
                                listDesApprenantsSansPromo(acteurs);
                                System.out.println("-Saiser le nombre d'apprenant pour le choisissez :");
                                System.out.println("*Saiser Q pour sortir.");
                                String choix3 = "A";
                                while (!choix3.equals("Q")){
                                    System.out.println("-Saiser le nombre : ");
                                    choix3 = sc.nextLine();
                                    if(!listDesIndexes.contains(Integer.parseInt(choix3))){
                                        System.out.println("Cette apprenant n'est pas vallable .");
                                        continue;
                                    }
                                    ((Apprenant) acteurs.get(Integer.parseInt(choix3))).setApprenantPromo(((Formateur) pr).getFormateurPromo());
                                }
                            }
                            default -> System.out.println();
                        }
                    }
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
        System.out.println("0.Quitter.");
        System.out.print("Entrer votre choix : ");

    }
    //Formateur Menu
    public static void menuFormateur(){
        System.out.println("1.Afficher ma promo.");
        System.out.println("2.Ajoute les apprenants à ma promo");
        System.out.println("3.Crée des briefs");
        System.out.println("4.Adistribue un ou plusieurs briefs à la promo.");
        System.out.println("0.Quitter.");
        System.out.print("Entrer votre choix : ");

    }
    //Apprenant Menu
    public static void menuApprenant(){
        System.out.println("1.Voir Les Briefs");
        System.out.println("0.Quitter.");
        System.out.print("Entrer votre choix : ");
    }

    //Promotions menu

    public static void listsDesPromotionsSansFormateur(List<Promotion> promotions){
        listDesIndexes.clear();
        for (Promotion promo: promotions
             ) {
            if(promo.getFormateur().equals(null)){
                listDesIndexes.add(promotions.indexOf(promo));
                System.out.println(promotions.indexOf(promo)+"."+promo.getNom()+".");
            }

        }
    }

    public static void listsDesFormateursSansPromo(List<Person> acteurs) {
        listDesIndexes.clear();
        for (Person acteur : acteurs
        ) {

            if (acteur instanceof Formateur && ((Formateur) acteur).getFormateurPromo().equals(null)){
                listDesIndexes.add(acteurs.indexOf(acteur));
                System.out.println(acteurs.indexOf(acteur) + "." + acteur.getNom() + ".");
            }


        }
    }

    public static void listDesApprenantsSansPromo(List<Person> acteurs){
        listDesIndexes.clear();
        for (Person acteur : acteurs
        ) {
            if (acteur instanceof Apprenant && ((Apprenant) acteur).getApprenantPromo().equals(null)) {
                listDesIndexes.add(acteurs.indexOf(acteur));
                System.out.println(acteurs.indexOf(acteur) + "." + acteur.getNom() + ".");
            }

        }

    }

    public static void listDesApprenantsDePromo(List<Person> acteurs ,String promoNom){
        listDesIndexes.clear();
        for (Person acteur: acteurs) {
            if (acteur instanceof Apprenant && ((Apprenant) acteur).getApprenantPromo().getNom().equals(promoNom)){
                listDesIndexes.add(acteurs.indexOf(acteur));
                System.out.println(acteurs.indexOf(acteur)+ "." + acteur.getNom() + ".");
            }
        }
    }


}


