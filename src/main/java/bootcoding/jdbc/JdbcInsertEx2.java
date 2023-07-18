package bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertEx2 {
    Connection connection=null;
    Statement statement=null;
    public static void main(String[] args) {
       try {
            //load and register the driver
            Class.forName("org.postgresql.Driver");
            //establish the connection
            Connection conn= DriverManager.getConnection("jdbc:postgresql://localhost 5432/postgres","postgres","Admin");
           //create statement object
           Statement statement= conn.createStatement();
           String sql="insert into students values (102,'ramesh','nagpur','civil')";
           int n= statement.executeUpdate(sql);
           System.out.println("Record inserted: "+ n);
        }
        catch (ClassNotFoundException e)
        {

        }
        catch (SQLException e)
        {

        }
    }
}
