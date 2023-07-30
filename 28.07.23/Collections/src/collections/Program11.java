package collections;
import java.util.*;

public class Program11 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i=65;i<85;i++) {
			char c = (char)i;
			String s= Character.toString(c);
			list.add(s);
		}
		System.out.println(list);
	}

}
