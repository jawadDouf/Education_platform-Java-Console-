package education.services;

import java.sql.DriverManager;

public class Connection {

    private static java.sql.Connection con;
    static {
        String url = "jdbc:mysql://localhost:3306/simplon_clone";
        String user = "root";
        String password = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);

        }catch (Exception e){

        }

    }

    public static java.sql.Connection connect(){

        return con;
    }
}
