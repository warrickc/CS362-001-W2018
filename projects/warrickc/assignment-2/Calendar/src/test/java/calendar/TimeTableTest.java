package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

		// Add an appointment with normal recurrence, and null recurrence.
	  @Test
	  public void test01()  throws Throwable  {

			int thisMonth;
			int thisYear;
			int thisDay;

			Calendar rightnow = Calendar.getInstance();
			TimeTable timeTable = new TimeTable();
			LinkedList<Appt> listAppts = new LinkedList<Appt>();
			LinkedList<CalDay> calDays = new LinkedList<CalDay>();

			thisMonth = rightnow.get(Calendar.MONTH);
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

			GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
			GregorianCalendar firstDay = new GregorianCalendar(thisYear,1,thisDay);
			GregorianCalendar lastDay = new GregorianCalendar(thisYear,5,thisDay);

			int startHour=5;
			int startMinute=30;
			int startDay=3;
			int startMonth=03;
			int startYear=2018;
			String title="Appointment Title";
			String description="Appointment Description";

			// Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			// Add recurrence.
			int[] recurDaysArr={2,3,4};
			appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

			// Add the appointment.
			listAppts.add(appt);

			// Create another.
 		  startHour=16;
 		  startMinute=30;
 		  startDay=2;
 		  startMonth=2;
 		  startYear=2018;
 		  title="Appointment Title";
 		  description="Appointment Description";

 		  // Construct a new Appointment object with the initial data
 		  appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

			// Set recurrence with null this time.
			appt.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

 		  // Add the appointment.
 		  listAppts.add(appt);

			calDays = timeTable.getApptRange(listAppts, firstDay, lastDay);
	 }

	 // Add multiple appoitments so we can delete one.
	 @Test
	 public void test02()  throws Throwable  {

		 int thisMonth;
		 int thisYear;
		 int thisDay;

		 Calendar rightnow = Calendar.getInstance();
		 TimeTable timeTable = new TimeTable();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();


		 thisMonth = rightnow.get(Calendar.MONTH);
		 thisYear = rightnow.get(Calendar.YEAR);
		 thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 GregorianCalendar firstDay = new GregorianCalendar(thisYear,1,thisDay);
		 GregorianCalendar lastDay = new GregorianCalendar(thisYear,5,thisDay);

		 int startHour=5;
		 int startMinute=30;
		 int startDay=3;
		 int startMonth=03;
		 int startYear=2018;
		 String title="Appointment Title";
		 String description="Appointment Description";

		 // Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		 int[] recurDaysArr={2,3,4};
		 appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

		 // Add it.
		 listAppts.add(appt);

		 // Create another.
		 startHour=16;
		 startMinute=30;
		 startDay=2;
		 startMonth=2;
		 startYear=2018;
		 title="Appointment Title";
		 description="Appointment Description";

		 // Construct a new Appointment object with the initial data
		 appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		 // Add it.
		 listAppts.add(appt);

		 calDays = timeTable.getApptRange(listAppts, firstDay, lastDay);

		 timeTable.deleteAppt(listAppts, null);
		 timeTable.deleteAppt(listAppts, appt);
		 timeTable.deleteAppt(null, appt);
		 
	}

	// Now test permutation.
	@Test
	public void test03()  throws Throwable  {

		int thisMonth;
		int thisYear;
		int thisDay;

		Calendar rightnow = Calendar.getInstance();
		TimeTable timeTable = new TimeTable();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();


		thisMonth = rightnow.get(Calendar.MONTH);
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar firstDay = new GregorianCalendar(thisYear,1,thisDay);
		GregorianCalendar lastDay = new GregorianCalendar(thisYear,5,thisDay);

		int startHour=5;
		int startMinute=30;
		int startDay=3;
		int startMonth=03;
		int startYear=2018;
		String title="Appointment Title";
		String description="Appointment Description";

		// Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		int[] recurDaysArr={2,3,4};
		appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

		// Add it.
		listAppts.add(appt);

		// Create another.
		startHour=16;
		startMinute=30;
		startDay=2;
		startMonth=2;
		startYear=2018;
		title="Appointment Title";
		description="Appointment Description";

		// Construct a new Appointment object with the initial data
		appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		// Add it.
		listAppts.add(appt);

		// Create 1 more appointment because we have to have a length long enough to match the permutation array.
		startHour=15;
		startMinute=32;
		startDay=2;
		startMonth=2;
		startYear=2018;
		title="Appointment Title";
		description="Appointment Description";

		// Construct a new Appointment object with the initial data
		appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		listAppts.add(appt);

		// Create the array for our shuffle to base itself off.
		int[] permutation={0,2,1};

		// Run the permute.
		listAppts = timeTable.permute(listAppts, permutation);

 }

}
