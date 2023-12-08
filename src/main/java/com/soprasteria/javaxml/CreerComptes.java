package com.soprasteria.javaxml;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;


public class CreerComptes {

	
	public static void main(String[] args) {
		
		myScanner myInput = new myScanner();
		
		 try {
             Document doc = new Document();
             doc.setRootElement(new Element("Comptes"));

             CompteBancaire c1 = myInput.LireDonnees();
             CompteBancaire c2 = myInput.LireDonnees();
             
             doc.getRootElement().addContent(createCompteXMLElement(c1));
             doc.getRootElement().addContent(createCompteXMLElement(c2));
             
             XMLOutputter xmlOutput = new XMLOutputter();
			 xmlOutput.output(doc, new FileWriter("comptes.xml"));
			 System.out.println("File saved!");
		 }
		 catch(IOException e)
		 {
			 System.out.println("IO problem");
		 }
		 finally {} 
	}

	
    private static Element createCompteXMLElement(CompteBancaire compte) {
        Element compteElement = new Element("Compte");
        
        compteElement.addContent(new Element("nom_proprietaire").setText(compte.getNomProprietaire()));
        compteElement.addContent(new Element("date_creation").setText(compte.getDateCreation()));
        compteElement.addContent(new Element("type_compte").setText(compte.getTypeCompte()));
        compteElement.addContent(new Element("num_compte").setText(""+compte.getNumCompte()));
        compteElement.addContent(new Element("solde").setText(""+compte.getSolde()));
        
        return compteElement;
    }
}
