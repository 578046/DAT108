package no.hvl.dat108.oppg1;


public class Message {
	
	public String message;
	public boolean continueRun = true;
	
	public Message(String message) {
		this.message = message;
	}
	
	
	

	public synchronized String getMessage() {
		return message;
	}
	
	public synchronized void setMessage(String message) {
		this.message = message;
	}
	
	public synchronized void stopp(){
		System.exit(1);
	}
	
	public synchronized void print() {
		System.out.println(message);
	}


	public synchronized boolean isContinueRun() {
		return continueRun;
	}

	public  synchronized void setContinueRun(boolean continueRun) {
		this.continueRun = continueRun;
	}
	
}
