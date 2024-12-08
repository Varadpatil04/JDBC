import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Insert_Jdbc {
    public static void main(String[] args) throws Exception {

        // 1st Step
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2nd Step
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaddb","root","Varad@04");

        //3rd Step
        PreparedStatement ps =  con.prepareStatement("INSERT INTO emp (id,name,salary) VALUES (?,?,?)");
        ps.setInt(1,9);
        ps.setNString(2,"aadha");
        ps.setInt(3,1212);
        //4th Step
        int i = ps.executeUpdate();


        if (i>0){
            System.out.println("Succes");
        }else
        {
            System.out.println("Fail");
        }


    }
}
//    jdbc:mysql://127.0.0.1:3306/?user=root