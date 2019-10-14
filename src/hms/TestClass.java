/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import org.joda.time.LocalDate;
import org.joda.time.chrono.IslamicChronology;
import org.joda.time.chrono.ISOChronology;

public class TestClass {

    public static void main(String args[]) {
//        HijrahDate date = HijrahChronology.INSTANCE.date(1441, 02, 15);
//        System.out.println(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//        System.out.println(IsoChronology.INSTANCE.date(date));
//        java.time.LocalDate date1 = IsoChronology.INSTANCE.date(date).plusDays(15);
//        
//        
//        String gdate = date1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//        System.out.println(gdate);
//        ISOChronology iso = ISOChronology.getInstanceUTC();
//        IslamicChronology hijri = IslamicChronology.getInstanceUTC();
////        int x = getDay("2019");
//
////        LocalDate todayIso = new LocalDate(x, 3, 31, iso);
//        LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(), hijri);
//        System.out.println(todayHijri); // 1434-05-19
    }
     private int getDay(String date) {
        int day = 0;
        if (date != null) {
            String[] parts = date.split("-");
            day = Integer.parseInt(parts[2]);
        }
        return day;
    }
     private String getMonth(String date) {
        String month = null;
        if (date != null) {
            String[] parts = date.split("-");
            month = parts[1];
        }
        return month;
    }

    private String getYear(String date) {
        String year = null;
        if (date != null) {
            String[] parts = date.split("-");
            year = parts[0];
        }
        return year;
    }
}
