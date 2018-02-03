/**
 * 
 */
package com.evolvingreality.common.datetime.util;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import com.evolvingreality.common.datetime.util.DateUtil;

/**
 * @author Derek Reynolds
 *
 */
public class DateTimeUtilTest {

	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.DateTimeUtils#isBetween(java.util.Date, java.util.Date, java.util.Date)}.
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
	 * Test method for {@link com.v.common.datetime.util.DateTimeUtils#isBetween(java.util.Date, java.util.Date, java.util.Date)}.
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
	 * Test method for {@link com.evolvingreality.common.datetime.util.DateTimeUtils#isBetween(java.util.Date, java.util.Date, java.util.Date)}.
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
	 * Test method for {@link com.evolvingreality.common.datetime.util.DateTimeUtils#isBetween(java.util.Date, java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testIsBetweenDateFalse() {
		
		Calendar dateInQuestion = new GregorianCalendar(2013, Calendar.JANUARY, 1);
		Calendar leftBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 10);
		Calendar rightBoundDate = new GregorianCalendar(2013, Calendar.JANUARY, 30);
		
		boolean answer = DateUtil.isBetween(dateInQuestion.getTime(), leftBoundDate.getTime(), rightBoundDate.getTime());
		
		assertFalse(answer);
	}

	/**
	 * Test method for {@link com.evolvingreality.common.datetime.util.DateTimeUtils#isBetween(java.util.Date, java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testGetYearSequence() {
			
		List<String> answer = DateUtil.getYearSequence(2012, 2, 2);
		
		assertTrue(answer.size() == 5);
		assertTrue(answer.get(0).equals("2010"));
		assertTrue(answer.get(1).equals("2011"));
		assertTrue(answer.get(2).equals("2012"));
		assertTrue(answer.get(3).equals("2013"));
		assertTrue(answer.get(4).equals("2014"));
	}
}
