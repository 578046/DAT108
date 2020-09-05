package no.hvl.dat108.oppg1;

import javax.swing.JOptionPane;

public class ClientThread extends Thread {
	private Message message;
	
	

	public ClientThread(Message message) {
		this.message = message;
	}

	@Override
	public void run() {

			while (message.isContinueRun()) {

				message.setMessage(JOptionPane.showInputDialog(null, "Skriv inn din melding, quit for å slutte"));

				if (message.getMessage().toLowerCase().equalsIgnoreCase("quit")) {
					JOptionPane.showMessageDialog(null, "Programmet er avsluttet");
					message.stopp();
				}

				message.print();

			}

	}
}
