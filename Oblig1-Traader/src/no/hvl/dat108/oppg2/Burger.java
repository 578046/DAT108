package no.hvl.dat108.oppg2;

public class Burger {
	private int burgerNumber;
	
	public Burger(int nr) {
		this.burgerNumber = nr;
	}
	

	public synchronized int getBurgerNumber() {
		return burgerNumber;
	}

	public void setBurgerNumber(int burgerNumber) {
		this.burgerNumber = burgerNumber;
	}


	@Override
	public String toString() {
		return "(" + burgerNumber + ")";
	}
	
	
	
}
