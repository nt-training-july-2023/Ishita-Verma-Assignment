package oops;

public class program05 {
 abstract class animal{
	 public abstract void eats();
	 
	 public void display() {
		 System.out.println("Animal");
	 }
 }
 
 public class Monkey extends animal {
     @Override
     public void eats() {
         System.out.println("eats");
     }
 }
	public static void main(String[] args) {
		program05 outerObj = new program05(); 
        Monkey m = outerObj.new Monkey(); 	
        m.eats();
		m.display();
	}

}
