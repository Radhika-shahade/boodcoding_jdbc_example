package bootcoding.jdbc.hospital;

import java.sql.*;

public class FetchData3 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement psmt= null;

        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Admin");
            psmt=connection.prepareStatement("select  * from hospitaldb h where (Discharge_Date) = '2022-04-13' ");
//            psmt.setDate(1,);
            ResultSet rs = psmt.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
                        + rs.getInt(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getDate(7) +
                        " " + rs.getDate(8) + " " + rs.getBoolean(9));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }finally {
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
