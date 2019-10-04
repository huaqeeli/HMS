/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import hms.models.TestModel;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

public class TestClass {

    public static void main(String args[]) {
//        try {
//            ResultSet rs = DataMng.getAllData("formation");
//            ObservableList<TestModel> list = FXCollections.observableArrayList(); 
//            int i = 0;
//             String qurye = null;
//            while(rs.next()){
//                list .add(new TestModel(rs.getString("MILITARYID"), rs.getString("RANK"), rs.getString("NAME")));
//            }
//            for (int j = 0; j < list.size(); j++) {
//                 try {
//                     DataMng.insert("test","`mi`,`rank`,`name`","?,?,?",list,j);
//                     System.out.println(list.get(j).getId()+"  "+list.get(j).getRank()+"  "+list.get(j).getName());
//                 } catch (IOException ex) {
//                     Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
//                 }
//            }
//        } catch (IOException | SQLException ex) {
//            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }

    public static class Task1 extends Thread {

        @Override
        public void run() {
            
           
        }

        public void print() {
            System.out.println("hi hussein");
        }

    }

    public static class Task2 extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("hi hussein");
            } catch (InterruptedException ex) {
                Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
