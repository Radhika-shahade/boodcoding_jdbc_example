package bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDeleteExample4 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement= null;
            try {
                Class.forName("org.postgresql.Driver");
                connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Admin");
               statement=connection.createStatement();
              int n = statement.executeUpdate("Delete from students where id=102 ");
                System.out.println(+n+ "Rows Deleted");
                }
            catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
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
