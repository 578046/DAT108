package no.hvl.dat108.oppg1;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		
		Message message = new Message("Hello verden!");
		
		Thread writesThread =  new Thread(new WriterThread(message));
		Thread clientMessage = new Thread (new ClientThread(message));
		
		
		writesThread.start();
		clientMessage.start();

	}
	

}
