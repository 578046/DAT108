package sendermottaker;

import javax.swing.JOptionPane;

public class Mottaker extends Thread{
	private Melding melding;

	

	public Mottaker(Melding melding) {
		this.melding = melding;
	}



	@Override
	public void run() {

		while (true) {

			String nyMelding = JOptionPane.showInputDialog(null, "Skriv inn melding:");

			synchronized (melding) {
				while (melding.erMottatt()) {
					try {
						melding.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				String mottattMelding = melding.motta();
				melding.notifyAll();
				System.out.println("Mottaker har motatt melding: " + mottattMelding);
				
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
