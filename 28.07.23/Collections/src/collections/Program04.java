package collections;

import java.util.*;

public class Program04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "ISHITA");
		map.put(2, "RUSHA");
		map.put(3, "AASHI");
		map.put(4, "ESHIKA");
		map.put(5, "PRISHA");
		
		int key = sc.nextInt();
		System.out.println("Key "+key);
		
		if(map.containsKey(key)) {
			System.out.println("yes "+key );
		}
		else {
			System.out.println("no");
		}
		
		sc.nextLine();
		
		String value = sc.nextLine();
		System.out.println("Value "+value);
		
		if(map.containsValue(value)) {
			System.out.println("yes "+value );
		}
		else {
			System.out.println("no");
		}
	}

}
