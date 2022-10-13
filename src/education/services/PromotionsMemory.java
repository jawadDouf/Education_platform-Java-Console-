package education.services;

import education.actors.Formateur;
import education.nonActors.Promotion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotionsMemory extends Dao<Promotion, Formateur> {
    static List<Promotion> promotions;

    static {
        try {
            promotions = new PromotionsDB().getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PromotionsMemory() throws SQLException {
    }



    @Override
    public List<Promotion> getAll() throws SQLException {

        return promotions;
    }

    @Override
    public void insertRow(Promotion promotion) throws SQLException {
         promotions.add(promotion);
    }

    @Override
    public void updateRow(Promotion promotion, Formateur formateur) throws SQLException {
        promotion.setFormateur(formateur);
    }

    @Override
    public Promotion getAllById(int id) {
        for (Promotion promotion:
              this.promotions) {
            if(promotion.getId() == id) return promotion;
        }
        return null;
    }
}
