package com.soprasteria.javaxml;

public class CompteBancaire {

	private int numCompte;
	private String nomProprietaire;
	private double solde;
	private String dateCreation;
	private String typeCompte;
	
	
	public int getNumCompte() {
		return numCompte;
	}
	
	
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	
	
	public String getNomProprietaire() {
		return nomProprietaire;
	}
	
	
	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}
	
	
	public double getSolde() {
		return solde;
	}
	
	
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
	public String getDateCreation() {
		return dateCreation;
	}
	
	
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	public String getTypeCompte() {
		return typeCompte;
	}
	
	
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}


	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", nomProprietaire=" + nomProprietaire + ", solde=" + solde
				+ ", dateCreation=" + dateCreation + ", typeCompte=" + typeCompte + "]";
	}


	public CompteBancaire(int numCompte, String nomProprietaire, double solde, String dateCreation, String typeCompte) {
		super();
		this.numCompte = numCompte;
		this.nomProprietaire = nomProprietaire;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.typeCompte = typeCompte;
	}
	
	
	public CompteBancaire() {
		super();
		this.numCompte = 0;
		this.nomProprietaire = "Nom";
		this.solde = 0.0;
		this.dateCreation = "01/01/1970";
		this.typeCompte = "Epargne";
	}
	
}
