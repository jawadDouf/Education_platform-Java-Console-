package education.actors;

public abstract class  Person {

    public String nom;
    String prénom;
    String email;
    String password;

    public Person(String nom,String prénom){
        this.nom = nom;
        this.prénom = prénom;
    }
    public Person(){

    }

    public abstract boolean login(String email,String password);

    @Override
    public String toString() {
        return "Person{" +
                "nom='" + nom + '\'' +
                ", prénom='" + prénom + '\'' +
                '}';
    }
}
