package education.services;

import education.actors.Adminstrateur;
import education.actors.Apprenant;
import education.actors.Formateur;
import education.actors.Person;
import education.nonActors.Brief;
import education.nonActors.Promotion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComptesDB extends Dao<Person,Promotion>{



    @Override
    public List<Person> getAll() throws SQLException {
        List<Person> list = new ArrayList<>();
        String query = "SELECT * FROM comptes INNER JOIN promotions";
        pStmt = con.prepareStatement(query);
        ResultSet rs = pStmt.executeQuery();
        while (rs.next()){
            if(rs.getInt(7) == 1) list.add(new Adminstrateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(4)));
            else if(rs.getInt(7) == 2) {
                list.add(new Formateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(4)));
                if(rs.getInt(6) != 0){
                    ((Formateur) list.get(list.size()-1)).setFormateurPromo(new PromotionsMemory().getAllById(rs.getInt(6)));
                }
            }

            else if(rs.getInt(7) == 3) list.add(new Apprenant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(4)));
            }
        return list;
        }





    @Override
    public void insertRow(Person person) throws SQLException {
        String query = "INSERT INTO comptes (nom,prenom,password,email,role) values (?,?,?,?,?)";
        pStmt = con.prepareStatement(query);
        pStmt.setString(1,person.getNom());
        pStmt.setString(2,person.getPrénom());
        pStmt.setString(3,person.getPassword());
        pStmt.setString(4,person.getEmail());
        pStmt.setInt(5,person.getRole());
        pStmt.executeUpdate();

    }

    @Override
    public void updateRow(Person person, Promotion promotion) throws SQLException {
        String query = "UPDATE comptes SET id_prom = ? where id = ?";
        pStmt = con.prepareStatement(query);
        pStmt.setInt(1,promotion.getId());
        pStmt.setInt(2,person.getId());
        pStmt.executeUpdate();

    }


    public Person getAllById(int id) {
        return null;
    }
}
