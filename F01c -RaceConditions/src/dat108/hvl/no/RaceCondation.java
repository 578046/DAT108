package dat108.hvl.no;

public class RaceCondation {
	public static void main(String[] args) throws InterruptedException {
		
		Teller teller = new Teller();
		
		Thread telleOppTraad = new TelleOppTraad(teller, 10000);
		
		Thread telleNedTraad = new TelleNedTraad(teller, 10000);
		
		telleOppTraad.start();
		telleNedTraad.start();
		
		telleOppTraad.join();
		telleNedTraad.join();
		
		System.out.println(teller.getVerdi());
	}
}
