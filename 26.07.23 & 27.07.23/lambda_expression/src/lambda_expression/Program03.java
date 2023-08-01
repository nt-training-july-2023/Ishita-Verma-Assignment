package lambda_expression;
import java.io.IOException;
import java.util.*;

public class Program03 {

	public static void write(String output, List<string> l ) {
		try(Bufferedwriter writer = new Bufferedwriter(new FileWriter(output))){
			for(String line:l) {
				writer.write(line);
                writer.newLine();
			}
		}
		 catch (IOException e) {
	            System.out.println("Error writing to the file: " + e.getMessage());
	        }
	}
	public static void main(String[] args) {
		String input ="input.txt";
		String output="output.txt";
		
		 List<String> l = readLines(input);
		 writeLines(output,l);
	}

}
