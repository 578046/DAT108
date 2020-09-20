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
		Function<Ansatt, Integer> fixed = a -> a.getAarslonn() + 5000;
		lonnsoppgjor(ansatte, fixed);

//		ii. Et fast prosenttillegg
		Function<Ansatt, Integer> percent = a -> a.getAarslonn() + ((a.getAarslonn() / 100) * 20);
		lonnsoppgjor(ansatte, percent);

//		iii. Et fast kronetillegg hvis du har lav lønn
		Function<Ansatt, Integer> ifLowSalary = a -> {
			if (a.getAarslonn() < 1000000)
				return a.getAarslonn() + 50000;
			return a.getAarslonn();
		};
		lonnsoppgjor(ansatte, ifLowSalary);

//		iv. Et fast prosenttillegg hvis du er mann
		Function<Ansatt, Integer> ifMale = a -> {
			if (a.getKjonn().equals(Kjonn.MANN))
				return a.getAarslonn() + 50000;
			return a.getAarslonn();
		};
		lonnsoppgjor(ansatte, ifMale);

		skrivUtAlle(ansatte);

	}

	private static void skrivUtAlle(List<Ansatt> ansatte) {
		ansatte.forEach(a -> System.out.println(a.toString()));
	}

}
