/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ابو ريان
 */
public class TestClass {

    public static void main(String args[]) {
//        boolean trainingUnique = FormValidation.unique("training", "`MILITARYID`", " `MILITARYID` = '352839'", "لديه دورة  خلال فترة الانتداب الحالية");
        try {
            ResultSet rs = DataMng.getDataWithCondition("training", "`MILITARYID`", " `MILITARYID` = '352839' AND `COURSESTARTDATE` >='1440-07-15' AND `COURSENDDATE` <= '1441-01-20' ");
            if (rs.next()) {
                System.out.println("تمام");
            }else{
            System.out.println("ماشي");
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
//        if (trainingUnique) {
//            System.out.println("");
//        }
       
    }

}
