package bootcoding.jdbc;

import java.sql.*;
import java.util.Random;

public class JDBCPrepareInsertExample {
    public static void main(String[] args) {

        Connection connection=null;
        PreparedStatement ps=null;

        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Admin");


            ps=connection.prepareStatement("INSERT INTO students values(?,?,?,?)");
            ps.setInt(1, 4);
            ps.setString(2, "RajLaxmi");
            ps.setString(3, "Delhi");
            ps.setString(4, "CS");
            int insert = ps.executeUpdate();
            if(insert == 1){
                System.out.println("Successfully Inserted!");
            }else{
                System.err.println("Failed to Insert Record ");
            }
//            int n=statement.executeUpdate("insert into ftab values(1144,'RAJU',3000,30)");
//            System.out.println(n+" :Rows Inserted ");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
