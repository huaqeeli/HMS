/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClass {

    public static void main(String args[]) {
        Task1 t = new Task1();
        Task2 t2 = new Task2();
        t.start();
      
    }

    public static class Task1 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("num = " + i);
            }
             print();
        }
        public void print(){
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
