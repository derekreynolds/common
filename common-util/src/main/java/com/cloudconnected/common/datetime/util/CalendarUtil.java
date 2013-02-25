/**
 * 
 */
package com.cloudconnected.common.datetime.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Derek Reynolds
 * @since 1.0
 */
public abstract class CalendarUtil {
	
	/**
	 * Converts a {@link java.util.Date} to a {@link Calendar}.  
	 * @param date 
	 * @return a {@link Calendar} representation of the date.
	 */
	public static Calendar toCalendar(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar;
	}
	
	/**
	 * Creates a {@link Calendar} object for the start of the
	 * year. The time is 0:00:00
	 * @param year the year are creating the {@link Calendar} object for.
	 * @return a {@link Calendar} for the start of the year.
	 */
	public static Calendar getStartOfYear(Integer year) {
		
		return new GregorianCalendar(year, Calendar.JANUARY, 1);
	}
	
	/**
	 * Creates a {@link Calendar} object for the end of the
	 * year. The time is 23:59:59.
	 * @param year the year are creating the {@link Calendar} object for.
	 * @return a {@link Calendar} for the start of the year.
	 */
	public static Calendar getEndOfYear(Integer year) {
		
		return new GregorianCalendar(year, Calendar.DECEMBER, 31, 23, 59, 59);
	}
	
	/**
	 * Checks if the date passed in is a weekend.
	 * @param calendar the date to check
	 * @return true if it is a Saturday or Sunday.
	 */
	public static Boolean isWeekend(Calendar calendar) {
		
		if((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) 
					|| (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
			return true;			
		}
			
		return false;
	}
	
	/**
	 * Create a Calendar based on the one passed in. It rewinds to
	 * the calendar to the day specified. If it is already on that
	 * day the calendar will be the same as the one passed in.
	 * @param calendar
	 * @param day
	 * @return
	 */
	public static Calendar rewindToCalendarDay(final Calendar calendar, int day) {
		
		Calendar newCalendar = (Calendar)calendar.clone();
		
		while(newCalendar.get(Calendar.DAY_OF_WEEK) != day) {
			newCalendar.add(Calendar.DAY_OF_MONTH, -1);
		}
		
		return newCalendar;
	}
	
	/**
	 * Create a Calendar based on the one passed in. It forwards to
	 * the calendar to the day specified. If it is already on that
	 * day the calendar will be the same as the one passed in.
	 * @param calendar
	 * @param day
	 * @return
	 */
	public static Calendar forwardToCalendarDay(final Calendar calendar, int day) {
		
		Calendar newCalendar = (Calendar)calendar.clone();
		
		while(newCalendar.get(Calendar.DAY_OF_WEEK) != day) {
			newCalendar.add(Calendar.DAY_OF_MONTH, +1);
		}
		
		return newCalendar;
	}
	
	/**
	 * Checks to see if a {@link Calendar} is between to dates. This is inclusive
	 * of the bounded calendars.
	 * @param compareCalendar
	 * @param startCalendar - left bounded date.
	 * @param endCalendar - right bounded date. 
	 * @return true if the {@link Calendar} is on or between thw bound dates.
	 */
	public static boolean isBetween(Calendar compareCalendar, Calendar startCalendar, Calendar endCalendar) {
		
		return DateUtil.isBetween(compareCalendar.getTime(), startCalendar.getTime(), endCalendar.getTime());
	}
	
	
}
