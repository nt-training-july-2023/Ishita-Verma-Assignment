package multithreading;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class Program04 {
	static class reader implements Runnable {
	    private String message;

	    public reader(String message) {
	        this.message = message;
	    }
	    public void run() {
			System.out.println("Message"+Thread.currentThread().getName()+message);
			System.out.println("Acknowledged"+Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {
		 String message = "Hello, this is a message to be read.";
	        ExecutorService executor = Executors.newFixedThreadPool(3);

	        for (int i = 1; i <= 3; i++) {
	            executor.submit(new reader(message));
	        }

	        executor.shutdown();
	}
	
	}
