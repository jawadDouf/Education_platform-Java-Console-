package education.actors;

public class Adminstrateur extends Person{

    private String role = "Adminstrateur";




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

    public String getRole() {
        return role;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
