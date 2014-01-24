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
		Borrower titi = new Borrower("titiT", teacher);
		Borrower tutu = new Borrower("tutuT", teacher);
		
		stock.addUser(toto);
		stock.addUser(tata);
		stock.addUser(titi);
		stock.addUser(tutu);

		HashMap<Model, Integer> map1 = new HashMap<Model, Integer>();
		map1.put(Models.getModels().findModelByName("Chaise"), 2);
		HashMap<Model, Integer> map2 = new HashMap<Model, Integer>();
		map1.put(Models.getModels().findModelByName("Lit"), 3);
		HashMap<Model, Integer> map3 = new HashMap<Model, Integer>();
		map1.put(Models.getModels().findModelByName("Tablette"), 5);
		HashMap<Model, Integer> map4 = new HashMap<Model, Integer>();
		map1.put(Models.getModels().findModelByName("Portable"), 11);
		
		Ask ask1 = new Ask(map1,p,toto);
		Ask ask2 = new Ask(map2,p,tata);
		Ask ask3 = new Ask(map3,p,titi);
		Ask ask4 = new Ask(map4,p,tutu);
		Ask ask5 = new Ask(map3,p,toto);
		Ask ask6 = new Ask(map3,p,tata);
		
		stock.addAsk(ask1);
		stock.addAsk(ask2);
		stock.addAsk(ask3);
		stock.addAsk(ask4);
		stock.addAsk(ask5);
		stock.addAsk(ask6);

		System.out.println(stock);
	}
}
