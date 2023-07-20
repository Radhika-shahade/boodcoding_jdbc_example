package bootcoding.jdbc.usingpreparedstatement;

import java.sql.*;

public class JDBCSelectEx5 {
    public static void main(String[] args) {
        Connection connection= null;
        PreparedStatement psmt= null;
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "Admin");
             psmt=connection.prepareStatement("select * from students");
              ResultSet rs =psmt.executeQuery();
              while(rs.next())
              {
                  //this are both ways 1st by using index and 2nd by using column name
                  System.out.println(rs.getInt("ID")+" "+rs.getString("name")+" "+rs.getString("department"));
//                 System.out.println(rs.getInt(1)+" "+ rs.getString(2)+" " +rs.getString(3)+" "+rs.getString(4));
              }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
}
