package Javadoc;
import java.io.*;

public class Program08 {
 public static void main(String[] args) {
	 File myfile = new File("ishi.txt");
	 try {
		 System.out.println("jk");
		 myfile.createNewFile();
		 }
	 catch(Exception e) {
		 System.out.println("can't");
		 e.printStackTrace();
	 }
 }
}
