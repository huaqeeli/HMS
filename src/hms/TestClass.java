/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.text.ParseException;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAmount;
import java.util.Calendar;
import org.joda.time.LocalDate;
import org.joda.time.chrono.IslamicChronology;
import org.joda.time.chrono.ISOChronology;

public class TestClass {

    public static void main(String args[]) {

//        HijrahDate date = HijrahChronology.INSTANCE.date(1441, 8, 10);
//        int monthLength = date.lengthOfMonth();
//        int addedDays = 125;
//
//        String gdate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//        String[] parts = gdate.split("-");
//        int day = Integer.parseInt(parts[0]);
//        int month = Integer.parseInt(parts[1]);
//        int year = Integer.parseInt(parts[2]);
//        int diff = monthLength - day;
//        if (addedDays < 30) {
//            if (diff < addedDays) {
//                day = addedDays - diff;
//                month++;
//            } else {
//                day = day + addedDays;
//            }
//        } else if (addedDays > 30 && addedDays < 360) {
//            int themonth = addedDays / 30;
//            int theday = themonth * 30;
//            theday = addedDays - theday;
//            month = month + themonth;
//            day = day + theday;
//        }
//        System.out.println(date.getEra());
//        System.out.println(day + "/" + month + "/" + year);
        System.out.println(plucDays("1441", "08", "12", 490));
    }

    public static String plucDays(String year, String month, String day, int addedDays) {
        String returnDate = null;
        HijrahDate date = HijrahChronology.INSTANCE.date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        int monthLength = date.lengthOfMonth();
        String gdate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String[] parts = gdate.split("-");
        date.getEra();
        int intday = Integer.parseInt(parts[0]);
        int intmonth = Integer.parseInt(parts[1]);
        int intyear = Integer.parseInt(parts[2]);
        int diff = monthLength - intday;
        if (addedDays < 30) {
            if (diff < addedDays) {
                intday = addedDays - diff;
                intmonth++;
            } else {
                intday = intday + addedDays;
            }
        } else if (addedDays > 30 && addedDays < 360) {
            int themonth = addedDays / 30;
            int theday = themonth * 30;
            theday = addedDays - theday;
            intmonth = intmonth + themonth;
            intday = intday + theday;
        } else {
            int theyear = addedDays / 360;
            int themonth = theyear * 360;
            themonth = addedDays - themonth;
            addedDays = themonth;
            themonth =  themonth / 30;
            int theday  = themonth * 30;
            theday = addedDays - theday;
            intmonth = intmonth + themonth;
            intday = intday + theday;
            intyear = intyear + theyear;
        }
        returnDate = Integer.toString(intday) + "-" + Integer.toString(intmonth) + "-" + Integer.toString(intyear);
        return returnDate;
    }
}
