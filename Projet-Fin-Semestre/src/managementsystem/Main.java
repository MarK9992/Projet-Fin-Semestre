package managementsystem;

import java.io.IOException;

import config.BorrowerType;

import users.Borrower;
import users.User;

import equipment.Equipment;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		ManagementSystem stock = new ManagementSystem();
		Equipment stuff1 = new Equipment("Chaise", "Ipad3");
		Equipment stuff2 = new Equipment("Lit", "Vengeance2100");
		
		stock.addEquipment(stuff1);
		stock.addEquipment(stuff2);
		
		Loan loan = new Loan();
		stock.addLoan(loan);
		
		BorrowerType type = BorrowerType.STUDENT;
		Borrower user = new Borrower("toto",type);
		stock.addUser(user);
		
		System.out.println(stock);
	}
}
