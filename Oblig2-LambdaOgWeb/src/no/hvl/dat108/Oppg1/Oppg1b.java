package no.hvl.dat108.Oppg1;

import java.util.function.BiFunction;

public class Oppg1b {

	public static int beregn(int a, int b,  BiFunction<Integer, Integer, Integer> t) {
		 return t.apply(a, b);
	}

	public static void main(String[] args) {
		
		
		//i. Summen av 12 og 13
		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b; 
		System.out.println("Summen av 12 og 13: " + beregn(12, 13, add));
		
		
		//ii. Den største av -5 og 3
		BiFunction<Integer, Integer, Integer> biggest = (a, b) -> {
			if(a > b) return a;
			return b;
		}; 
		System.out.println("Den største av -5 og 3: " + beregn(-5, 3, biggest));
		
		//iii. Avstanden (absoluttverdien av differansen) mellom 54 og 45
		BiFunction<Integer, Integer, Integer> distance = (a, b) -> {
			if (a >= b) return a-b;
			return b-a;	
		};
		System.out.println("Avstanden (absoluttverdien av differansen) mellom 54 og 45: " + beregn(54, 45, distance));

	}


}
