package education.actors;

import education.helpers.ActorsFactory;
import education.nonActors.Promotion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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



    public  void ajouterActeur(List<Person> acteurs, ActorsFactory af) throws IOException {

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
        //entering the user
        acteurs.add(af.actorToRegister(acteurNom,nomEntered,prénomEnterd,emailEnteredByAdmin,motDePasseEnteredByAdmin));
        System.out.println(acteurs.get(0));
    }

    public void creerPromo(List<Promotion> promotions) throws IOException {

        System.out.print("Entrer le nombres des étudions : ");
        int size = Integer.parseInt(ActorsFactory.br.readLine());
        System.out.print("Entrer le nom de promos : ");
        String nom = ActorsFactory.br.readLine();
        promotions.add(new Promotion(nom,size));

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
