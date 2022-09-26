package education.actors;

public abstract class  Person {

    public String nom;
    String prénom;
    String email;
    String password;

    public Person(String nom,String prénom,String email,String password){
        this.nom = nom;
        this.prénom = prénom;
        this.email = email;
        this.password = password;
    }

    public abstract boolean login();

}
