package hms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javax.swing.JOptionPane;

public  class DataMng {
DatabaseConnector dbcon = new DatabaseConnector();
    public void insertt(String tapleName, String fildName, String valueNamber, String[] data) throws IOException {
        
        Connection con = DatabaseConnector.dbConnector();
        String guiry = "INSERT INTO " + tapleName + "(" + fildName + ")VALUES(" + valueNamber + ")";
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            int e = data.length;
            for (int i = 1; i <= e; i++) {
                psm.setString(i, data[i - 1]);
            }
            int t = psm.executeUpdate();
            if (t > 0) {
            } else {
                JOptionPane.showMessageDialog(null, "حدث خطاء في عملية الحفظ الرجاء المحاولة مرة اخرى");
            }
            con.close();
            psm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public static void insert(String tapleName, String fildName, String valueNamber, String[] data) throws IOException {
        
        Connection con = DatabaseConnector.dbConnector();
        String guiry = "INSERT INTO " + tapleName + "(" + fildName + ")VALUES(" + valueNamber + ")";
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            int e = data.length;
            for (int i = 1; i <= e; i++) {
                psm.setString(i, data[i - 1]);
            }
            int t = psm.executeUpdate();
            if (t > 0) {
            } else {
                JOptionPane.showMessageDialog(null, "حدث خطاء في عملية الحفظ الرجاء المحاولة مرة اخرى");
            }
            con.close();
            psm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void updat(String tapleName, String fildNameAndValue, String[] data, String condition) throws IOException {
        Connection con = DatabaseConnector.dbConnector();
        String guiry = "UPDATE " + tapleName + " SET " + fildNameAndValue + " WHERE" + condition;
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            int e = data.length;
            for (int i = 1; i <= e; i++) {
                psm.setString(i, data[i - 1]);
            }
            int t = psm.executeUpdate();
            if (t > 0) {
                showAlert("", "تم تحديث البيانات", AlertType.INFORMATION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void updat(String tapleName, String fildNameAndValue, String condition) throws IOException {
        Connection con = DatabaseConnector.dbConnector();
        String guiry = "UPDATE " + tapleName + " SET " + fildNameAndValue + " WHERE" + condition;
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            psm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void delete(String tapleName, String condition) throws IOException {
        Connection con = DatabaseConnector.dbConnector();
        String guiry = "DELETE FROM " + tapleName + " WHERE " + condition ;
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            Alert alert = FormValidation.confirmationDilog("تاكيد الحذف", "سوف يتم حذف السجل هل تريد المتابعة");
            if (alert.getResult() == ButtonType.YES) {
                psm.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public static void delete(String quiry) throws IOException {
        Connection con = DatabaseConnector.dbConnector();
        try {
            PreparedStatement psm = con.prepareStatement(quiry);
            Alert alert = FormValidation.confirmationDilog("تاكيد الحذف", "سوف يتم حذف السجل هل تريد المتابعة");
            if (alert.getResult() == ButtonType.YES) {
                psm.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static ResultSet getAllData(String tapleName) throws IOException {
        ResultSet rs = null;
        String guiry = "SELECT * FROM " + tapleName;
        Connection con = DatabaseConnector.dbConnector();
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            rs = psm.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
    
    public static ResultSet getAllQuiry(String quiry) throws IOException {
        ResultSet rs = null;
//        String guiry = "SELECT * FROM " + tapleName;
        Connection con = DatabaseConnector.dbConnector();
        try {
            PreparedStatement psm = con.prepareStatement(quiry);
            rs = psm.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }

    public static ResultSet getDataWithCondition(String tapleName, String fildName, String condition) throws IOException {
        ResultSet rs = null;
        String guiry = "SELECT " + fildName + " FROM " + tapleName + " WHERE" + condition;
        Connection con = DatabaseConnector.dbConnector();
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            rs = psm.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }

    public static ResultSet getDataJoinTable( String guiry) throws IOException {
        ResultSet rs = null;
       
//        String guiry = "SELECT " + fildName + " FROM " + firstTaple + "," + secondTaple + "WHERE" + condition;
//        String guiry = "select nameslist.MILITARYID,nameslist.ENDATEFROM,nameslist.ENDATETO, formation.NAME, formation.RANK from nameslist ,formation  where  nameslist.MILITARYID = formation.MILITARYID  AND nameslist.LISTNUMBER = '1473';";
        Connection con = DatabaseConnector.dbConnector();
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            rs = psm.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
    public static ResultSet getSequenceOfRow(String tableName) throws IOException {
        ResultSet rs = null;
        String guiry = "SELECT (@row:=@row+1) AS n FROM '"+tableName+"', (SELECT @row := 0) r order by id desc;";
        Connection con = DatabaseConnector.dbConnector();
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            rs = psm.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }

    public static boolean checkEmpty(String text) {
        boolean state = false;
        if (text.isEmpty()) {
            state = true;
        } else {
            state = false;
        }
        return state;
    }

    public static void showAlert(String titel, String massage, AlertType t) {
        Alert alert = new Alert(t);
        alert.setTitle(titel);
        alert.setHeaderText(null);
        alert.setContentText(massage);
        alert.showAndWait();
    }

    public static void showAlert(String titel, String massage) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titel);
        alert.setHeaderText(null);
        alert.setContentText(massage);
        alert.showAndWait();
    }

}
