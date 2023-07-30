package collections;

import java.util.HashSet;
import java.util.Set;

public class Program12 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(10);
		set.add(40);
		set.add(50);
		set.add(110);
		set.add(10);
		set.add(10);
		System.out.println(set);
	}

}
