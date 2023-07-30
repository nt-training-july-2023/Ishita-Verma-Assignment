package collections;
import java.util.*;

public class Program14 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
	    list.add("aa");
	    list.add("b");
	    list.add("z");
	    list.add("d");
	    list.add("e");
	    list.add("c");
	    
	    System.out.println("Main list = "+list);
	
	    list.remove("d");
	    
	    System.out.println("After removal list = "+list);
	
	    Collections.sort(list);
	}

}
