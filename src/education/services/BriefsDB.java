package education.services;

import education.actors.Formateur;
import education.nonActors.Brief;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class BriefsDB extends Dao<Brief, Formateur> {

    @Override
    public List<Brief> getAll() throws SQLException {
        List<Brief> list = new ArrayList<>();
        pStmt = con.prepareStatement("Select * from briefs" +
                " INNER JOIN promotions");
        ResultSet briefs = pStmt.executeQuery();
        while (briefs.next()){
           Brief brief = new Brief(new StringBuilder(briefs.getString(2)));
           if(briefs.getInt(5) != 0){
               brief.setFormateur(new PromotionsMemory().getAllById(briefs.getInt(5)).getFormateur());
           }
           brief.setStartDate(briefs.getDate(3).toLocalDate());
           brief.setDeadLine(briefs.getDate(4).toLocalDate());
           list.add(brief);
        }

        return list;

    }

    @Override
    public void insertRow(Brief brief) throws SQLException {
        String query = "Insert into briefs (body,date_lancement,date_deadline,id_promo) values (?,?,?,?)";
        pStmt = con.prepareStatement(query);
        pStmt.setString(1,brief.getBody().toString());
        pStmt.setDate(2, Date.valueOf(brief.getStartDate()));
        pStmt.setDate(3, Date.valueOf(brief.getDeadLine()));
        pStmt.setInt(4,brief.getFormateur().getFormateurPromo().getId());
        pStmt.executeUpdate();
    }

    @Override
    public void updateRow(Brief brief,Formateur formateur) throws SQLException {
        // changer la date de lancemant à maintenat
        brief.setStartDate(LocalDate.now());
        String query = "UPDATE briefs SET date_lancement = ?  where id = ?";
        pStmt = con.prepareStatement(query);
        pStmt.setDate(1,Date.valueOf(brief.getStartDate()));
        pStmt.executeUpdate();
    }


    @Override
    public Brief getAllById(int id) {
        return null;
    }
}
