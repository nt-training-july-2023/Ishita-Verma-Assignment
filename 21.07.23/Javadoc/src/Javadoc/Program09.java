package Javadoc;
import java.util.*;

public class Program09 {

	public static class NotEvenNumberException extends Exception{
		public NotEvenNumberException(String prompt) {
			super(prompt);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		try{
			int num = sc.nextInt();
			if(num%2==0) {
			System.out.println("Even number");
			}
			else {
				throw new NotEvenNumberException("Not Even");
			}
		}
		
		catch(InputMismatchException e) {
			System.out.println("Invalid abc " + e.getMessage());
		}
		catch(NotEvenNumberException e) {
			System.out.println("Invalid " + e.getMessage());
		}

	}

}
