import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update_jdbc {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaddb","root","Varad@04");

        PreparedStatement ps =  con.prepareStatement("update emp set name = ? where id = ? ");
        ps.setNString(1,"Kaustubh");
        ps.setInt(2,3);

        int i = ps.executeUpdate();


        if (i>0){
            System.out.println("Succes");
        }else
        {
            System.out.println("Fail");
        }


    }
}
