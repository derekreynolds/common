/**
 * 
 */
package com.evolvingreality.common.datetime.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * This class contains helper methods that provide 
 * functionality around, Date, Time and Calendars. 
 * @author Derek Reynolds
 * @since 1.0
 */
public abstract class DateUtil {

	/**
	 * This method will create a year sequence from the year. It will create
	 * based on the number of years in the past up until a number of years in
	 * the future.
	 * 
	 * For year 2012, numberOfPastYears 1 and numberOfFutureYears 1 the result would be
	 * 2011,2012,2013,2014
	 * 
	 * @param year 
	 * @param numberOfPastYears
	 * @param numberOfFutureYears
	 * @return an {@link List} of Strings.
	 */
	public static List<String> getYearSequence(int year, int numberOfPastYears, int numberOfFutureYears) {
		
		List<String> years = new ArrayList<>(numberOfPastYears + numberOfFutureYears + 1);			
		
		for(int i = 0; i < numberOfPastYears; i++) {
			years.add(String.valueOf(year - (numberOfPastYears - i)));
		}
		
		for(int i = 0; i <= numberOfFutureYears; i++) {
			years.add(String.valueOf(year + i));
		}
		
		return years;
	}

	
	/**
	 * Checks to see if a {@link java.util.Date} is between to dates. This is inclusive
	 * of the bounded calendars.
	 * @param compareDate
	 * @param startDate - left bound date.
	 * @param endDate - right bound date. 
	 * @return true if the {@link Calendar} is on or between thw bound dates.
	 */
	public static boolean isBetween(Date compareDate, Date startDate, Date endDate) {
		
		if((compareDate.after(startDate) || compareDate.equals(startDate)) 
						&& (compareDate.before(endDate) || compareDate.equals(endDate))) {
			return true;
		}
		
		return false;
	}
	
}
