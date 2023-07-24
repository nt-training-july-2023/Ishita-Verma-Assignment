package Javadoc;

public class Program03 {

	public static class InvalidInput extends Exception{
		public InvalidInput(String prompt) {
			super(prompt);
		}
	}
	public static class rectangle{

		public static int area(int length,int width) throws InvalidInput{
			if(length<=0 || width <=0) {
				throw new InvalidInput("Inappropiate input");
			}
			return length*width;
		}
		
	}
	public static void main(String[] args) {
		try {
			int length = 2;
			int width  = 3;
			int ans = rectangle.area(length, width);
			System.out.println(ans);

		}
		catch(InvalidInput e) {
			System.out.println(e.getMessage());
		}

	}

}
