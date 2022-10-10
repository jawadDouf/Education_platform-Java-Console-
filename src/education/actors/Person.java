package education.actors;

public abstract class  Person {

    int id ;
    String nom;
    String prénom;

    int role;
    protected String email;
    protected String password;




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


    public Person(int id,String nom, String prénom,String email,String password){
        this.id=id;
        this.nom = nom;
        this.prénom = prénom;
        this.email = email;
        this.password = password;
    }

    public Person(){

    }


    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract boolean login(String email, String password);

    @Override
    public String toString() {
        return "Person{" +
                "nom='" + nom + '\'' +
                ", prénom='" + prénom + '\'' +
                '}';
    }



}
