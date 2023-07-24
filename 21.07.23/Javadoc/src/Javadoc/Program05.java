package Javadoc;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sourcePath = sc.nextLine();
		String desPath = sc.nextLine();
		try {
			 FileReader fileReader = new FileReader(sourcePath);
	         BufferedReader bufferedReader = new BufferedReader(fileReader);
	         
	         FileWriter fileWriter = new FileWriter(desPath);
	         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		

		String l;
		while((l = bufferedReader.readLine())!=null) {
			 bufferedWriter.write(l);
             bufferedWriter.newLine();
		}
		bufferedReader.close();
        bufferedWriter.close();
        fileReader.close();
        fileWriter.close();
		}
		
		catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
	}

}
