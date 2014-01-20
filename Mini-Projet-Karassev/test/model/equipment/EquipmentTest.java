package model.equipment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import utils.Period;
/**
 * @author Anaïs
 */
public class EquipmentTest {

	@Test
	public void availableNowTest() {
		Ipad3 i = new Ipad3();
		assertEquals(true, i.availableNow());
		
		Ipad3 i2 = new Ipad3();
		i2.getUnavailabalityPeriods().add(new Period());
		assertEquals(false, i2.availableNow());
	}
	/*
	@Test
	public void availableAtTest() {
		Ipad3 i = new Ipad3();
		assertEquals(true, i.availableAt(new Period()));
		
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.set(2013, 13, 12);
		end.set(2013, 16, 12);
		
		Ipad3 i2 = new Ipad3();
		i2.getUnavailabalityPeriods().add(new Period(start, end));
		assertEquals(true, i2.availableAt(new Period()));
		
		Calendar start2 = Calendar.getInstance();
		Calendar end2 = Calendar.getInstance();
		start2.set(2013, 14, 12);
		end2.set(2013, 17, 12);
		
		assertEquals(false, i2.availableAt(new Period(start2, end2)));
	}*/
}
