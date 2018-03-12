package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/* Random Test Generator  for TimeTable class. */

public class TimeTableRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/* Generate Random Tests that tests TimeTable Class. */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"getApptRange","deleteAppt"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

	@Test
	public void radnomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try{

			for(int iteration = 0; elapsed < TestTimeout; iteration++){

				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				LinkedList<Appt> Appts = new LinkedList<Appt>();
				TimeTable TimeTable = new TimeTable();

				//create list of random appts
				for (int i = 0; i < 150; i++){

					int startHour = ValuesGenerator.getRandomIntBetween(random,-10,30);
					int startMinute = ValuesGenerator.getRandomIntBetween(random,-10,70);
					int startDay = ValuesGenerator.getRandomIntBetween(random,-10,40);
					int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int startYear = ValuesGenerator.RandInt(random);

					String title="Birthday Party";
					String description="This is my birthday party.";
					//Construct a new Appointment object with the initial data
					Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

					int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
					int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
					int recur=ApptRandomTest.RandomSelectRecur(random);
					int recurIncrement = ValuesGenerator.RandInt(random);
					int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
					appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

					Appts.add(appt);
				}

				for(int i = 0; i < NUM_TESTS; i++){

					String methodName = TimeTableRandomTest.RandomSelectMethod(random);

					if (methodName.equals("getApptRange")){

						try{

							GregorianCalendar firstDay = new GregorianCalendar(ValuesGenerator.RandInt(random), ValuesGenerator.getRandomIntBetween(random, 1,11), ValuesGenerator.RandInt(random));
							GregorianCalendar lastDay = (GregorianCalendar)firstDay.clone();
							lastDay.add(Calendar.YEAR,ValuesGenerator.getRandomIntBetween(random, 1, 150));
							TimeTable.getApptRange(Appts,firstDay, lastDay);
						}catch(DateOutOfRangeException e) {
						}
					} else  if (methodName.equals("deleteAppt")) {

						if (ValuesGenerator.getRandomIntBetween(random,0,149) < 75){
							int position = ValuesGenerator.getRandomIntBetween(random,0,Appts.size()-1);
							Appt appt = Appts.get(position);
							TimeTable.deleteAppt(Appts, appt);
						} else {

							Appt appt = new Appt(ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random),
							ValuesGenerator.RandInt(random), ValuesGenerator.getRandomIntBetween(random,1,11),
							ValuesGenerator.RandInt(random), "Birthday Party", "This is my birthday party.");

							if(ValuesGenerator.getRandomIntBetween(random,0,10) < 2){
								appt = null;
							}

							if(ValuesGenerator.getRandomIntBetween(random,0,10) < 2){
								Appts = null;
							}

							TimeTable.deleteAppt(Appts,appt);
						}
					}
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		}catch(NullPointerException e){
		}
	}
}
