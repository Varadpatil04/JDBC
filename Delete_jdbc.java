import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete_jdbc {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaddb","root","Varad@04");

        PreparedStatement ps =  con.prepareStatement("Delete from emp where id = ? ");
        ps.setInt(1,9);

        int i = ps.executeUpdate();


        if (i>0){
            System.out.println("Succesful deletion");
        }else
        {
            System.out.println("Fail");
        }


    }
}
