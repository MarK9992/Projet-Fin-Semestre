package managementsystem;

import java.io.IOException;

import config.Model;
import equipment.Equipment;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		ManagementSystem stock = new ManagementSystem();
		Equipment stuff1 = new Equipment("Chaise", "Ipad3");
		Equipment stuff2 = new Equipment("Lit", "Vengeance2100");
		
		//stock.addEquipment(stuff1);
		//stock.addEquipment(stuff2);
		
		System.out.println(stock);
	}
}
