package education.nonActors;

import education.actors.Formateur;

import java.time.LocalDate;
import java.time.ZoneId;

public class Brief {

    int id;
    private StringBuilder body;
    private LocalDate startDate;
    private LocalDate deadLine;
    private Formateur formateur;
    public Brief(StringBuilder body){

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
