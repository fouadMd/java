import org.junit.*;
import static org.junit.Assert.*;

import date.util.*;


public class DateTest {

	@Test
	public void testTomorrow() {
		// nothing particular
		Date d = new Date(11, Month.february, 2019);
		Date e = new Date(12, Month.february, 2019);
		assertEquals(d.tomorrow() , e);
		// last day of the month
		d = new Date(31, Month.january, 2019);
		e = new Date(1, Month.february, 2019);
		assertEquals(d.tomorrow() , e);
		//last day of the year
		d = new Date(31, Month.december, 2018);
		e = new Date(1, Month.january, 2019);
		assertEquals(d.tomorrow() , e);
		//special cases of february
		// 1) for a non leap year
		d = new Date(28, Month.february, 2019);
		e = new Date(1, Month.march, 2019);
		assertEquals(d.tomorrow() , e);
		// 2) for a leap year
		d = new Date(28, Month.february, 2020);
		e = new Date(29, Month.february, 2020);
		assertEquals(d.tomorrow() , e);
	}


	@Test
  public void testDateinNDays() {
        Date d1 = new Date(14,Month.february,2018);
        assertEquals(d1.DateinNDays(30),new Date(16,Month.march,2018));
        assertEquals(d1.DateinNDays(365),new Date(14,Month.february,2019));
}
	
	@Test
   public void testNDaysLaterWhenOk(){
	Date d = new Date(11, Month.february, 2019);
	Date e = d.DateinNDays(10);
	assertEquals(e,new Date(21, Month.february, 2019));

	


  }
  @Test
  public void testdifferenceInDays() {
    Date d1 = new Date(14,Month.february,2018);
    Date d2 = new Date(28,Month.february,2018);
    assertEquals(14,d1.differenceInDays(d2));
    Date d3 = new Date(2,Month.march,2018);
    assertEquals(16,d1.differenceInDays(d3));
    Date d4 = new Date(14,Month.february,2019);
    assertEquals(365,d1.differenceInDays(d4));



  }
 public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(DateTest.class);
  }
  }

