package multithreading;

import java.util.Scanner;

public class Program08 {
	
	private int balance=1000;

	public int getBalance() {
		return balance;
	}

	public synchronized void setBalance(int balance) {
		this.balance = balance;
	}
	
	public synchronized void withdraw()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to withdraw");
		int amount = sc.nextInt();
		if(this.balance<amount)
		{
			System.out.println("Insufficient balance");
			System.out.println("Waiting for deposit");
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		this.balance-=amount;
		System.out.println("Withdraw complete");
	}
	
	public synchronized void deposit()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to deposit");
		int amount = sc.nextInt();
		if(amount<0)
		{
			System.out.println("Invalid Amount");
		}
		else
		{
			this.balance+=amount;
			System.out.println("Deposit complete");
			notify();
		}
	}

}
