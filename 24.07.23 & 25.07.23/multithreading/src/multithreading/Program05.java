package multithreading;

public class Program05 {

	public static void main(String[] args) {
	        Thread thread = new Thread(() -> {
	            try {
	                Thread.sleep(2000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });

	        System.out.println("Thread state after creation: " + thread.getState());

	        thread.start();
	        System.out.println("Thread state after start: " + thread.getState());

	        try {
	            thread.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        System.out.println("Thread state after completion: " + thread.getState());
	    }

	}


