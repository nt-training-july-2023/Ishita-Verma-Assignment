package collections;

import java.util.*;

public class Program08 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
	    for(int i=0;i<20;i++) {
	    	set.add(i);
	    }
		System.out.println(set);
		List<Integer> list = new ArrayList<>(set);
		Collections.reverse(list);
		System.out.println(list);

	}

}
