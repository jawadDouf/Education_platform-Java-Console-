package education.nonActors;

import education.actors.Formateur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Brief {
    private StringBuilder body;
    private LocalDate startDate;
    private LocalDate deadLine;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }
}
