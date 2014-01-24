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

public class Main {
	public static void main(String[] args) throws IOException {
		ManagementSystem stock = new ManagementSystem();
		Equipment stuff1 = new Equipment("Chaise", Models.getModels()
				.findModelByName("Chaise"));
		Equipment stuff2 = new Equipment("Lit", Models.getModels()
				.findModelByName("Lit"));
		Equipment stuff3 = new Equipment("Tablette", Models.getModels()
				.findModelByName("Ipad3"));
		Equipment stuff4 = new Equipment("Portable", Models.getModels()
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
		Borrower titi = new Borrower("titiT", student);
		Borrower tutu = new Borrower("tutuT", student);
		
		stock.addUser(toto);
		stock.addUser(tata);
		stock.addUser(titi);
		stock.addUser(tutu);
		
		Model model1 = new Model("Chaise", 5, 8);
		Model model2 = new Model("Tablette", 3, 8);
		Model model3 = new Model("Portable", 9, 8);
		Model model4 = new Model("Lit", 12, 8);
		
		HashMap<Model, Integer> map1 = new HashMap<Model, Integer>();
		map1.put(model1, 2);
		HashMap<Model, Integer> map2 = new HashMap<Model, Integer>();
		map1.put(model2, 3);
		HashMap<Model, Integer> map3 = new HashMap<Model, Integer>();
		map1.put(model3, 5);
		HashMap<Model, Integer> map4 = new HashMap<Model, Integer>();
		map1.put(model4, 11);
		
		Ask ask1 = new Ask(map1,p,toto);
		Ask ask2 = new Ask(map2,p,tata);
		Ask ask3 = new Ask(map3,p,titi);
		Ask ask4 = new Ask(map4,p,tutu);
		Ask ask5 = new Ask(map3,p,toto);
		
		stock.addAsk(ask1);
		stock.addAsk(ask2);
		stock.addAsk(ask3);
		stock.addAsk(ask4);
		stock.addAsk(ask5);

		System.out.println(stock);
	}
}
