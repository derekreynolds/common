/**
 * 
 */
package com.evolvingreality.common.datetime.util;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;


/**
 * @author Derek Reynolds
 *
 */
public class CalendarUtilTest {


	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.DateUtil.utils.DateTimeUtils#isBetween(java.util.Calendar, java.util.Calendar, java.util.Calendar)}.
	 */
	@Test
	public final void testIsBetweenCalendarTrue() {
		
		Calendar dateInQuestion = new GregorianCalendar(2013, Calendar.JANUARY, 20);
		Calendar leftBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 10);
		Calendar rightBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 30);
		
		boolean answer = CalendarUtil.isBetween(dateInQuestion, leftBoundDate, rightBoundDate);
		
		assertTrue(answer);
	}

}
