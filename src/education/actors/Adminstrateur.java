package education.actors;

import education.helpers.ActorsFactory;
import education.nonActors.Promotion;

import java.util.List;
import java.util.Scanner;

public class Adminstrateur extends Person{

    public Adminstrateur() {

    }

    public Adminstrateur(String nom,String prénom,String email,String password){

        super(nom,prénom,email,password);

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



    public  void ajouterActeur(Scanner sc, List<Person> acteurs, ActorsFactory af){
        Scanner s1 = new Scanner(System.in);
        System.out.print("Entrer le nom : ");
        String nomEntered = s1.nextLine();
        sc.nextLine();
        System.out.print("Entrer le prénom : ");
        String prénomEnterd = sc.nextLine();

        System.out.print("Entrer l'email : ");
        String emailEnteredByAdmin = s1.nextLine();

        System.out.print("Entrer le mot de passe : ");
        String motDePasseEnteredByAdmin = s1.nextLine();

        System.out.print("Entrer le type d'utilisateur : ");
        String acteurNom = sc.nextLine();
        //entering the user
        acteurs.add(af.actorToRegister(acteurNom,nomEntered,prénomEnterd,emailEnteredByAdmin,motDePasseEnteredByAdmin));
        System.out.println(acteurs.get(0));
    }

    public void creerPromo(List<Promotion> promotions,Scanner sc){
        Scanner s = new Scanner(System.in);
        System.out.print("Entrer le nombres des étudions : ");
        int size = sc.nextInt();


        System.out.print("Entrer le nom de promos : ");
        String nom = s.nextLine();
        promotions.add(new Promotion(nom,size));

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
