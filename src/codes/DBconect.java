package codes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBconect {

    public static Connection connect(){

        Connection conn = null;
  
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return conn;
    
    }
    
}

