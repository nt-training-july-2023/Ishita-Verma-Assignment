package collections;
import java.util.*;

public class Program15 {

	    static class student implements Comparable<student>{
		private int roll;
		private String name;
		
		public student(int roll,String name){
			this.roll=roll;
			this.name=name;
		}
		public int getRoll() {
	        return roll;
	    }

	    public String getName() {
	        return name;
	    }

		@Override
		public int compareTo(student S) {          //reference of another student,this current student jisse compare krre
			return this.name.compareTo(S.name);
		}
		
		public String toString() {
	        return "Student ID: " + roll + ", Name: " + name;
	    }
		
	}
	public static void main(String[] args) {
		List<student> list = new ArrayList<>();
        list.add(new student(1, "ISHITA"));
        list.add(new student(3, "RUSHA"));
        list.add(new student(2, "PRASHI"));

        Collections.sort(list);

        for (student s : list) {
            System.out.println(s);
        }
	}

}
