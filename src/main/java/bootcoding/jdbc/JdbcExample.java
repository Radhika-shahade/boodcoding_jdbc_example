package bootcoding.jdbc;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {

        try{
            fetchAllRecords();
            getTotalCount();
            getRecordsBy("Ramesh");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private static void getTotalCount() throws ClassNotFoundException,SQLException
    {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Admin");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM APP_CUSTOMER");

        if(resultSet.next()){
            int count = resultSet.getInt("count");
            System.out.println("Total Records in APP_CUSTOMER is " + count);
        }
        connection.close();
    }
    private static void fetchAllRecords() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Admin");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM APP_CUSTOMER");

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String user = resultSet.getString("name");
            String pwd = resultSet.getString("address");
            long phone_number = resultSet.getLong("phone_number");
            String role = resultSet.getString("email_id");
            System.out.println("Id = " + id);
            System.out.println("user = " + user);
            System.out.println("Address = "+ pwd);
            System.out.println("Email Id = " + role);
            System.out.println("Phone = " + phone_number);
        }
        connection.close();
    }

    private static void getRecordsBy(String name)throws ClassNotFoundException, SQLException{
        Class.forName("org.postgres.sql");
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres\", \"postgres\", \"postgres");
        Statement statement= connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT COUNT (*) FROM APP_CUSTOMER WHERE name='" +name+"'");

        if(resultSet.next())
        {
         int count= resultSet.getInt("count");
            System.out.println("Total Records in APP_CUSTOMER is " + count);
        }
        connection.close();
    }


}
