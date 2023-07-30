package collections;

import java.util.HashMap;
import java.util.Map;

public class Program05 {

	public static void main(String[] args){
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "ISHITA");
		map.put(2, "RUSHA");
		map.put(3, "AASHI");
		map.put(4, "ESHIKA");
		map.put(5, "PRISHA");
		
		for(int key:map.keySet()) {
			System.out.println(key);
		}
		
		for(String value:map.values()) {
			System.out.println(value);
		}
		

	}

}
