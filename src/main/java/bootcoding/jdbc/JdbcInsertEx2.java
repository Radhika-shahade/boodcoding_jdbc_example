package bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertEx2 {

    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
       try {
            //load and register the driver
            Class.forName("org.postgresql.Driver");
            //establish the connection
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Admin");
           //create statement object
             statement= connection.createStatement();
           String sql="insert into students values (102,'ramesh','nagpur','civil')";
           int n= statement.executeUpdate(sql);
           System.out.println("Record inserted: "+ n);
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
