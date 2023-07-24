package oops;

public class program07 {

	//local class
	public void one(){
		class inner{
			public void two() {
				System.out.println("local one two");
			}
		}
		inner in = new inner();
		in.two();
	}
	
	//static class
	 static class ones{
		public void twos(){
			System.out.println("static one's twos");
		}
	}
	 
	//non static
	 class oness{
		 public void twoss() {
			 System.out.println("non static oness twoss");
		 }
	 }
	public static void main(String[] args) {
		program07 all = new program07();
		//local
		all.one();
		
		//static
		program07.ones ans = new program07.ones();
		ans.twos();
		
		//non static
		program07.oness nonStatic = all.new oness();
		nonStatic.twoss();

	}

}
