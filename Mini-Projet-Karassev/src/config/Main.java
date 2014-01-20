package config;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import model.Inventory;
import model.equipment.Equipment;
import model.equipment.Ipad3;
import model.equipment.Vengeance2100;
import model.equipment.XperiaZ;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Equipment, Integer> inventory = new HashMap<Equipment, Integer>();
		HashMap<Equipment, Integer> inventory2 = new HashMap<Equipment, Integer>();
		inventory.put(new XperiaZ(), 4);
		inventory.put(new Vengeance2100(), 5);
		
		// Test enregistrer
		//ConfigXML.store(inventory, "test0","v1");
		// Test charger
		//inventory2 = (HashMap<Equipment, Integer>) ConfigXML.load("test1", "v1");
		
		Set<Equipment> keys = inventory2.keySet();
		Iterator<Equipment> it = keys.iterator();
		
		while (it.hasNext()) {
			Equipment key = it.next();
			//System.out.println(key.toString());
		}
		
		System.out.println("INVENTORY ---");
		Inventory r = new Inventory();
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(new XperiaZ());
		r.addEquipment(new Ipad3());
		r.addEquipment(new Vengeance2100());
		
		System.out.println(r.toString());
		
		
	}

}
