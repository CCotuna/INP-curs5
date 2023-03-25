package hashSet;

import java.util.*;

public class AllVowels {
	
	public static boolean containsAllVowels(String str) {
		HashSet<Character> lista = new HashSet<Character>(10);
		lista.add('a'); 
		lista.add('e'); 
		lista.add('i'); 
		lista.add('o'); 
		lista.add('u'); 
		
		for(char i : str.toLowerCase().toCharArray()) {
			if(lista.contains(i)) {
				lista.remove(i);
			}
			
			if(lista.isEmpty())
				break;
		}
		if(lista.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Introdu textul pe care doresti sa verifici daca contine vocale:");
		String text = input.nextLine();
		
		System.out.println(containsAllVowels(text));
	}
}
