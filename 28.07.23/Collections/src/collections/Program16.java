package collections;
import java.util.*;

public class Program16 {

	public static class student{

		private int roll;
		private String name;
		
		public student(int roll, String name) {
			this.roll= roll;
			this.name=name;
		}
		
		public int getRoll() {
	        return roll;
	    }
		
		public String getName() {
			return name;
		}
		
		public String toString() {
			return "Roll " + roll + ", Name: " + name;
		}
	}
	
	public static void main(String[] args) {
		List<student> list = new ArrayList<>();
        list.add(new student(1, "ISHITA"));
        list.add(new student(3, "RUSHA"));
        list.add(new student(2, "PRASHI"));
        
        Comparator<student> roll = new Comparator<student>() {
	         @Override
	         public int compare(student s1, student s2) {
	    	 return s1.getRoll() - s2.getRoll();
	         }
        };
	    	 Collections.sort(list, roll);

	         for (student s : list) {
	             System.out.println(s);
	     }
	}

}
