package hms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
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
        }
        showAlert("رسالة تحقق", validationmassage);
        return state;
    }

    public static void showAlert(String titel, String massage) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
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
            } else {
                state = false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        showAlert("التحقق من التكرار", validationmassage);
        return state;
    }
}
