package no.hvl.dat108.oppg2;

public class Main {

	public static void main(String[] args) {

		Rutsjebane Rb = new Rutsjebane();

		Thread[] kokk = { (new KokkThread("Kokk1", Rb)), (new KokkThread("Kokk2", Rb)),
				(new KokkThread("Kokk3", Rb)) };
		Thread[] servitor = { (new ServitoerThread("Servit�r1", Rb)), (new ServitoerThread("Servit�r2", Rb)) };

		for (Thread k : kokk) {
			k.start();
		}

		for (Thread s : servitor) {
			s.start();
		}

	}

}

// 3 kokker og 2 servit�rer, rusjebanen ar plss til 5 burgere

// Kokker er tr�d-objekter, og lager hamburgere uavhengig av hva som skjer ellers
// Tiden det tar � lage en hamburger skal v�re (random) mellom 2 og 6 sek.
// Servit�rer er tr�d-objekter, og tar hamburgere uavhengig av hva som skjer ellers
// Tiden det tar � bestille en hamburger skal v�re (random) mellom 2 og 6 sek.
// Rutsjebanen er en delt ressurs som b�de kokker og servit�rer forholder seg til
// Hvis rutsjebanen er tom, m� servit�rer vente til det er lagt en ny hamburger p�
// Hvis rutsjebanen er full, m� kokker vente til det er tatt en hamburger av
