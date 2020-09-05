package no.hvl.dat108.oppg1;

public class WriterThread extends Thread {

	private Message message;

	public WriterThread(Message message) {
		this.message = message;
	}

	@Override
	public void run() {

			while (message.isContinueRun()) {

				message.print();

				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

	}

}
