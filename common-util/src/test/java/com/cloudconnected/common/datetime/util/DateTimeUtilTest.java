/**
 * 
 */
package com.cloudconnected.common.datetime.util;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.cloudconnected.common.datetime.util.DateUtil;

/**
 * @author Derek Reynolds
 *
 */
public class DateTimeUtilTest {

	/**
	 * Test method for {@link com.cloudconnected.common.datetime.util.DateUtil.utils.DateTimeUtils#isBetween(java.util.Date, java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testIsBetweenDateTrue() {
		
		Calendar dateInQuestion = new GregorianCalendar(2013, Calendar.JANUARY, 20);
		Calendar leftBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 10);
		Calendar rightBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 30);
		
		boolean answer = DateUtil.isBetween(dateInQuestion.getTime(), leftBoundDate.getTime(), rightBoundDate.getTime());
		
		assertTrue(answer);
	}
	
	/**
	 * Test method for {@link com.cloudconnected.common.datetime.util.DateUtil.utils.DateTimeUtils#isBetween(java.util.Date, java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testIsBetweenDateTrueOnLeftBound() {
		
		Calendar dateInQuestion = new GregorianCalendar(2013, Calendar.JANUARY, 10);
		Calendar leftBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 10);
		Calendar rightBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 30);
		
		boolean answer = DateUtil.isBetween(dateInQuestion.getTime(), leftBoundDate.getTime(), rightBoundDate.getTime());
		
		assertTrue(answer);
	}
	
	/**
	 * Test method for {@link com.cloudconnected.common.datetime.util.DateUtil.utils.DateTimeUtils#isBetween(java.util.Date, java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testIsBetweenDateTrueOnRightBound() {
		
		Calendar dateInQuestion = new GregorianCalendar(2013, Calendar.JANUARY, 30);
		Calendar leftBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 10);
		Calendar rightBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 30);
		
		boolean answer = DateUtil.isBetween(dateInQuestion.getTime(), leftBoundDate.getTime(), rightBoundDate.getTime());
		
		assertTrue(answer);
	}
	
	/**
	 * Test method for {@link com.cloudconnected.common.datetime.util.DateUtil.utils.DateTimeUtils#isBetween(java.util.Date, java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testIsBetweenDateNotTrue() {
		
		Calendar dateInQuestion = new GregorianCalendar(2013, Calendar.JANUARY, 1);
		Calendar leftBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 10);
		Calendar rightBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 30);
		
		boolean answer = DateUtil.isBetween(dateInQuestion.getTime(), leftBoundDate.getTime(), rightBoundDate.getTime());
		
		assertFalse(answer);
	}


}
