package no.hvl.dat108.oppg3;

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
			
			while(!rutsjebane.isEmpty()) {
				try {
					sleep(interval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				int r = rutsjebane.removeBurger();
				System.out.println(getName() + "  tar av hamburger (" + r + ") >> " + rutsjebane.toString());
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
