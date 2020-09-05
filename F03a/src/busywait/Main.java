package busywait;

public class Main {
	
	private static String melding;

	public static void main(String[] args) {
		
		Object lock = new Object();
		
		Thread printlnTraad = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock) {
					if(melding == null ) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				System.out.println(melding);
				
			}	
		});
		
		Thread giVerdiTraad = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock) {
					melding = "Dette er en melding";
					//lock.notify(); - en tr�d f�r beskjed
					lock.notifyAll(); // Alle tr�der f�r beskjed
				}
				
				
			}		
		});
		
		printlnTraad.start();
		giVerdiTraad.start();

	}

}
