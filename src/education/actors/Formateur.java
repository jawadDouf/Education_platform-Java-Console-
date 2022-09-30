package education.actors;

import education.nonActors.Brief;
import education.nonActors.Promotion;

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

     public Brief creerBrief(){
        Scanner sc = new Scanner(System.in);
        StringBuilder brief = new StringBuilder();
        System.out.print("Entrer le titre de brief : ");
        String titre = sc.nextLine();
        brief.append(titre);
        brief.append("/n");
        brief.append("/n");
        brief.append("Languages :");
        System.out.print("Entrer les language de ce brief (Entrer Q pour arreter) : ");
        String language = sc.nextLine();
        brief.append(" "+language);
        while(!language.equals("Q")){
            language = sc.nextLine();
            brief.append(" "+language);
        }
        brief.append("/n");
        System.out.println("Entrer le description de ce brief : ");
        System.out.println("*Entrer Q pour finaliser .");
        String line = sc.nextLine();
        brief.append(line);
        while (!line.equals("Q")){
            line = sc.nextLine();
            brief.append("/n");
            brief.append(line);
        }

        return new Brief(brief,this);
     }




    @Override
    public String toString() {
        return super.toString();
    }
}
