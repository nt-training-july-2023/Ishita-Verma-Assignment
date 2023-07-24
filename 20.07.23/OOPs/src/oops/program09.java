package oops;

public class program09 {

	static int i=0;
	public program09() {
		i++; //for every object creation will increment
	}
	public static void main(String[] args) {
		program09 ans  = new program09();
		program09 ans1 = new program09();
		program09 ans2 = new program09();
		program09 ans3 = new program09();

		System.out.println(i);
	}

}
