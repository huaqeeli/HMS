/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class TestClass {

    public static void main(String args[]) {
        try {
            Connection con = DatabaseConnector.dbConnector();
            PreparedStatement psm = con.prepareStatement("DELETE FROM vacation");
            psm.executeUpdate();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
