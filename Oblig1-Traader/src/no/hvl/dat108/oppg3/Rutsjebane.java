package no.hvl.dat108.oppg3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import no.hvl.dat108.oppg2.Burger;

public class Rutsjebane {

	private int MAX_SIZE = 5;
	private BlockingQueue<Burger> burgerList;
	private int burgerNr = 1;

	public Rutsjebane() {
		this.burgerList = new LinkedBlockingQueue<Burger>(5);
	}

	public boolean isEmpty() {
		return burgerList.size() == 0;
	}

	public boolean isFull() {
		return burgerList.size() == MAX_SIZE;
	}

	public int addBurger() {

		if(!isFull()) {
			 
			try {
				burgerList.put(new Burger(burgerNr));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			burgerNr++;
		}
			return burgerNr - 1;
	}

	public int getBurgerNr() {
		return burgerNr;
	}

	public int removeBurger() {

		int r = 0;
		
		if(!isEmpty()) {
			try {
				r = burgerList.take().getBurgerNumber();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	return r;

	}

	@Override
	public String toString() {
		String s = "[";

		if (!isEmpty()) {
			for (Burger b : burgerList) {
				s += b.toString();
			}
		}

		s += "]";

		return s;

	}

}
