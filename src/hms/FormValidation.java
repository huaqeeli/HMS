package hms;

import hms.models.NamesDataModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Predicate;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
        
        if (t.getValue()!= null && !t.getValue().equals("")) {
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
    
    public static void showAlert(String titel, String massage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titel);
        alert.setHeaderText(null);
        alert.setContentText(massage);
        alert.showAndWait();
    }
    
    public static boolean unique(String tapleName, String fildName, String condition, String validationmassage) {
        boolean state = false;
        ResultSet rs = null;
        String guiry = "SELECT " + fildName + " FROM " + tapleName + " WHERE" + condition;
        Connection con = DatabaseConnector.dbConnector();
        try {
            PreparedStatement psm = con.prepareStatement(guiry);
            rs = psm.executeQuery();
            if (rs.next()) {
                state = true;
                showAlert("التحقق من التكرار", validationmassage);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return state;
    }
    
    public static String creatList(int lastnumber){
      String newList = null;
      newList =Integer.toString(lastnumber + 1)  ;
        return newList;
    }
}
