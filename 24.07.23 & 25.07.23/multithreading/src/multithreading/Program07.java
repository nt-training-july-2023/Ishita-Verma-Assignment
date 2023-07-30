package multithreading;

public class Program07 {
	public static class priority extends Thread{

		public void run() {
			   System.out.println(Thread.currentThread());
		}
	}

	public static void main(String[] args) {
		priority p1 = new priority();
		priority p2 = new priority();
		
		p1.setPriority(2);
		p2.setPriority(5);
		
		p1.start();
		p2.start();

	}

}
