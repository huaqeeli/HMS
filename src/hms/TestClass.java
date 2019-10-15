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

        HijrahDate date = HijrahChronology.INSTANCE.date(1441, 02, 10);
        int c = date.lengthOfMonth();
        int ad = 20;
        String gdate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String[] parts = gdate.split("-");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        if (ad < 30) {
            if ((c - ad) > ad) {
                day = day + ad;
            } else {
                day = day + (c - day);
            }
        }
        System.out.println(day + "/" + month + "/" + year);
//        java.time.LocalDate date1 = IsoChronology.INSTANCE.date(date);
//        
        System.out.println(c);
//        ISOChronology iso = ISOChronology.getInstanceUTC();
//        IslamicChronology hijri = IslamicChronology.getInstanceUTC();
//       
//        int day = Integer.parseInt(parts[0]);
//        int month = Integer.parseInt(parts[1]);
//        int year = Integer.parseInt(parts[2]);
////        
//        LocalDate todayIso = new LocalDate(year, month, day+1, iso);
//        LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(), hijri);
//        System.out.println(todayHijri); 
    }
}
