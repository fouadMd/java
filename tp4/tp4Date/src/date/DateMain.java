package date;
import date.*;
import date.util.*;

/**
 *@author Medjahed Fouad Ainouch Tarik
 */


 /**
  *main of Date
  */
public class DateMain {


    public static void main(String[] args) {

  Date d = new Date(1,Month.february, 2019);
  Date d1 = new Date(1,Month.january, 2019);
  Date d2 = new Date(28,Month.february, 2019);
  Date d3 = new Date(30,Month.may, 2020);

  System.out.println("d : "+ d.toString());
	System.out.println("the date of tomorrow is: "+ d.tomorrow());
	System.out.println("the date is "+ d.DateinNDays(365)+" after 365 days");
  System.out.println("the date is "+ d.DateinNDays(31)+" after 31 days");
	System.out.println("the numbers of days between "+d1+" and "+d+" is: "+d1.differenceInDays(d));
  System.out.println("the numbers of days between "+d2+" and "+d3+" is: "+d2.differenceInDays(d3));

    }
}
