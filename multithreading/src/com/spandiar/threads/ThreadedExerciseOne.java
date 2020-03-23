package com.spandiar.threads;

class checkIncrement{
	
	private int i;
	
	public void incrementInteger() {
		i++;
	}

	public int getI() {
		return i;
	}
}

public class ThreadedExerciseOne{
	

	public static void main(String[] args) throws InterruptedException {
		
		checkIncrement incrementInteger = new checkIncrement();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int count =1; count<=1000;count++) {
					incrementInteger.incrementInteger();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int count =1; count<=1000;count++) {
					incrementInteger.incrementInteger();
				}
			}
		});
	
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Value of i is: " + incrementInteger.getI());
	}
}
