package managementsystem;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import users.Borrower;
import utils.Period;

import config.Model;
import equipment.Equipment;

/**
 * Tests on managementsystem.Loan class.
 * 
 * @author Marc Karassev
 * 
 */
public class LoanTest {

	@SuppressWarnings("deprecation")
	@Test
	public void constructorsTest() {
		HashMap<Model, Integer> hm = new HashMap<Model, Integer>();
		hm.put(Model.IPAD3, 3);
		hm.put(Model.VENGEANCE2100, 1);
		Loan l1 = new Loan();
		Loan l2 = new Loan(hm, new Period(), new Borrower());

		assertEquals(l1.getStuff().size(), 0);
		assertEquals(l1.getStuff().keySet().toArray(), new Object[0]);
		assertEquals(l2.getStuff().size(), 2);
		assertEquals(l2.getStuff().keySet().toArray(), new Object[] {
				Model.VENGEANCE2100, Model.IPAD3 });
		assertEquals(l2.getStuff().get(Model.VENGEANCE2100),
				new ArrayList<Equipment>(1));
		assertEquals(l2.getStuff().get(Model.IPAD3),
				new ArrayList<Equipment>(3));
		System.out.println(l1 + "\n");
		System.out.println(l2);
	}
}
