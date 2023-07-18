package bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class JDBCPreparedStatementEx2 {
    public static void main(String[] args) {
        Connection connection= null;
        PreparedStatement ps=null;
        try {
            Class.forName("org.postgresql.Driver");

            for (int i = 1; i < 100; i++) {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Admin");

                ps = connection.prepareStatement("INSERT INTO students values(?,?,?,?)");
                ps.setInt(1, 100 + i);
                ps.setString(2, getNames());
                ps.setString(3, getCityNames());
                ps.setString(4, "EE");
                int insert = ps.executeUpdate();
                if (insert == 1) {
                    System.out.println("Successfully Inserted, id = " + (+ i));
                }
                else
                {
                    System.err.println("Failed to Insert Record ");
                }
            }
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
    private static String[] names =
            {"Ramesh", "Suresh", "Jayesh", "Ganesh",
                    "Mahesh", "Rajesh", "Mitesh", "Dinesh",
                    "Pooja", "Priya", "Pinky",
                    "Manisha", "Usha", "Asha", "Diksha", "Nisha"};
    public static String getNames()
    {
        Random random= new Random();
        int randomindex= random.nextInt(names.length);
        return names[randomindex];

    }
    private static String cityNames[]=
    {"Nagpur","Mumbai","Delhi","Amravati","Hyderabad","Bangalore"};
    private static  String getCityNames()
    {
        Random random= new Random();
        int index =random.nextInt(cityNames.length);
        return cityNames[index];
    }

}

