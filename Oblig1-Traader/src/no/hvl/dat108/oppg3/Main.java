package no.hvl.dat108.oppg3;

public class Main {

	public static void main(String[] args) {

		Rutsjebane Rb = new Rutsjebane();

		Thread[] kokk = { (new KokkThread("Kokk1", Rb)), (new KokkThread("Kokk2", Rb)),
				(new KokkThread("Kokk3", Rb)) };
		Thread[] servitor = { (new ServitoerThread("Servitør1", Rb)), (new ServitoerThread("Servitør2", Rb)) };

		for (Thread k : kokk) {
			k.start();
		}

		for (Thread s : servitor) {
			s.start();
		}

	}

}
