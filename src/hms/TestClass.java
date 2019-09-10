/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClass extends Thread{

    public static void main(String args[]) {
        try {
            ResultSet rs = DataMng.getAllData("formation");
             String[] data = new String[2];
             
            while (rs.next()) {
                System.out.println(rs.getString("MILITARYID")+" ---- " + rs.getString("NAME"));
                data[0] = rs.getString("MILITARYID");
                data[1] = rs.getString("NAME");
                DataMng.insert("TEST", "mi,name", "?,?", data);
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
