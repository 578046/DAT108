package waitnotifymelding;

public class Melding {
	
	private String innhold;

	public synchronized String getInnhold() {
		
		 
			while(!harInnhold()) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		return innhold;
	}

	public synchronized void setInnhold(String innhold) {
		this.innhold = innhold;
		notifyAll();
	}
	
	public synchronized boolean harInnhold() {
		return innhold != null;
	}
}
