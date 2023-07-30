package collections;
import java.util.*;

public class Program09 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(20);
		list.add(30);
		list.add(44);
		list.add(50);
		list.add(56);
		list.add(65);
		list.add(83);
		
		for(int i=0;i<list.size();i++) {
			 int a = list.get(i);
			 if(a>50) {
				 list.set(i, a+5);
			 }
		}
		System.out.println(list);
	}

}
