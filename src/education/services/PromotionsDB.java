package education.services;

import education.actors.Formateur;
import education.nonActors.Promotion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotionsDB extends Dao<Promotion,Formateur> {


    @Override
    public List<Promotion> getAll() throws SQLException {
        List<Promotion> list = new ArrayList<>();
        pStmt = con.prepareStatement("Select * from promotions");
        ResultSet promotions = pStmt.executeQuery();
        while (promotions.next()){
            list.add(new Promotion(promotions.getInt(2),promotions.getString(1),promotions.getInt(3)));
        }

        return list;
    }

    @Override
    public void insertRow(Promotion promotion) throws SQLException {
        String query = "insert into promotions (nom,size) values (?,?)";

        pStmt = con.prepareStatement(query);

        pStmt.setString(1,promotion.getNom());

        pStmt.setInt(2,promotion.getSize());

        pStmt.executeUpdate();


    }

    @Override
    public void updateRow(Promotion promotion, Formateur formateur) throws SQLException {


    }

    @Override
    public Promotion getAllById(int id) throws SQLException {
        String query = "Select * from promotions where id_promotion = ?";
        pStmt = con.prepareStatement(query);
        pStmt.setInt(1,id);
        ResultSet promotion = pStmt.getResultSet();
        return new Promotion(promotion.getInt(2),promotion.getString(1),promotion.getInt(3));
    }
}
