package bootcoding.jdbc.projector.dao;

import bootcoding.jdbc.projector.model.Projector;
import bootcoding.jdbc.projector.service.ProjectorService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DaoService {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps= null;
        Projector projector= new Projector();
        ProjectorService psv= new ProjectorService();


        try {
            List<Projector> projectorList= psv.buildRecord(100);
            Class.forName("org.postgresql.Driver");
            for (int i = 0; i < 100; i++) {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Admin");
                ps = connection.prepareStatement("insert into projector values(?,?,?)");

                Projector value = projectorList.get(i);
                ps.setString(1, value.getCompanyName());
                ps.setString(2, value.getColour());
                ps.setInt(3, value.getPrice());

                int insert=ps.executeUpdate();
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
}
