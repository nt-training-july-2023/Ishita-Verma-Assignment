package multithreading;
import java.util.concurrent.atomic.AtomicInteger;

public class Program08 {
	public int balance;
	public Program08(int t ) {
			this.balance=t;
	}
	
	 public synchronized void deposit(int amt) {
	        balance += amt;
	        System.out.println(Thread.currentThread().getName() + " deposited " + amt + ". New balance: " + balance);
	 }
	 
	 public synchronized void take(int amt) {
		 if(balance>=amt) {
			 balance-=amt;
			 System.out.println(Thread.currentThread().getName() + " withdrew " + amt + ". New balance: " + balance);
	        } else {
	            System.out.println(Thread.currentThread().getName() + " cannot withdraw " + amt + " (Insufficient balance). Current balance: " + balance);
	        }
	 }

	  public int getBalance() {
	        return balance;
	    }
	  
	public static class balance extends Thread{
		public int balance;
		public balance(int b){
			this.balance=b;
		}
	}
	
	public static void main(String[] args) {
		
	}

}
