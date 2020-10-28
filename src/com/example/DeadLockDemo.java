/**
 * 
 */
package com.example;

/**
 * @author Madhav Reddy
 *
 */
public class DeadLockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final String resource1 = "Resourse 1";
		final String resource2 = "Resourse 2";

	//	DeadLockDemo demo = new DeadLockDemo();
		
		Thread t1 = new Thread() {

			@Override
			public void run() {

				synchronized (resource1) {

					System.out.println("thread 1 : Locking resourse 1");

					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				synchronized (resource2) {

					System.out.println("thread 1 : Locking resourse 2");
				}

			}

		};

		Thread t2 = new Thread() {

			public void run() {

				synchronized (resource2) {

					System.out.println("thread 2 : Locking resourse 2");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				synchronized (resource1) {

					System.out.println("thread 2 : Locking resourse 1");
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}
