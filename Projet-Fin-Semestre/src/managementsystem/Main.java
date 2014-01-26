package managementsystem;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

import config.BorrowerType;
import config.Model;
import config.Models;

import users.Borrower;
import utils.Period;

import equipment.Equipment;

/**
 * Initializes the management system.
 * 
 * @author Anthony Saraïs
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		ManagementSystem stock = ManagementSystem.getManagementSystem();
		Equipment stuff1 = new Equipment("Chaise", stock.getModels()
				.findModelByName("Chaise"));
		Equipment stuff2 = new Equipment("Lit", stock.getModels()
				.findModelByName("Lit"));
		Equipment stuff3 = new Equipment("Tablette", stock.getModels()
				.findModelByName("Ipad3"));
		Equipment stuff4 = new Equipment("Portable", stock.getModels()
				.findModelByName("XperiaZ"));

		stock.addEquipment(stuff1);
		stock.addEquipment(stuff2);
		stock.addEquipment(stuff3);
		stock.addEquipment(stuff4);

		Period p = new Period();

		BorrowerType student = BorrowerType.STUDENT;
		BorrowerType teacher = BorrowerType.TEACHER;

		Borrower toto = new Borrower("totoS", student);
		Borrower tata = new Borrower("tataS", student);
		Borrower titi = new Borrower("titiT", teacher);
		Borrower tutu = new Borrower("tutuT", teacher);

		for (int i = 0; i < 25; i++)
			stock.addUser(toto);
		for (int i = 0; i < 43; i++)
			stock.addUser(tata);
		for (int i = 0; i < 19; i++)
			stock.addUser(titi);
		for (int i = 0; i < 23; i++)
			stock.addUser(tutu);

		HashMap<Model, Integer> map1 = new HashMap<Model, Integer>();
		map1.put(stock.getModels().findModelByName("Chaise"), 2);
		HashMap<Model, Integer> map2 = new HashMap<Model, Integer>();
		map2.put(stock.getModels().findModelByName("Lit"), 3);
		HashMap<Model, Integer> map3 = new HashMap<Model, Integer>();
		map3.put(stock.getModels().findModelByName("Ipad3"), 5);
		HashMap<Model, Integer> map4 = new HashMap<Model, Integer>();
		map4.put(stock.getModels().findModelByName("XperiaZ"), 11);

		Ask ask1 = new Ask(map1, p, toto);
		Ask ask2 = new Ask(map2, p, tata);
		Ask ask3 = new Ask(map1, p, titi);
		Ask ask4 = new Ask(map4, p, tutu);
		Ask ask5 = new Ask(map3, p, toto);
		Ask ask6 = new Ask(map3, p, tata);

		Loan loan1 = new Loan(ask1);

		stock.addLoan(loan1);
		stock.addAsk(ask2);
		stock.addAsk(ask3);
		stock.addAsk(ask4);
		stock.addAsk(ask5);
		stock.addAsk(ask6);

		System.out.println(stock);
	}
}
