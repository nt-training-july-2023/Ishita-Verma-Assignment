package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "ISHITA");
		map.put(2, "RUSHA");
		map.put(3, "AASHI");
		map.put(4, "ESHIKA");
		map.put(5, "PRISHA");
		System.out.println(map);
		
		int key = sc.nextInt();
		String value = sc.next();
		
		if(map.containsKey(key) && map.containsValue(value)) {
			map.remove(key, value);
			System.out.println(map);
		}
		
	}

}
