/**
 * @author Anaïs
 */
package model.users;

import static org.junit.Assert.assertEquals;
import model.ManagementSystem;

import org.junit.Test;

import utils.Period;
import config.Model;

public class StudentTest {

	@Test
	public void book() {
		ManagementSystem m = new ManagementSystem("inventory", "users", "v1");
		Student t = new Student();
		m.checkLoan(t.book(Model.XPERIAZ, new Period()));
		
		assertEquals(t.getLoanList(), m.getOngoingValidationLoans());
		
		m.checkLoan(t.book(Model.VENGEANCE2100, new Period()));
		m.checkLoan(t.book(Model.IPAD3, new Period()));
		
		assertEquals(t.getLoanList(), m.getOngoingValidationLoans());
	}

}
