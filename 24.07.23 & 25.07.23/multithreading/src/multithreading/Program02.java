package multithreading;

public class Program02 {
//	public static class threads extends Thread{
//		public void run() {
//			System.out.println(Thread.currentThread().getName());
//		}
//	}


    public static class myThread implements Runnable{
    public void run(){
    	System.out.println(Thread.currentThread().getId());
    }
    }	

	public static void main(String[] args) {
		myThread t = new myThread();
		Thread t1  = new Thread(t, "t1");
		Thread t2  = new Thread(t, "t2");
		Thread t3  = new Thread(t, "t3");
			t1.start();
			t2.start();
			t3.start();
	}

//output : t2 t1 t3 -changes 
}
