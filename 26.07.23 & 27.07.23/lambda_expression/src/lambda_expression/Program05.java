package lambda_expression;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program05 {

	public static void main(String[] args) {
		String source = "input.txt";

	        String destination = "output.txt";

	        try (FileReader reader = new FileReader(source);
	             FileWriter writer = new FileWriter(destination)) {

	            int ch;
	            while ((ch = reader.read()) != -1) {
	                writer.write(ch);
	            }
	            System.out.println("File copied successfully!");
	        } catch (IOException e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        }
	}

}
