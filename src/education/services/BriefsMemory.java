package education.services;

import education.actors.Formateur;
import education.nonActors.Brief;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BriefsMemory extends Dao<Brief, Formateur> {
  static List<Brief> briefs ;

   static {
       try {
           briefs = new BriefsDB().getAll();
       }catch (SQLException e){
           System.out.println(e.toString());
       }
   }
    public BriefsMemory() throws SQLException {
    }

    @Override
    public List<Brief> getAll() throws SQLException {
         return briefs;
    }

    @Override
    public void insertRow(Brief brief) throws SQLException {
       briefs.add(brief);
    }

    @Override
    public void updateRow(Brief brief, Formateur formateur) throws SQLException {
           brief.setStartDate(LocalDate.now());
    }

    @Override
    public Brief getAllById(int id) {
        return null;
    }
}
