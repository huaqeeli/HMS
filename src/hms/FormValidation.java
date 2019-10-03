package hms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class FormValidation {

    public static boolean textFieldNotEmpty(TextField t) {
        boolean state = false;

        if (t.getText() != null && !t.getText().isEmpty()) {
            state = true;
        }

        return state;
    }

    public static boolean textFieldNotEmpty(TextField t, String validationmassage) {
        boolean state = true;
        if (!textFieldNotEmpty(t)) {
            state = false;
            t.setPromptText(validationmassage);
            t.setStyle(" -fx-border-color: #DC4D41; -fx-background-color:#F8DCDA");
        } else {
            t.setStyle(" -fx-border-color: #117E88;-fx-background-color:#FFFFFF");
        }

        return state;
    }

    public static boolean comboBoxNotEmpty(ComboBox t) {
        boolean state = false;

        if (t.getValue() != null && !t.getValue().equals("")) {
            state = true;
        }

        return state;
    }

    public static boolean comboBoxNotEmpty(ComboBox t, String validationmassage) {
        boolean state = true;
        if (!comboBoxNotEmpty(t)) {
            state = false;
            t.setPromptText(validationmassage);
            t.setStyle(" -fx-border-color: #DC4D41; -fx-background-color:#F8DCDA");
        } else {
            t.setStyle(" -fx-border-color: #117E88;-fx-background-color:#FFFFFF");
        }

        return state;
    }

    public static boolean textFieldTypeDate(TextField t) {
        boolean state = false;

        if (t.getText().matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)")) {
            state = true;
        }

        return state;
    }

    public static boolean textFieldTypeDate(TextField t, String validationmassage) {
        boolean state = true;
        if (!textFieldTypeDate(t)) {
            state = false;
            t.setPromptText(validationmassage);
            t.setStyle(" -fx-border-color: #DC4D41; -fx-background-color:#F8DCDA");
        } else {
            t.setStyle(" -fx-border-color: #117E88;-fx-background-color:#FFFFFF");
        }

        return state;
    }

    public static boolean textFieldTypeNumber(TextField t) {
        boolean state = false;

        if (t.getText().matches("([0-9]+(\\.[0-9]+)?)+")) {
            state = true;
        }

        return state;
    }

    public static boolean textFieldTypeNumber(TextField t, String validationmassage) {
        boolean state = true;
        if (!textFieldTypeNumber(t)) {
            state = false;
            t.setText("");
            t.setPromptText(validationmassage);
            t.setStyle(" -fx-border-color: #DC4D41; -fx-background-color:#F8DCDA");
        } else {
            t.setStyle(" -fx-border-color: #117E88;-fx-background-color:#FFFFFF");
        }

        return state;
    }

    public static Alert confirmationDilog(String titel, String massage) {
        Alert alert = new Alert(AlertType.CONFIRMATION, massage, ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.setTitle(titel);
        alert.setHeaderText(null);
        alert.showAndWait();
        return alert;
    }

    public static void showAlert(String titel, String massage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titel);
        alert.setHeaderText(null);
        alert.setContentText(massage);
        alert.showAndWait();
    }

    // Alert alert = new Alert(AlertType.CONFIRMATION, "سوف يتم حذف السجل هل تريد المتابعة", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
    public static void showAlert(String titel, String massage, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(titel);
        alert.setHeaderText(null);
        alert.setContentText(massage);
        alert.showAndWait();
    }

    public static boolean transporState(String tapleName, String fildName, String condition, String validationmassage) {
        boolean state = true;
        try {

            ResultSet rs = null;
            String guiry = "SELECT " + fildName + " FROM " + tapleName + " WHERE" + condition;
            Connection con = DatabaseConnector.dbConnector();
            try {
                PreparedStatement psm = con.prepareStatement(guiry);
                rs = psm.executeQuery();
                if (rs.next()) {
                    state = false;
                    showAlert("التحقق من التكرار", validationmassage);
                }
                con.close();
                psm.close();
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(FormValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }
    public static boolean unique(String tapleName, String fildName, String condition, String validationmassage) {
        boolean state = true;
        try {

            ResultSet rs = null;
            String guiry = "SELECT " + fildName + " FROM " + tapleName + " WHERE" + condition;
            Connection con = DatabaseConnector.dbConnector();
            try {
                PreparedStatement psm = con.prepareStatement(guiry);
                rs = psm.executeQuery();
                if (rs.next()) {
                    state = false;
                    showAlert("التحقق من التكرار", validationmassage);
                }
                con.close();
                psm.close();
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(FormValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }

    public static boolean unique(String tapleName, String fildName, String condition, String validationmassage, ObservableList reason, String militeryid, String listnumber) {
        boolean state = true;
        try {

            ResultSet rs = null;
            String guiry = "SELECT " + fildName + " FROM " + tapleName + " WHERE" + condition;
            Connection con = DatabaseConnector.dbConnector();
            try {
                PreparedStatement psm = con.prepareStatement(guiry);
                rs = psm.executeQuery();
                if (rs.next()) {
                    state = false;
                    showAlert("التحقق من التكرار", validationmassage);
                    reason.addAll(listnumber, militeryid, validationmassage);
                }
                con.close();
                psm.close();
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(FormValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }

    public static boolean dateChaking(String tapleName, String fildName, String condition, String validationmassage, String militeryid, String listnumber, String date1, String date2) {
        boolean state = true;
        try {
            ResultSet rs = null;
            String guiry = "SELECT " + fildName + " FROM " + tapleName + " WHERE" + condition;
            Connection con = DatabaseConnector.dbConnector();
            try {
                PreparedStatement psm = con.prepareStatement(guiry);
                psm.setString(1, militeryid);
                psm.setString(2, date1);
                psm.setString(3, date2);
                psm.setString(4, date1);
                psm.setString(5, date2);
                rs = psm.executeQuery();
                if (rs.next()) {
                    state = false;
                    showAlert("رسالة تحقق", validationmassage);
                    try {
                        String[] excluded = {listnumber, militeryid};
                        String[] reasons = {listnumber, militeryid, validationmassage};
//                        DataMng.insert("excluded", "`LISTNUMBER`,`MILITARYID`", "?,?", excluded);
                        DataMng.insert("exclusionmessage", "`LISTNUMBER`,`MILITARYID`,`REASON`", "?,?,?", reasons);
                    } catch (IOException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                con.close();
                psm.close();
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(FormValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }
    public static boolean dateAllChaking(String tapleName, String fildName, String condition, String validationmassage, String militeryid, String listnumber, String date1, String date2) {
        boolean state = true;
        try {
            ResultSet rs = null;
            String guiry = "SELECT " + fildName + " FROM " + tapleName + " WHERE" + condition;
            Connection con = DatabaseConnector.dbConnector();
            try {
                PreparedStatement psm = con.prepareStatement(guiry);
                psm.setString(1, militeryid);
                psm.setString(2, date1);
                psm.setString(3, date2);
                psm.setString(4, date1);
                psm.setString(5, date2);
                rs = psm.executeQuery();
                if (rs.next()) {
                    state = false;
                    try {
                        String[] reasons = {listnumber, militeryid, validationmassage};
                        DataMng.insert("exclusionmessage", "`LISTNUMBER`,`MILITARYID`,`REASON`", "?,?,?", reasons);
                    } catch (IOException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                con.close();
                psm.close();
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(FormValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }

    public static boolean checkDate(String date1, String date2) {
        boolean state = true;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date11 = (Date) sdf.parse(date1);
            Date date22 = (Date) sdf.parse(date2);
            if (date11.compareTo(date22) > 0) {
                state = false;
            }
        } catch (ParseException ex) {
            Logger.getLogger(FormValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }
//    public static boolean checkDate (String date1 ,String date2 ,String message){
//     boolean state = false;
//     if(!checkDate(date1,date2)){
//       state = true;
//       FormValidation.showAlert("", message, AlertType.WARNING);
//     }
//        return state;
//    }

    public static boolean checkDate(int year1, int month1, int day1, int year2, int month2, int day2, String message) {
        boolean state = true;
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();

        cal1.set(year1, month1, day1);
        cal2.set(year2, month2, day2);
        int d = daysBetween(cal1.getTime(), cal2.getTime());
        if (d <= 0) {
            state = false;
            FormValidation.showAlert("", message, AlertType.WARNING);
        }
        return state;
    }

    public static int daysBetween(java.util.Date d1, java.util.Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static String creatList(int lastnumber) {
        String newList = null;
        newList = Integer.toString(lastnumber + 1);
        return newList;
    }
}
