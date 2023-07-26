package Javadoc;
import java.util.*;

public class Program06 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Mango");
        list.add("Pineapple");
        list.add("Lichi");
	
	Scanner sc= new Scanner(System.in);
	try {
		int idx= Integer.parseInt(sc.nextLine());;
		if(list==null) {
			throw new NullPointerException("Null");
		}
		if(idx<0 || idx>=list.size()) {
			throw new IndexOutOfBoundsException("Out of bound");
		}
		String ans = list.get(idx);
		System.out.println(ans);
	}
	catch( NullPointerException e) {
		System.out.println(e.getMessage());
	}
	catch( IndexOutOfBoundsException e) {
		System.out.println(e.getMessage());
	}
}
}
