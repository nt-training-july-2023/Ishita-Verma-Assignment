package Javadoc;

import java.util.*;

public class Program10 {

	public static class InvalidPasswordException extends Exception {
		public InvalidPasswordException(String prompt) {
			super(prompt);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ");
		String pass = sc.nextLine();
		
		try {
			if(pass.length()<8 || !pass.matches(".*[a-zA-Z].*[0-9].*")) {
			throw new InvalidPasswordException("Invalid");
		}
			else {
				System.out.println("successful");
			}
			
		}
		catch(InvalidPasswordException e){
			 System.out.println("Invalid password: " + e.getMessage());
        
		}
	
		
//		public static void passCheck(String pass) throws InvalidPasswordException{
//			if(pass.length()<8 || !pass.matches(".*[a-zA-Z].*") || !pass.matches("[.*\\d*.]")) {
//				throw new InvalidPasswordException("Incorrect ");
//			}
		}
		}