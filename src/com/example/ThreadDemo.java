package com.example;

/*class Producer implements Runnable {

	@Override
	public void run() {
		
		System.out.println("Run method called");
		for (int i = 0; i < 100; i++) {
			
			System.out.println("I : " + i);
		}
	}
	
}*/

class Customer {

	double amount = 10000;
	
	synchronized void withdraw(double amount) {
		
		System.out.println("Withdraw started");
		if (this.amount < amount) {
			
			System.out.println("Less amount, wait for deposit");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.amount-= amount;
		System.out.println("Withdraw completed");
	}
	
	synchronized void deposit(double amount) {
		
		System.out.println("Deposit started");
		this.amount+= amount;
		System.out.println("Amount deposited");
		notify();
	}
	
}

public class ThreadDemo {

	public static void main(String[] args){
		
		/*Runnable runnable = () ->
		{
			
			for (int i = 0; i < 100; i++) {
			
				System.out.println("I : " + i);
			}
		};
		Thread t = new Thread(runnable);
		t.start();
		System.out.println("Main method end");*/
		
		Customer customer = new Customer();
		System.out.println("Customer object created");
		/*new Thread() {
			
			@Override
			public void run() {
				
				customer.withdraw(1500);
			}
		}.start();
		
		new Thread() {
			
			@Override
			public void run() {
				
				customer.withdraw(1000);
			}
		}.start();*/
		
		Runnable withdraw = () ->
		{
			
			customer.withdraw(15000);
		};
		Thread t1 = new Thread(withdraw);
		t1.start();
		
		Runnable deposit = () ->
		{
			
			customer.deposit(10000);
		};
		Thread t2 = new Thread(deposit);
		t2.start();
	}

}
