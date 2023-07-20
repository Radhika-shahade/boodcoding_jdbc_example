package bootcoding.jdbc.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DaoService {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement psmt=null;
        PatientService psv= new PatientService();

        try {
            List<Patient>data=psv.buildRecord(100);
            Class.forName("org.postgresql.Driver");
            for(int i=0;i< data.size();i++) {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Admin");
                psmt = connection.prepareStatement("insert into hospitaldb values (?,?,?,?,?,?)");
                    Patient value= data.get(i);
                    psmt.setInt(1,value.getId());
                    psmt.setString(2, value.getName());
                psmt.setString(3,value.getDisease());
                psmt.setInt(4,value.getMobile_number());
                    psmt.setString(5, value.getCity());
                    psmt.setString(6,value.getEmail_id());
//                    psmt.setBoolean(7,value.is_cure);
                    int insert=psmt.executeUpdate();
                    if(insert==1)
                    {
                        System.out.println(insert +" record inserted");
                    }
                    else {
                        System.out.println("failed to insert record");
                    }


          }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (SQLException e)
        {
           e.printStackTrace();
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
