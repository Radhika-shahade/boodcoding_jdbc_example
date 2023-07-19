package bootcoding.jdbc.basicoperationusingstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertEx1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //load and register the driver
        Class.forName("org.postgresql.Driver");

        //Establish the connection
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Admin");

        //create statement object
        Statement statement=connection.createStatement();

        //Execute the query
        String sql="insert into students values(101,'suresh','mumbai','Electrical')";
        int n=statement.executeUpdate(sql);

        System.out.println(n+ " Record inserted");
        if(connection!=null)
        {
            connection.close();
        }


    }
}
