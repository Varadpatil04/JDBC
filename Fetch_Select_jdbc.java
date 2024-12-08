import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Fetch_Select_jdbc {
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaddb","root","Varad@04");

        PreparedStatement ps =  con.prepareStatement("SELECT * FROM emp; ");


        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getNString("name");
            int sal = rs.getInt("salary");

            System.out.println(id + " " + name + " " + sal);
        }

    }
}
