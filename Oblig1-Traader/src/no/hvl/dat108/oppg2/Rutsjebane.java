package no.hvl.dat108.oppg2;



import java.util.Iterator;
import java.util.LinkedList;


public class Rutsjebane {
	
	private int MAX_SIZE = 5;
	private LinkedList<Burger> burgerList;
	private int burgerNr = 1;
	
	
	
	public Rutsjebane() {
		this.burgerList = new LinkedList<Burger>();
	}
	
	public boolean isEmpty() {
		return burgerList.size() == 0;
	}
	
	
	public boolean isFull() {
		return burgerList.size() == MAX_SIZE;
	}
	
	
	public int addBurger() {
		
		if(!isFull()) {
			 
			burgerList.add(new Burger(burgerNr));
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
				r = burgerList.removeFirst().getBurgerNumber();
			}
			
		return r;
	}




	@Override
	public String toString() {
		
		String s = "[";
		
		if(!isEmpty() ) {
			for(Burger b : burgerList) {
				s += b.toString();
			}
		}
		
		s += "]";
		
		return s;

	}
	
	
}
