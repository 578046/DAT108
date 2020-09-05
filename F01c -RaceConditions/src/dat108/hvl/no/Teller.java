package dat108.hvl.no;

public class Teller {
	public int verdi = 0;

	public synchronized void tellOpp() {
			verdi++;
	}

	public synchronized void tellerNed() {
			verdi--;
	}

	public int getVerdi() {
		return verdi;
	}
}
