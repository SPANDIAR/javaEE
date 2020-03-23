package com.spandiar.threads;

class Hi{
	public void sayHi(){
			System.out.println("Hi");
	}
}

class Hello{
	public void sayHello() {
		System.out.println("Hello");
	}
}

public class ThreadedExerciseTwo {
	
	static boolean yourTurn = true;
	
	public static void main(String args[]) throws InterruptedException {
		
		Hi hi = new Hi();
		Hello hello = new Hello();
		
		Thread t1 = new Thread(new Runnable() {
			public synchronized void run() {
			/*	for(int count=1;count<=5;count++) {
					hi.sayHi();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}*/
				while(true) {
					if(yourTurn) {
						hi.sayHi();
						yourTurn = false;
						notify();
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public synchronized void run() {
			/*	for(int count=1;count<=5;count++) {
					hello.sayHello();
					try {
						Thread.sleep(600);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}*/
				while(true) {
					if(!yourTurn) {
						hello.sayHello();
						yourTurn = true;
						notify();
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		//System.out.println("Before Join");
		//System.out.println("Is T1 alive: " + t1.isAlive());
		//System.out.println("Is T2 alive: " + t2.isAlive());
		//System.out.println("yourTurn before Join is " + yourTurn);
		
		t1.join();
		t2.join();
/*		System.out.println("After Join");
		System.out.println("Is T1 alive: " + t1.isAlive());
		System.out.println("Is T2 alive: " + t2.isAlive());*/
		//System.out.println("yourTurn after Join is " + yourTurn);

		//System.out.println("Back to main");
		
	/*	for(int count=1;count<=5;count++) {
			hi.sayHi();
			Thread.sleep(500);
			hello.sayHello();	
			Thread.sleep(500);
		}*/
	}
}
