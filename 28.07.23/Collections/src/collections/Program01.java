package collections;

import java.util.HashMap;

public class Program01 {

	private static HashMap<Integer, String> map = new HashMap<>();
	
	public static void add(int id, String name) {
		map.put(id,name);
	}
	public static void display() {
		for(int empid : map.keySet()) {
			String empname= map.get(empid);
			System.out.println(empid+" "+empname);
		}
	}
	public static void main(String[] args) {
		map.put(1, "ISHITA");
		map.put(2, "RUSHA");
		map.put(3, "AASHI");
		map.put(4, "ESHIKA");
		map.put(5, "PRISHA");

		add(8,"Ridhi");
		display();
		
	}

}
