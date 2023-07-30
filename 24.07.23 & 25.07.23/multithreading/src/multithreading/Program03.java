package multithreading;
import java.util.*;

public class Program03 {
	
	public static class sum extends Thread{
		private int n;
		public sum(int n){
			this.n=n;
		}
		public void run() {
			int s=0;
			for(int i=0;i<n;i++) {
				s+=i;
			}
			System.out.println(s);
		}
	}
	
	public static class reverse extends Thread{
		private int n;
		public  reverse(int n){
			this.n=n;
		}
		public void run() {
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0;i<n;i++) {
				list.add(i);
			}
			Collections.reverse(list);
			System.out.println(list);
		}
	}
	
	public static class fibonacci extends Thread{
		@SuppressWarnings("unused")
		private int n;
		public fibonacci(int n) {
			this.n=n;
		}
		public void run() {
			int a=0,b=1;
			System.out.print(a+" "+b);
			int c=a+b;
			a=b;
			b=c;
			System.out.print(" "+c);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int n = sc.nextInt();
		sum SUM = new sum(n);
		reverse REVERSE = new reverse(n);
		fibonacci FIBONACCI = new fibonacci(n);
		
		SUM.start();
		REVERSE.start();
		FIBONACCI.start();

	}

}
