package no.hvl.dat108.Oppg2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> f) {
		ansatte.forEach(a -> a.setAarslonn(f.apply(a)));
	}

	public static void main(String[] args) {
		List<Ansatt> ansatte = new ArrayList<>();

		ansatte.add(new Ansatt("Gro", "Tesk", Kjonn.KVINNE, "Vaktmester", 100000));
		ansatte.add(new Ansatt("Eggert", "Sjønning", Kjonn.NØYTRUM, "Statsminister", 99000000));
		ansatte.add(new Ansatt("Mari", "Høne", Kjonn.KVINNE, "Gartner", 5000000));
		ansatte.add(new Ansatt("Tor", "Pedo", Kjonn.URTUM, "Rallysjaafoer", 600000));
		ansatte.add(new Ansatt("Finn", "Fram", Kjonn.MANN, "Etterforsker", 4500000));

		skrivUtAlle(ansatte);
		System.out.println();
//		i. Et fast kronetillegg
		System.out.println("i. Et fast kronetillegg ( +5000 kr )");
		Function<Ansatt, Integer> fixed = a -> a.getAarslonn() + 5000;
		lonnsoppgjor(ansatte, fixed);
		skrivUtAlle(ansatte);
		System.out.println();
		

//		ii. Et fast prosenttillegg
		System.out.println("ii. Et fast prosenttillegg (20%)");
		Function<Ansatt, Integer> percent = a -> a.getAarslonn() + ((a.getAarslonn() / 100) * 20);
		lonnsoppgjor(ansatte, percent);
		skrivUtAlle(ansatte);
		System.out.println();

//		iii. Et fast kronetillegg hvis du har lav lønn
		System.out.println("iii. Et fast kronetillegg hvis du har lav lønn ( +50000 )");
		Function<Ansatt, Integer> ifLowSalary = a -> {
			if (a.getAarslonn() < 1000000)
				return a.getAarslonn() + 50000;
			return a.getAarslonn();
		};
		lonnsoppgjor(ansatte, ifLowSalary);
		skrivUtAlle(ansatte);
		System.out.println();

//		iv. Et fast prosenttillegg hvis du er mann
		System.out.println("iv. Et fast prosenttillegg hvis du er mann (20%)");
		Function<Ansatt, Integer> ifMale = a -> {
			if (a.getKjonn().equals(Kjonn.MANN))
				return a.getAarslonn() + ((a.getAarslonn() / 100) * 20);
			return a.getAarslonn();
		};
		lonnsoppgjor(ansatte, ifMale);

		skrivUtAlle(ansatte);

	}

	private static void skrivUtAlle(List<Ansatt> ansatte) {
		ansatte.forEach(a -> System.out.println(a.toString()));
	}

}
