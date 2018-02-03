/**
 * 
 */
package com.evolvingreality.common.datetime.util;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;


/**
 * @author Derek Reynolds
 *
 */
public class CalendarUtilTest {

	
	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.CalendarUtils#toCalendar(java.util.Date)}.
	 */
	@Test
	public final void testToCalendar() {
	
		Date now = new Date();
		
		Calendar answer = CalendarUtil.toCalendar(now);
		
		assertTrue(answer.getTime().getTime() == now.getTime());
	}

	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.CalendarUtils#isBetween(java.util.Calendar, java.util.Calendar, java.util.Calendar)}.
	 */
	@Test
	public final void testIsBetweenCalendarTrue() {
		
		Calendar dateInQuestion = new GregorianCalendar(2013, Calendar.JANUARY, 20);
		Calendar leftBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 10);
		Calendar rightBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 30);
		
		boolean answer = CalendarUtil.isBetween(dateInQuestion, leftBoundDate, rightBoundDate);
		
		assertTrue(answer);
	}

	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.CalendarUtils#isWeekend(java.util.Calendar)}.
	 */
	@Test
	public final void testIsWeekendSaturday() {
		
		Calendar dateInQuestion = new GregorianCalendar(2000, Calendar.JANUARY, 1);
		
		boolean answer = CalendarUtil.isWeekend(dateInQuestion);
		
		assertTrue(answer);
	}
	
	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.CalendarUtils#isWeekend(java.util.Calendar)}.
	 */
	@Test
	public final void testIsWeekendSunday() {
		
		Calendar dateInQuestion = new GregorianCalendar(2000, Calendar.JANUARY, 2);
		
		boolean answer = CalendarUtil.isWeekend(dateInQuestion);
		
		assertTrue(answer);
	}

	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.CalendarUtils#isWeekend(java.util.Calendar)}.
	 */
	@Test
	public final void testIsWeekendFalse() {
		
		Calendar dateInQuestion = new GregorianCalendar(2000, Calendar.JANUARY, 3);
		
		boolean answer = CalendarUtil.isWeekend(dateInQuestion);
		
		assertFalse(answer);
	}
	
	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.CalendarUtils#getStartOfYear(java.lang.Integer)}.
	 */
	@Test
	public final void testGetStartOfYear() {
				
		Calendar answer = CalendarUtil.getStartOfYear(2000);
		
		assertTrue(answer.get(Calendar.MONTH) == Calendar.JANUARY);
		assertTrue(answer.get(Calendar.DAY_OF_MONTH) == 1);
	}
	
	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.CalendarUtils#getEndOfYear(java.lang.Integer)}.
	 */
	@Test
	public final void testGetEndOfYear() {
				
		Calendar answer = CalendarUtil.getEndOfYear(2000);
		
		assertTrue(answer.get(Calendar.MONTH) == Calendar.DECEMBER);
		assertTrue(answer.get(Calendar.DAY_OF_MONTH) == 31);
	}
	
	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.CalendarUtils#forwardToDayOfWeek(java.lang.Integer)}.
	 */
	@Test
	public final void testForwardToDayOfWeek() {
				
		Calendar dateInQuestion = new GregorianCalendar(2000, Calendar.JANUARY, 1);
		
		Calendar answer = CalendarUtil.forwardToDayOfWeek(dateInQuestion, Calendar.MONDAY);
		
		assertTrue(answer.get(Calendar.DAY_OF_MONTH) == 3);
	}
	
	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.CalendarUtils#rewindToDayOfWeek(java.lang.Integer)}.
	 */
	@Test
	public final void testRewindToDayOfWeek() {
				
		Calendar dateInQuestion = new GregorianCalendar(2000, Calendar.JANUARY, 3);
		
		Calendar answer = CalendarUtil.rewindToDayOfWeek(dateInQuestion, Calendar.FRIDAY);
		
		assertTrue(answer.get(Calendar.DAY_OF_MONTH) == 31);
	}
	
}
