package bootcoding.jdbc.basicoperationusingstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdateExample3 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try{
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Admin");
            statement=connection.createStatement();
            int n=statement.executeUpdate("update students set department='cs' where id=102");
            System.out.println(+n+ "Rows updated");

        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException();
        }
        catch(SQLException e)
        {
            throw  new RuntimeException(e);
        }
        finally
        {
            if(connection!=null)
            {
                try{
                    connection.close();
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
