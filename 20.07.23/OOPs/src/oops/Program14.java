package oops;

public class Program14 {

	final int a;
	public Program14(int ans){
		a=ans;
	}
	public void display() {
		System.out.println(a);
	}
	public static void main(String[] args) {
		Program14 res = new Program14(26);
		res.display();
	}

}
