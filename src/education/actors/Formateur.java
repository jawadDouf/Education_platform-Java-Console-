package education.actors;

import education.helpers.ActorsFactory;
import education.nonActors.Brief;
import education.nonActors.Promotion;

import java.io.IOException;
import java.util.Scanner;

public class Formateur extends Person{



    public Formateur() {

    }

    public Formateur(String nom,String prénom,String email,String password){

        super(nom,prénom,email,password);

    }
    private Promotion formateurPromo;

    {

    }
    public Promotion getFormateurPromo() {
        return formateurPromo;
    }

    public void setFormateurPromo(Promotion formateurPromo) {
        this.formateurPromo = formateurPromo;
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

     public Brief creerBrief() throws IOException {

        StringBuilder brief = new StringBuilder();
        System.out.print("Entrer le titre de brief : ");
        String titre = ActorsFactory.br.readLine();
        brief.append("Titre de brief : " + titre);
        brief.append("\n");
        brief.append("Languages :");
        System.out.print("Entrer les language de ce brief (Entrer Q pour arreter) : ");
        String language = ActorsFactory.br.readLine();
        brief.append(" "+language);
        while(!language.equals("Q")){
            language = ActorsFactory.br.readLine();
            brief.append(" "+language);
        }
        brief.append("\n");
        brief.append("Description :");
         brief.append("\n");
        System.out.println("Entrer le description de ce brief : ");
        System.out.println("*Entrer Q pour finaliser .");
        String line = ActorsFactory.br.readLine();
        brief.append(line);
        while (!line.equals("Q")){
            line = ActorsFactory.br.readLine();
            brief.append("\n");
            brief.append(line);
        }

        return new Brief(brief,this);
     }




    @Override
    public String toString() {
        return super.toString();
    }
}
