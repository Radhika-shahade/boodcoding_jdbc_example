package bootcoding.jdbc.usingpreparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPreparedUpdateEx3 {
    public static void main(String[]args)
    {
        Connection connection= null;
        PreparedStatement psmt=null;
        try{
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Admin");
            psmt=connection.prepareStatement("update students set name=? where id=?");
            psmt.setString(1,"leena");
            psmt.setInt(2,4);
            int n= psmt.executeUpdate();
            System.out.println(n+ "rows updated");
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (SQLException e) {
                throw new RuntimeException(e);
            }
        finally{
            if(connection!=null)
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }



