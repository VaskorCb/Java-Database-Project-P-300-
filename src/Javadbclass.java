
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Javadbclass {
    private static Connection connection=null;
    public static Connection dbclass(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management_project?zeroDateTimeBehavior=convertToNull","root","");
        return connection; 
    }catch(ClassNotFoundException |SQLException e){
        JOptionPane.showMessageDialog(null,e);
        return null;
        
    }
    }
}
