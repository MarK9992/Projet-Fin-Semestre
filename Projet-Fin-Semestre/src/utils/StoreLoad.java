package utils;
import java.util.*;
import java.io.*;
import java.util.HashMap;

public class StoreLoad 
{
	public void Output(Object out, String name) throws IOException
	{
		FileOutputStream fichier = new FileOutputStream("data/"+name+".data");
		ObjectOutputStream oos = new ObjectOutputStream(fichier);
		oos.writeObject(out);
		oos.flush();
		oos.close();
	}
	
	public Object Input(String name) throws IOException, ClassNotFoundException
	{
		FileInputStream fichier = new FileInputStream("data/"+name+".data");
		ObjectInputStream ois = new ObjectInputStream(fichier);
		Object stock = (Object) ois.readObject();
		ois.close();
		return stock;
	}
}
