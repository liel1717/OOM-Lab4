package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime datetest = new DateTime(2018, 10, 4, 15, 14, 0);
		DateTime newDate;
		newDate = TimeZoneTranslator.shiftTimeZone(datetest, 1, 2);
		DateTime resultDate = new DateTime(2018, 10, 4, 16, 14, 0);
		
		assertEquals(newDate.toString(), resultDate.toString());
;	}

	@Test
	public void testShiftEventTimeZone() {
		DateTime start = new DateTime(2018, 10, 4, 15, 35, 0);
		
		// skall byta datum rätt
		DateTime end = new DateTime(2018, 12, 31, 23, 0,0);
		Person elias = new Person("Elias Lindh");
		Person robin = new Person("Robin Briland");
		Place HC218 = new Place("Hc218",57.7785672,14.1614833,20.0);
		
		Event firstEvent = new Event("OOM 2018 Deadline!", start, end,new HashSet<>(Arrays.asList(elias, robin)), HC218);
		DateTime startDate = new DateTime(2018, 10, 04, 23, 35, 00);
		
		Event newEvent = TimeZoneTranslator.shiftEventTimeZone(firstEvent, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.JAPAN);
		
		assertEquals(startDate.toString(), newEvent.getStartDate().toString());
	}
	
	
	@Test
	public void testDateTime() {
	
		DateTime testDateTime = new DateTime(2018, 10, 10, 10, 0, 0);
		DateTime testDateTimeString = new DateTime("2018-10-10 10:00:00");
		String s = "2018-10-10 10:00:00";
		
		System.out.println(s + "\n" + testDateTime.toString());
		assertEquals(s , testDateTime.toString());
		assertEquals(testDateTimeString.toString(), testDateTime.toString());
		
		
		
	}

}
