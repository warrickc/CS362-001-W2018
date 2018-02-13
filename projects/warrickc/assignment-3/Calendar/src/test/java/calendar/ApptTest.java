package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {

    // Test that the get methods work as expected.
		@Test
		public void test01()  throws Throwable  {
			int startHour=12;
			int startMinute=30;
			int startDay=5;
			int startMonth=03;
			int startYear=2018;
			String title="Appointment Title";
			String description="Appointment Description";

			// Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			// assertions
			assertTrue(appt.getValid());
			assertEquals(12, appt.getStartHour());
			assertEquals(30, appt.getStartMinute());
			assertEquals(5, appt.getStartDay());
			assertEquals(03, appt.getStartMonth());
			assertEquals(2018, appt.getStartYear());
			assertEquals("Appointment Title", appt.getTitle());
			assertEquals("Appointment Description", appt.getDescription());
		}

		// Testing isValid for hour.
		@Test
		public void test02()  throws Throwable  {
			int startHour=-1; // This is now invalid.
			int startMinute=30;
			int startDay=15;
			int startMonth=01;
			int startYear=2018;
			String title="Appointment Title";
			String description="Appointment Description";

			// Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			// assertions
			assertFalse(appt.getValid());
		}

		// Testing isValid for minute.
		@Test
		public void test03()  throws Throwable  {
			int startHour=5;
			int startMinute=-1; // This is now invalid.
			int startDay=15;
			int startMonth=01;
			int startYear=2018;
			String title="Appointment Title";
			String description="Appointment Description";

			// Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			// assertions
			assertFalse(appt.getValid());
		}

		// Testing isValid for day.
		@Test
		public void test04()  throws Throwable  {
			int startHour=5;
			int startMinute=30;
			int startDay=-1; // This is now invalid.
			int startMonth=01;
			int startYear=2018;
			String title="Appointment Title";
			String description="Appointment Description";

			// Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			// assertions
			assertFalse(appt.getValid());
		}

		// Testing setters as well as with no title/description, as well as testing nulled recurrence.
		@Test
		public void test06()  throws Throwable  {
			int startHour=2;
			int startMinute=2;
			int startDay=2; // This is now invalid.
			int startMonth=02;
			int startYear=2018;
			String title="";
			String description="";

			// Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			// Now test setters.
			appt.setStartHour(3);
			appt.setStartDay(3);
			appt.setStartMinute(3);
			appt.setStartMonth(3);
			appt.setStartYear(2019);
			appt.setTitle("Appointment Title");
			appt.setDescription("Appointment Description");
			appt.setTitle(null);
			appt.setDescription(null);



			// assertions
			assertTrue(appt.getValid());
			assertEquals(3, appt.getStartHour());
			assertEquals(3, appt.getStartMinute());
			assertEquals(3, appt.getStartDay());
			assertEquals(3, appt.getStartMonth());
			assertEquals(2019, appt.getStartYear());
			assertEquals("", appt.getTitle());
			assertEquals("", appt.getDescription());
			assertFalse(appt.isRecurring());
		}

		// Testing recurrence.
		@Test
		public void test07()  throws Throwable  {
			int startHour=5;
			int startMinute=30;
			int startDay=3; // This is now invalid.
			int startMonth=03;
			int startYear=2018;
			String title="Appointment Title";
			String description="Appointment Description";

			// Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			int[] recurrence={2,3,4};

			appt.setRecurrence(recurrence, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

			// assertions
			assertTrue(appt.getValid());
			assertEquals(recurrence, appt.getRecurDays());
			assertEquals(Appt.RECUR_BY_WEEKLY, appt.getRecurBy());
			assertEquals(1, appt.getRecurIncrement());
			assertEquals(Appt.RECUR_NUMBER_FOREVER, appt.getRecurNumber());
			assertTrue(appt.isRecurring());
		}

		/*// Testing String Representation & the valid branch of toString.
		@Test
		public void test08()  throws Throwable  {
			int startHour=5;
			int startMinute=30;
			int startDay=2; // This is now invalid.
			int startMonth=02;
			int startYear=2018;
			String title="Appointment Title";
			String description="Appointment Description";

			// Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			// assertions
			assertEquals("\t02/2/2018 at 5:30am ,Appointment Title, Appointment Description\n", appt.toString());
		}

		// Covering PM version of String Rep.
		@Test
		public void test09()  throws Throwable  {
			int startHour=14;
			int startMinute=30;
			int startDay=2; // This is now invalid.
			int startMonth=02;
			int startYear=2018;
			String title="Appointment Title";
			String description="Appointment Description";

			// Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			// assertions
			assertEquals("\t02/2/2018 at 2:30pm ,Appointment Title, Appointment Description\n", appt.toString());
		}

		// Covering midnight version of String Rep.
		@Test
		public void test10()  throws Throwable  {
			int startHour=0;
			int startMinute=30;
			int startDay=2; // This is now invalid.
			int startMonth=02;
			int startYear=2018;
			String title="Appointment Title";
			String description="Appointment Description";

			// Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			// assertions
			assertEquals("\t02/2/2018 at 2:30pm ,Appointment Title, Appointment Description\n", appt.toString());
		}

		// Testing the non valid branch of toString.*/
		@Test
		public void test11()  throws Throwable  {
			int startHour=5;
			int startMinute=-1;
			int startDay=2;
			int startMonth=02;
			int startYear=2018;
			String title="Appointment Title";
			String description="Appointment Description";

			// Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			// assertions
			assertEquals(null, appt.toString());
		}


}
