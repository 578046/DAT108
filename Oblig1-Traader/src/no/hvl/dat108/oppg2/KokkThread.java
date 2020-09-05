package no.hvl.dat108.oppg2;

import java.util.Random;

public class KokkThread extends Thread {

	private Rutsjebane rutsjebane;
	private Random generator = new Random();

	public KokkThread(String name, Rutsjebane rutsjebane) {
		super(name);
		this.rutsjebane = rutsjebane;
	}

	@Override
	public void run() {
		
		while (true) {
			int interval = (generator.nextInt(6) + 2) * 1000;

			synchronized (rutsjebane) {

				while (rutsjebane.isFull()) {

					System.out.println(
							"### Kokk" + getName() + " er klar med en hamburger, men rutsjebanen er full. Venter! ###");

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
				
				int burgerNr = rutsjebane.addBurger();
				rutsjebane.notifyAll();
				System.out.println(getName() + " legger på hamburger (" + burgerNr + ") => "
						+ rutsjebane.toString());
				
			}

		}

	}
}
