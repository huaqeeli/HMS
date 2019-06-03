package hms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DataMng {

    public static void insert(String tapleName, String fildName,String valueNamber, String [] data ) {
        Connection con = DatabaseConnector.dbConnector();
//        String guiry = "INSERT INTO '" + tapleName + "'('" + fildName + "')VALUES('"+valueNamber+"')";
        String guiry = "INSERT INTO entdabat (ORDERID,ORDERDATE,ENFROM,ENTO,ENDATEFROM,ENDATETO,ENPLASE,MILITARYTAYP,ENTAYP) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
//            int e = data.length;
             psm.setString(1, data[0]);
             psm.setString(2, "1440-10-12");
             psm.setString(3, data[2]);
             psm.setString(4, data[3]);
             psm.setString(5, "1440-02-10");
             psm.setString(6, "1440-02-25");
             psm.setString(7, data[6]);
             psm.setString(8, data[7]);
             psm.setString(9, data[8]);
//             psm.executeQuery();
             int e = data.length;
            for(int i =1 ; i<=e;i++){
                System.out.println(data[i-1]);
            }
            int t = psm.executeUpdate();
            if(t>0){
              JOptionPane.showMessageDialog(null,"تم حفظ البيانات");
            }else{
              JOptionPane.showMessageDialog(null,"حدث خطاء في عملية الحفظ الرجاء المحاولة مرة اخرى");
            }
            con.close();
            psm.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataMng.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
