package linkedList;

import java.util.*;

class Produs {
	private String nume;
	private double pret;
	
	public Produs(String nume, double pret) {
		this.nume = nume;
		this.pret = pret;
	}

	public double getPret() {
		return pret;
	}
	
}

class CosCumparaturi {
	private LinkedList<Produs> lista = new LinkedList<Produs>();
	
	public void adaugaProdus(Produs produs) {
		lista.add(produs);
	}
	
	public String calculeazaTotal() {
		double sum = 0;
		Iterator<Produs> iterator = lista.iterator();
		while(iterator.hasNext()) {
			sum += iterator.next().getPret();
		}
		return String.format("%.2f", sum); //rotunjeste + afiseaza cifrele - 'half-up rounding'
		
	}
	
	public String testCosCumparaturi() {
		CosCumparaturi cos = new CosCumparaturi();
		
		Produs produs1 = new Produs("Lapte", 19.5);
		Produs produs2 = new Produs("Branza", 40.8);
		Produs produs3 = new Produs("Paine", 17.9);
		Produs produs4 = new Produs("Castraveti", 14.9);
		cos.adaugaProdus(produs1);
		cos.adaugaProdus(produs2);
		cos.adaugaProdus(produs3);
		cos.adaugaProdus(produs4);
		
		return cos.calculeazaTotal();
	}
}
public class ShoppingCart {

	public static void main(String[] args) {
		CosCumparaturi cos = new CosCumparaturi();
		System.out.println(cos.testCosCumparaturi());

	}

}
