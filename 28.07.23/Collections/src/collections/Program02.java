package collections;

import java.util.*;

public class Program02 {

	public static Map<Integer,String> hashmap = new HashMap<>();  
	public static Map<Integer,String> treemap = new TreeMap<>();  
	public static Map<Integer,String> linkedhashmap = new LinkedHashMap<>(); 
	
	public static void operations(Map<Integer,String> map) {
		map.put(1, "ISHITA");
		map.put(2, "RUSHA");
		map.put(3, "AASHI");
		map.put(4, "ESHIKA");
		map.put(5, "PRISHA");
		
		System.out.println("Original Map: " + map);
		
		map.put(8, "RITIKA");
		
		System.out.println("After Addition Map: " + map);
		
		map.remove(2);
		
		System.out.println("After Updation Map: " + map);
	}
	public static void main(String[] args) {
		operations(hashmap);
		operations(treemap);
		operations(linkedhashmap);
		
	}
}
