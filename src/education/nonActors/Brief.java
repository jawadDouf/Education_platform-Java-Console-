package education.nonActors;

import education.actors.Formateur;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Brief {



    private StringBuilder body;



    private Formateur formateur;
    public Brief(StringBuilder body,Formateur formateur){
        this.formateur = formateur;
        this.body = body;
    }



    public StringBuilder getBody() {
        return body;
    }

    public void setBody(StringBuilder body) {
        this.body = body;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }
}
