package sendermottaker;

import javax.swing.JOptionPane;

public class Sender extends Thread{
	
	private Melding melding;
	
	
	
	public Sender(Melding melding) {
		this.melding = melding;
	}



	@Override
	public void run() {
		
		while (true) {
			
			String nyMelding = JOptionPane.showInputDialog(null, "Skriv inn melding:");
			
			synchronized(melding) {
				while(!melding.erMottatt()) {
					try {
						melding.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				melding.send(nyMelding);
				melding.notifyAll();
				System.out.println("Sender har sendt melding: " + nyMelding);
			}
		}
	}
}
