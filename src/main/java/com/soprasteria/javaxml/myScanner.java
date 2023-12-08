package com.soprasteria.javaxml;

import java.util.Scanner;


public class myScanner {
	
	Scanner sc;
	
	
	public myScanner() {
		sc = new Scanner(System.in);
	}
	
	
	public int LireEntier(String message) {
	
		System.out.println(message);
		return Integer.parseInt(sc.nextLine());
	}
	
	
	public CompteBancaire LireDonnees() {
		
		System.out.println("Veuillez entrer un nom:");
		String nom = sc.nextLine();
		
		System.out.println("Veuillez entrer une date de creation:");
		String date = sc.nextLine();
		
		System.out.println("Veuillez entrer un type de compte (Epargne ou Courant):");
		String type = sc.nextLine();
		
		System.out.println("Veuillez entrer un numero de compte:");
		int numCompte = Integer.parseInt(sc.nextLine());
		
		System.out.println("Veuillez entrer un solde:");
		double solde =  Double.parseDouble(sc.nextLine());
		
		return new CompteBancaire(numCompte, nom, solde, date, type);
	}
}
