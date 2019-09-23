/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

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
import javafx.stage.FileChooser;

public class TestClass {

    public static void main(String args[]) {
        LocalDate d1 = LocalDate.of(1441, 1, 1);
        LocalDate d2 = LocalDate.of(1441, 1, 30);

        long days = ChronoUnit.DAYS.between(d1, d2);
        System.out.println(days);
    }

    public static class Task1 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("num = " + i);
                Task2 t = new Task2();
                t.start();
            }
            print();
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
