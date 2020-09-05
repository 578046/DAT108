package dat108.hvl.no;

public class TelleOppTraad extends Thread {
	
	private Teller teller;
	private int antallGanger;
	
		public TelleOppTraad(Teller teller, int antallGanger) {
			this.teller = teller;
			this.antallGanger = antallGanger;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < antallGanger; i++) {
				
//				synchronized(teller ) {
//					//Kritisk seksjon
//					teller.verdi++;  // x++ | x = x + 1
//				}
//				
				
				teller.tellOpp();
			}
		}
}
