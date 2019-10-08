package hms;

import hms.models.CheckAllDataModel;
import hms.models.NamesDataModel;
import hms.models.TestModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javax.swing.JOptionPane;

public class DataMng {

    public static void insertPassData(String tapleName, String fildName, String valueNamber, ObservableList<CheckAllDataModel> data, int x) throws IOException {
        Connection con = DatabaseConnector.dbConnector();
        String guiry = "INSERT INTO " + tapleName + "(" + fildName + ")VALUES(" + valueNamber + ")";
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            psm.setString(1, data.get(x).getMilitaryId());
            psm.setString(2, data.get(x).getListNumber());
            psm.setString(3, data.get(x).getEnForm());
            psm.setString(4, data.get(x).getEnTo());
            psm.setString(5, data.get(x).getFromDate());
            psm.setString(6, data.get(x).getToDate());

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

    public static void insertExcludedData(String tapleName, String fildName, String valueNamber, ObservableList<CheckAllDataModel> data, int x) {
        try {
            Connection con = DatabaseConnector.dbConnector();
            String guiry = "INSERT INTO " + tapleName + "(" + fildName + ")VALUES(" + valueNamber + ")";

            PreparedStatement psm = con.prepareStatement(guiry);
            psm.setString(1, data.get(x).getListNumber());
            psm.setString(2, data.get(x).getMilitaryId());
            int t = psm.executeUpdate();
            if (t > 0) {
            } else {
                JOptionPane.showMessageDialog(null, "حدث خطاء في عملية الحفظ الرجاء المحاولة مرة اخرى");
            }
            con.close();
            psm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataMng.class.getName()).log(Level.SEVERE, null, ex);
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
    }//SELECT * FROM hmsdatabase.formation where MILITARYID = '350969'

    public static void insert(String quiry, String militaryid) throws IOException {

        Connection con = DatabaseConnector.dbConnector();
//        String guiry = "INSERT INTO " + tapleName + "(" + fildName + ") SELECT " + fildName + "FROM" + secondtableName + "`WHERE`" + condition;

        try {
            PreparedStatement psm = con.prepareStatement(quiry);
            psm.setString(1, militaryid);
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
        String guiry = "DELETE FROM " + tapleName + " WHERE " + condition;
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

    public static void deleteEmployeeData(String tapleName, String condition) throws IOException {
        Connection con = DatabaseConnector.dbConnector();
        String guiry = "DELETE FROM " + tapleName + " WHERE " + condition;
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            psm.executeUpdate();
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

    public static ResultSet getDataJoinTable(String guiry) throws IOException {
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
        String guiry = "SELECT (@row:=@row+1) AS n FROM '" + tableName + "', (SELECT @row := 0) r order by id desc;";
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
