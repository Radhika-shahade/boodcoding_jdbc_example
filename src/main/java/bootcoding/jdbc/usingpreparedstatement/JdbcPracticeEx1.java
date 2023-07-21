package bootcoding.jdbc.usingpreparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPracticeEx1 {
    public static void main(String[] args) {
        Connection connection=null;
       PreparedStatement psmt= null;

        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Admin");
           psmt= connection.prepareStatement("insert into employee values ?,?,? ");
           psmt.setInt(1,1);
           psmt.setString(2,"jayesh");
           psmt.setString(3,"nagpur");
           int n =psmt.executeUpdate();
            if(n == 1){
                System.out.println("Successfully Inserted!");
            }else{
                System.err.println("Failed to Insert Record ");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }finally{
           if(connection!=null)
           {
               try {
                       connection.close();
                   } catch (SQLException e) {
                       throw new RuntimeException(e);

               }
           }
        }
    }
}
