package education.services;

import education.nonActors.Promotion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class Dao<T,V> {

      static java.sql.Connection con = Connection.connect();
      PreparedStatement pStmt ;
      abstract public List<T> getAll() throws SQLException;

      abstract public void insertRow(T t) throws SQLException;


      public abstract void updateRow(T t,V v) throws SQLException;

      abstract public T getAllById(int id) throws SQLException;




}
