package collections;
import java.util.*;

public class Program03 {

	private static Map<Integer,String> map = new HashMap<>();
	
	public static void add(Map<Integer,String>map) {
		map.put(1,"NEWLY ADDED");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int threshold= sc.nextInt();
		System.out.println("Threshold "+threshold);
		map.put(1, "ISHITA");
		map.put(2, "RUSHA");
		map.put(3, "AASHI");
		map.put(4, "ESHIKA");
		map.put(5, "PRISHA");
		
		System.out.println(map.size());

		if(map.size()==threshold) {
			map.clear();
			add(map);
		}
		System.out.println(map);
	}

}
