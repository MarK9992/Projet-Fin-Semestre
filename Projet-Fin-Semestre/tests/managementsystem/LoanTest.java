package managementsystem;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

import config.Model;
import config.Models;

import users.Borrower;
import utils.Period;

import equipment.Equipment;

/**
 * Tests on managementsystem.Loan class.
 * 
 * @author Marc Karassev
 * 
 */
public class LoanTest {

	@Test
	public void constructorsTest() {
		HashMap<Model, Integer> hm = new HashMap<Model, Integer>();
		hm.put(Models.getModels().findModelByName("Ipad3"), 3);
		hm.put(Models.getModels().findModelByName("Vengeance2100"), 1);
		HashSet<Model> hs = new HashSet<Model>();
		hs.add(Models.getModels().findModelByName("Ipad3"));
		hs.add(Models.getModels().findModelByName("Vengeance2100"));
		Loan l1 = new Loan();
		Loan l2 = new Loan(hm, new Period(), new Borrower());

		assertEquals(l1.getStuff().size(), 0);
		assertEquals(l1.getStuff().keySet().isEmpty(), true);
		assertEquals(l2.getStuff().size(), 2);
		assertEquals(l2.getStuff().keySet(), hs);
		assertEquals(
				l2.getStuff().get(Models.getModels().findModelByName("Ipad3")),
				new ArrayList<Equipment>(1));
		assertEquals(
				l2.getStuff().get(
						Models.getModels().findModelByName("Vengeance2100")),
				new ArrayList<Equipment>(3));
		System.out.println(l1 + "\n");
		System.out.println(l2);
	}
}
