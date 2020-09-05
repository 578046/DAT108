package no.hvl.dat108.oppg2;

import java.util.Random;

public class ServitoerThread extends Thread {

	private Rutsjebane rutsjebane;
	private Random generator = new Random();


	public ServitoerThread(String name, Rutsjebane rutsjebane) {
		super(name);
		this.rutsjebane = rutsjebane;
	}

	@Override
	public void run() {
		
		
		while (true) {
			int interval = (generator.nextInt(6) + 2) * 1000;

			synchronized (rutsjebane) {

				while (rutsjebane.isEmpty()) {

					System.out.println(
							"### " + getName() + "  vil ta en hamburger, men rutsjebanen er tom. Venter! ###");

					try {
						rutsjebane.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				try {
					sleep(interval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int r = rutsjebane.removeBurger();
				rutsjebane.notifyAll();
				System.out.println(getName() + "  tar av hamburger (" + r + ") => "
						+ rutsjebane.toString());
				
				
			}

		}
	}

//
//	@Override
//	public void run() {
//		while(true) {
//			
//			String burgerOrder = "Servitør ...  tar av hamburger (...)  => []";
//			
//			synchronized(order) {
//				while(!order.isRecived()) {
//					try {
//						order.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//				order.send(newOrder, nr);
//			}
//			
//			
//		}
//		
//		
//	}

}
