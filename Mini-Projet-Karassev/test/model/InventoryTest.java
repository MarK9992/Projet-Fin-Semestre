package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import model.equipment.Ipad3;
import model.equipment.Vengeance2100;
import model.equipment.XperiaZ;

import org.junit.Test;

import utils.Period;
import config.Model;

public class InventoryTest {

	@Test
	public void addTest() {
		Inventory r = new Inventory();
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());

		assertEquals(3, r.getNumberElements());
		System.out.println(r.toString());
	}

	@Test
	public void removeTest() {
		Ipad3 ip = new Ipad3();
		Vengeance2100 v = new Vengeance2100();

		Inventory r = new Inventory();
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());

		assertEquals(3, r.getNumberElements());
		System.out.println(r.toString());

		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(ip);
		r.addEquipment(v);

		assertEquals(7, r.getNumberElements());
		System.out.println(r.toString());

		r.removeEquipment(ip);
		r.removeEquipment(v);

		assertEquals(5, r.getNumberElements());
		System.out.println(r.toString());
	}

	@Test
	public void getNumberElementsTest() {
		Inventory r = new Inventory();
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());

		assertEquals(3, r.getNumberElements());

		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());

		assertEquals(5, r.getNumberElements());
	}

	@Test
	public void isInStockTest() {
		Ipad3 ip = new Ipad3();
		Ipad3 ip2 = new Ipad3();
		Vengeance2100 v = new Vengeance2100();

		Inventory r = new Inventory();
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(ip);
		r.addEquipment(v);

		assertEquals(true, r.isInStock(ip));
		assertEquals(false, r.isInStock(ip2));
		assertEquals(true, r.isInStock(v));
	}

	@Test
	public void findAvailableEquipmentTest() {
		Ipad3 ip = new Ipad3();
		Ipad3 ip2 = new Ipad3();
		ArrayList<Period> a = new ArrayList<Period>();
		a.add(new Period());
		ip.setUnavailabalityPeriods(a);

		Vengeance2100 v = new Vengeance2100();
		XperiaZ x = new XperiaZ();

		Inventory r = new Inventory();
		r.addEquipment(x);
		r.addEquipment(ip);
		r.addEquipment(ip2);
		r.addEquipment(v);

		assertEquals(v, r.findAvailableEquipment(Model.VENGEANCE2100));
		assertEquals(x, r.findAvailableEquipment(Model.XPERIAZ));
		assertEquals(ip2, r.findAvailableEquipment(Model.IPAD3));

		Inventory r2 = new Inventory();
		assertNull(r2.findAvailableEquipment(Model.IPAD3));
		assertNull(r2.findAvailableEquipment(Model.VENGEANCE2100));
		assertNull(r2.findAvailableEquipment(Model.XPERIAZ));
	}

}
