import education.actors.*;
import education.services.*;
import education.helpers.*;
import education.nonActors.*;


import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;


public class Main2 {
    //Global Variables
   public static List<Integer> listDesIndexes = new ArrayList<>();

    public static void main(String[] args) throws IOException, MessagingException, SQLException {
        //Imported Classes
         ActorsFactory af = new ActorsFactory();

         //initialisation of comptes memory classes .
          ComptesMemory comptesMemory = new ComptesMemory();
          ComptesDB comptesDB = new ComptesDB();
         // initialisation of promotions memory classes
          PromotionsMemory promotionsMemory = new PromotionsMemory();
          PromotionsDB promotionsDB = new PromotionsDB();
        // initialisation of briefs memory classes
         BriefsMemory briefsMemory = new BriefsMemory();
         BriefsDB briefsDB = new BriefsDB();
        do{
        System.out.print("Entrer votre email : ");
        String emailEntered = ActorsFactory.br.readLine();
        System.out.print("Entrer votre mot de passe : ");
        String motDePasseEntered = ActorsFactory.br.readLine();
       //Verification des données saiser par l'utilisateur
        for (Person pr : comptesMemory.getAll()){
            if(pr.getEmail().equals(emailEntered) && pr.getPassword().equals(motDePasseEntered)){
                System.out.println("Bienvenu dans votre compte Mr." + pr.getNom() + " " + pr.getPrénom());
                int choix = 9;
                if (pr instanceof Adminstrateur){
                    while (choix != 0) {
                        menuAdmin();
                        choix = Integer.parseInt(ActorsFactory.br.readLine());
                        switch (choix) {
                            case 1 -> {

                                System.out.print("Entrer le nom : ");
                                String nomEntered =ActorsFactory.br.readLine();

                                System.out.print("Entrer le prénom : ");
                                String prénomEnterd =ActorsFactory.br.readLine();

                                System.out.print("Entrer l'email : ");
                                String emailEnteredByAdmin = ActorsFactory.br.readLine();

                                System.out.print("Entrer le mot de passe : ");
                                String motDePasseEnteredByAdmin = ActorsFactory.br.readLine();

                                System.out.print("Entrer le type d'utilisateur : ");
                                String acteurNom = ActorsFactory.br.readLine();
                                comptesMemory.insertRow(af.actorToRegister(comptesMemory.getAll().get(comptesMemory.getAll().size()-1).getId()+1,acteurNom,nomEntered,prénomEnterd,emailEnteredByAdmin,motDePasseEnteredByAdmin));
                                comptesDB.insertRow(comptesMemory.getAll().get(comptesMemory.getAll().size()-1));
                            }
                            case 2 -> {
                                System.out.print("Entrer le nombres des étudions : ");
                                int size = Integer.parseInt(ActorsFactory.br.readLine());
                                System.out.print("Entrer le nom de promos : ");
                                String nom = ActorsFactory.br.readLine();
                                promotionsMemory.insertRow(new Promotion(promotionsMemory.getAll().get(promotionsMemory.getAll().size()-1).getId()+1,nom,size));
                                promotionsDB.insertRow(new Promotion(promotionsDB.getAll().get(promotionsDB.getAll().size()-1).getId()+1,nom,size));
                            }
                            case 3 -> {
                                listsDesPromotionsSansFormateur(promotionsMemory.getAll());
                                int choix2 = -3;
                                while (!listDesIndexes.contains(choix2)) {
                                    System.out.print("Choisissez La promotion : ");
                                    choix2 = Integer.parseInt(ActorsFactory.br.readLine());
                                }
                                listsDesFormateursSansPromo(comptesMemory.getAll());
                                int choix3 = -1;
                                while (!listDesIndexes.contains(choix3)) {
                                    System.out.print("Choisissez Le formateur : ");
                                    choix3 = Integer.parseInt(ActorsFactory.br.readLine());
                                }
                                new ComptesMemory().updateRow(comptesMemory.getAll().get(choix3),promotionsMemory.getAll().get(choix2));
                                new ComptesDB().updateRow(comptesMemory.getAll().get(choix3),promotionsMemory.getAll().get(choix2));
                                new PromotionsMemory().updateRow(promotionsMemory.getAll().get(choix2),(Formateur) comptesMemory.getAll().get(choix3));
                            }
                            default -> System.out.println();
                        }
                    }
                }else if(pr instanceof Formateur){

                    Brief br = null;

                    while (choix!=0){
                        menuFormateur();
                        choix = Integer.parseInt(ActorsFactory.br.readLine());
                        switch (choix){
                            case 1 -> {
                                try {
                                    System.out.println("Nom de Promo : " + ((Formateur) pr).getFormateurPromo().getNom());
                                    try{
                                        listDesApprenantsDePromo(comptesMemory.getAll(),((Formateur) pr).getFormateurPromo().getNom());
                                    }catch(Exception e) {
                                        System.out.println("Tu n'a pas encore ajouter des apprenants à votre  promo");
                                        continue;
                                    }
                                }catch (Exception e){
                                    System.out.println("Tu n'a pas assigner un promo");
                                    continue;
                                }

                            }
                            case 2 -> {
                                try {
                                    ((Formateur) pr).getFormateurPromo();
                                    System.out.println("-Les Apprenants Vallable est : ");
                                    listDesApprenantsSansPromo(comptesMemory.getAll());
                                    System.out.println("-Saiser le nombre d'apprenant pour le choisissez :");
                                    System.out.println("*Saiser 0 pour sortir.");
                                    int choix3 = -1;
                                    int i = 0;
                                    while (choix3 != 0 || i ==listDesIndexes.size()-1){
                                        i++;
                                        System.out.println("-Saiser le nombre : ");
                                        choix3 = Integer.parseInt(ActorsFactory.br.readLine());
                                        if(!listDesIndexes.contains(choix3)){
                                            System.out.println("Cette apprenant n'est pas vallable .");
                                            continue;
                                        }
                                      //  ((Apprenant) comptesMemory.get(choix3)).setApprenantPromo(((Formateur) pr).getFormateurPromo());
                                        new ComptesMemory().updateRow(comptesMemory.getAll().get(choix3),((Formateur) pr).getFormateurPromo());

                                    }
                                 }catch(Exception e){
                                    System.out.println("Tu n'a pas encore assigner un promotion");
                                    continue;
                                }
                            }
                            case 3 -> {
                                 br = ((Formateur) pr).creerBrief();
                                 System.out.println(br.getBody());
                                 briefsMemory.getAll().add(br);
                            }


                            case 4->{
                                System.out.println("Vos Briefs crées : ");
                                listDesIndexes.clear();
                                for (Brief brief:briefsMemory.getAll()
                                ) {
                                    if(brief.getFormateur().getFormateurPromo().equals(((Formateur) pr).getFormateurPromo())
                                      ){
                                        listDesIndexes.add(briefsMemory.getAll().indexOf(brief));
                                        System.out.println(briefsMemory.getAll().indexOf(brief)+"."+brief.getBody().toString().split("\n")[0]+"=> Ce brief va destribue à : "+brief.getStartDate());
                                    }
                                }
                                System.out.println("Taper le nombre de brief pour le destribuer maintenant .");
                                int choix9 = Integer.parseInt(ActorsFactory.br.readLine());
                                while (!listDesIndexes.contains(choix9)){
                                    System.out.println("N'existe pas,Répeter ");
                                    System.out.println("Taper le nombre de brief pour le destribuer maintenant .");
                                    choix9 = Integer.parseInt(ActorsFactory.br.readLine());
                                }
                                briefsMemory.getAll().get(choix9).setStartDate(LocalDate.now());
                                briefsMemory.updateRow(briefsMemory.getAll().get(choix9),((Formateur) pr));

                            }
                            default -> System.out.println();
                        }
                    }
                }else{
                    while (choix!=0){
                        menuApprenant();
                         choix = Integer.parseInt(ActorsFactory.br.readLine());
                        switch (choix){
                            case 1 ->{
                                for (Brief brief:briefsMemory.getAll()
                                     ) {
                                    if(brief.getFormateur().getFormateurPromo().equals(((Apprenant) pr).getApprenantPromo())
                                            &&  LocalDate.now().isEqual(brief.getStartDate())){
                                        ((Apprenant) pr).setBriefActuel(brief);
                                        System.out.println(((Apprenant) pr).getBriefActuel().getBody());
                                        //emailSender es = new emailSender(((Apprenant) pr).getBriefActuel().getBody(),((Apprenant) pr).getEmail(),comptesMemory.getAll());
                                    }
                                }

                            }


                    }


                    }


                }
                break;
            } else if (comptesMemory.getAll().indexOf(pr) == comptesMemory.getAll().size()-1) {
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
            if(promo.getFormateur() == null){
                listDesIndexes.add(promotions.indexOf(promo));
                System.out.println(promotions.indexOf(promo)+"."+promo.getNom()+".");
                continue;
            }
        }

    }

    public static void listsDesFormateursSansPromo(List<Person> acteurs) {
        listDesIndexes.clear();
        for (Person acteur : acteurs
        ) {
            if (acteur instanceof Formateur){
                     if(((Formateur) acteur).getFormateurPromo() == null){
                         listDesIndexes.add(acteurs.indexOf(acteur));
                         System.out.println(acteurs.indexOf(acteur) + "." + acteur.getNom() + ".");
                     }
            }
        }
    }

    public static void listDesApprenantsSansPromo(List<Person> acteurs){
        listDesIndexes.clear();
        for (Person acteur : acteurs
        ) {
            if (acteur instanceof Apprenant) {

                   if(((Apprenant) acteur).getApprenantPromo()==null){
                       listDesIndexes.add(acteurs.indexOf(acteur));
                       System.out.println(acteurs.indexOf(acteur) + "." + acteur.getNom() + ".");
                   }
            }

        }

    }

    public static void listDesApprenantsDePromo(List<Person> acteurs ,String promoNom){
        listDesIndexes.clear();
        for (Person acteur: acteurs) {
            if (acteur instanceof Apprenant){
                    if(((Apprenant) acteur).getApprenantPromo().getNom().equals(promoNom)){
                        listDesIndexes.add(acteurs.indexOf(acteur));
                        System.out.println(acteurs.indexOf(acteur)+ "." + acteur.getNom() + ".");
                    }
            }
        }
    }



}


