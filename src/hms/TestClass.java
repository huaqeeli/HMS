package hms;

import java.text.DecimalFormat;

public class TestClass {

    public static void main(String args[]) {

        Double amount = 5356673553123.0; //amount is an example ,can be used with any double value

       DecimalFormat IndianCurrencyFormat = new DecimalFormat("##,##,###.00"); 
       
       String formattedAmount = IndianCurrencyFormat.format(amount);
        System.out.println(formattedAmount);
        
    }
}
