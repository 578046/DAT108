package no.hvl.dat108.oppg2;

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

// 3 kokker og 2 servitører, rusjebanen ar plss til 5 burgere

// Kokker er tråd-objekter, og lager hamburgere uavhengig av hva som skjer ellers
// Tiden det tar å lage en hamburger skal være (random) mellom 2 og 6 sek.
// Servitører er tråd-objekter, og tar hamburgere uavhengig av hva som skjer ellers
// Tiden det tar å bestille en hamburger skal være (random) mellom 2 og 6 sek.
// Rutsjebanen er en delt ressurs som både kokker og servitører forholder seg til
// Hvis rutsjebanen er tom, må servitører vente til det er lagt en ny hamburger på
// Hvis rutsjebanen er full, må kokker vente til det er tatt en hamburger av
