
package hms;

import java.util.*;

public class DateDifference {
    public static void main(String args[]){
        boolean DateDifference = DateDifference(Integer.parseInt("1440"),Integer.parseInt("12"),Integer.parseInt("12"),Integer.parseInt("1441"),Integer.parseInt("11"),Integer.parseInt("12"));
    }

    public static boolean DateDifference(int year1, int month1, int day1, int year2, int month2, int day2) {
        boolean state = true;
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();

//        cal1.set(1440, 07, 10); 
//        cal2.set(1440,06, 11);
         cal1.set(year1, month1, day1);
        cal2.set(year2, month2, day2);
        int d = daysBetween(cal1.getTime(),cal2.getTime());
        System.out.println(d);
        if (d<0){
            state = false;
            System.out.println("تاريخ النهاية اقل من البداية");
        }
        System.out.println(state);
        return state;
    }

    public static int daysBetween(Date d1, Date d2) {
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
