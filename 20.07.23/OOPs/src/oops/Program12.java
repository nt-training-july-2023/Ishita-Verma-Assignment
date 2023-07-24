package oops;

public class Program12 {

	public int a=10;
	public static int b=20;
	
	public static class ans{
		public void display() {
			System.out.println(b);
			Program12 obj = new Program12();
			System.out.println(obj.a);
		}
	}
	public static void main(String[] args) {
		ans a = new ans();
		a.display();

	}

}
