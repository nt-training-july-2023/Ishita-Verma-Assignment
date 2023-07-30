package collections;
import java.util.*;

public class Program13 {

	public static void main(String[] args) {
		 Map<String, Integer> map = new LinkedHashMap<>();
	     for(int i=97;i<112;i++) {
	    	 char c = (char)i;
	    	 String s = Character.toString(c);
	    	 map.put(s, i);
	     }
	
	     for(String k:map.keySet()) {
	    	 System.out.print(k);
	     }
	}

}
