
package hms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DatabaseConnector {

    private static Connection con;

    public static Connection dbConnector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdatabase?useUnicode=yes&characterEncoding=UTF-8", "root", "root");
        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,ex);
        }
        return con;
    }
}
