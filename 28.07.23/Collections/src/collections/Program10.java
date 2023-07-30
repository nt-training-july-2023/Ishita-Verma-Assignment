package collections;
import java.util.*;

public class Program10 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<60;i++) {
			set.add(i);
		}
		System.out.println(set);
	}

}
