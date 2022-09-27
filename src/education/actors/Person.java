package education.actors;

public abstract class  Person {

    String nom;
    String prénom;
    protected String email;
    protected String password;

     String profession;

    public String getNom() {
        return nom;
    }
    public String getPrénom() {
        return prénom;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Person(String nom, String prénom,String email,String password){
        this.nom = nom;
        this.prénom = prénom;
        this.email = email;
        this.password = password;
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
