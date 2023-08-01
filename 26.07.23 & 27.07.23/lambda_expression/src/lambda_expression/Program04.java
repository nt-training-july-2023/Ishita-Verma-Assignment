package lambda_expression;

import java.io.File;

public class Program04 {

	public static void main(String[] args) {
		String directoryP = "C://Windows";
		File directory = new File(directoryP);
		 if (directory.exists() && directory.isDirectory()) {
	            String[] fileNames = directory.list();
	            for (String fileName : fileNames) {
	                System.out.println(fileName);
	            }
	        } else {
	            System.out.println("Directory does not exist or is not a directory.");
	        }
	}

}
