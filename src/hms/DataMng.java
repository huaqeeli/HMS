package hms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DataMng {

    public static void insert(String tapleName, String fildName,String valueNamber, String [] data ) {
        Connection con = DatabaseConnector.dbConnector();
       String guiry = "INSERT INTO " + tapleName + "(" + fildName + ")VALUES("+valueNamber+")";
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
             int e = data.length;
            for(int i =1 ; i<=e;i++){
                psm.setString(i,data[i-1]);
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
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public static ResultSet getAllData(String tapleName){
       ResultSet rs = null;
       String guiry = "SELECT * FROM " + tapleName ;
       Connection con = DatabaseConnector.dbConnector();
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            rs=psm.executeQuery();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
    public static ResultSet getDataWithCondition(String tapleName, String fildName,String condition){
       ResultSet rs = null;
       String guiry = "SELECT "+fildName+" FROM " +tapleName+ " WHERE" + condition ;
       Connection con = DatabaseConnector.dbConnector();
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            rs=psm.executeQuery();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
System.out.print(guiry);
        return rs;
    }
}
