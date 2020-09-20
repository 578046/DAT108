package no.hvl.dat108.Oppg3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import no.hvl.dat108.Oppg2.Ansatt;
import no.hvl.dat108.Oppg2.Kjonn;

public class Oppg3 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = new ArrayList<>();

		ansatte.add(new Ansatt("Gro", "Tesk", Kjonn.KVINNE, "Vaktmester", 100000));
		ansatte.add(new Ansatt("Eggert", "Sjønning", Kjonn.NØYTRUM, "Statsminister", 99000000));
		ansatte.add(new Ansatt("Mari", "Høne", Kjonn.KVINNE, "Gartnersjef", 5000000));
		ansatte.add(new Ansatt("Tor", "Pedo", Kjonn.URTUM, "Rallysjaafoer", 600000));
		ansatte.add(new Ansatt("Finn", "Fram", Kjonn.MANN, "Etterforsker", 100000));

//		a) Lag en ny liste som kun inneholder etternavnene til de ansatte.
		List<String> ansatteLastname = ansatte.stream().map(a -> a.getEtternavn()).collect(Collectors.toList());
		System.out.println(ansatteLastname);
		System.out.println();

//		b) Finn ut antall kvinner blant de ansatte.
		long womenCount = ansatte.stream().filter(a -> a.getKjonn().equals(Kjonn.KVINNE)).count();
		System.out.println(womenCount);
		System.out.println();

//		c) Regn ut gjennomsnittslønnen til kvinnene.
		int averageSalary = (int) ansatte.stream().filter(a -> a.getKjonn().equals(Kjonn.KVINNE))
				.mapToInt(a -> a.getAarslonn()).average().orElse(0);
		System.out.println(averageSalary);
		System.out.println();

//		d) Gi alle sjefer (stilling inneholder noe med "sjef") en lønnsøkning på 7% ved å
//		bruke streams direkte i stedet for metoden du laget i Oppg2. Skriv ut listen av
//		ansatte etter lønnsøkningen.

		List<Integer> bossSalary = ansatte.stream().filter(a -> a.getStilling().toLowerCase().contains("sjef"))
				.map(a -> (a.getAarslonn() + (a.getAarslonn() / 100) * 7)).collect(Collectors.toList());
		System.out.println(bossSalary);
		System.out.println();

//		e) Finn ut (true|false) om det er noen ansatte som tjener mer enn 800.000,-
		boolean saleryMoreThen = ansatte.stream().anyMatch(a -> a.getAarslonn() > 800000);
		System.out.println(saleryMoreThen);
		System.out.println();

//		f) Skriv ut alle de ansatte med System.out.println() uten å bruke løkke.
		ansatte.stream().forEach(System.out::println);
		System.out.println();

//		g) Finn den/de ansatte som har lavest lønn.

		int lowestSalary = ansatte.stream().mapToInt(Ansatt::getAarslonn).min().getAsInt();
		List<Ansatt> emploeeWithLowestSalary = ansatte.stream().filter(a -> a.getAarslonn() == lowestSalary)
				.collect(Collectors.toList());

		System.out.println(emploeeWithLowestSalary);
		System.out.println();
		

//		h) Finn ut summen av alle heltall i [1, 1000> som er delelig med 3 eller 5.
		
		IntStream.range(1, 1000).filter(i -> i%3 == 0 || i%5 == 0).forEach(System.out::println);

	}

}
