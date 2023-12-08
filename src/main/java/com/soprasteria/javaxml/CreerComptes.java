package com.soprasteria.javaxml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;


public class CreerComptes {

	public static List <CompteBancaire> readListFromXML(String fileName) {
		
		try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(fileName);
            Document jdomDoc = (Document) builder.build(xmlFile);

            Element root = jdomDoc.getRootElement();
            List < Element > listOfComptes = root.getChildren("Compte");
            
            List <CompteBancaire> compteList = new ArrayList<CompteBancaire>();
            for(Element compteElement: listOfComptes) 
            {
            	CompteBancaire compte = new CompteBancaire();
            	compte.setNomProprietaire(compteElement.getChildText("nom_proprietaire"));
            	compte.setDateCreation(compteElement.getChildText("date_creation"));
            	compte.setTypeCompte(compteElement.getChildText("type_compte"));
            	compte.setNumCompte(Integer.parseInt(compteElement.getChildText("num_compte")));
            	compte.setSolde(Double.parseDouble(compteElement.getChildText("solde")));
                compteList.add(compte);
            }
            
            return compteList;

        } catch (Exception e) {
            e.printStackTrace();  
        }
		
		return null;
	}
	
	
	public static void printXML() {

		List <CompteBancaire> compteList = readListFromXML("comptes.xml");
		
        System.out.printf("Liste de tous les comptes:%n");
        for(CompteBancaire cmpt: compteList) {
        	System.out.println(cmpt);
        }
        
        System.out.printf("%nListe des comptes courants:%n");
        for(CompteBancaire cmpt: compteList) 
        {
        	if (cmpt.getTypeCompte().equals("Courant"))
        		System.out.println(cmpt);
        }
	}
	
	
	public static void writeListToXML(List <CompteBancaire> compteList) {
	
        Document doc = new Document();
        doc.setRootElement(new Element("Comptes"));

        for(CompteBancaire cmpt: compteList) {
        	doc.getRootElement().addContent(createCompteXMLElement(cmpt));
        }
        
        XMLOutputter xmlOutput = new XMLOutputter();
        
		try {
			xmlOutput.output(doc, new FileWriter("comptes.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("File saved!");
	}
	
	
	public static void createNewXML(myScanner myInput) {
		
		 try {
			List <CompteBancaire> compteList = new ArrayList<CompteBancaire>();
            compteList.add(myInput.LireDonnees());
            compteList.add(myInput.LireDonnees());
            writeListToXML(compteList);
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error while creating XML file");
		 }
		 finally {} 
		 
	}
	
	
	public static void supprimerCompte(myScanner myInput) {
		
		int numeroCompte = myInput.LireEntier("Entrez le numero:");
		List <CompteBancaire> compteList = readListFromXML("comptes.xml");
		
		// Find and delete the element
		for(CompteBancaire cmpt: compteList) {
        	if (cmpt.getNumCompte() == numeroCompte) {
        		compteList.remove(cmpt);
        		break;
        	}
        }
		
		writeListToXML(compteList);
	}

	
	public static void ajouterCompte(myScanner myInput) {
		
		List <CompteBancaire> compteList = readListFromXML("comptes.xml");
		
		try {
            compteList.add(myInput.LireDonnees());
            writeListToXML(compteList);
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error while adding an element");
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
    
    
    private static void printMenu() {
    	
    	System.out.printf("%n%n");
    	System.out.println("Veuillez entrer le code de l'action souhaitée:");
    	System.out.println("1 - Générer un nouveau XML avec deux comptes");
    	System.out.println("2 - Afficher le contenu du XML");
    	System.out.println("3 - Entrer un nouveau compte");
    	System.out.println("4 - Supprimer un compte");
    	System.out.println("5 - Ajouter un attribut à tous les éléments");
    	System.out.println("6 - Quitter");
    }
    
	
	public static void main(String[] args) {
		
		// Creer un scanner pour les communications avec l'utilisateur
		myScanner myInput = new myScanner();
		
		// Et entrer dans la boucle du menu principal
		while (true) {
			printMenu();
			int commande = myInput.LireEntier("Entrez le numero:");
			
			switch(commande) 
			{
				case 1: createNewXML(myInput);
						break;
						
				case 2: printXML();
						break;
						
				case 3: ajouterCompte(myInput);
						break;
						
				case 4: supprimerCompte(myInput);
						break;

				case 5: // nouvelAttribut(myInput);
						break;
						
				case 6: System.exit(0);
						break;
						
				default : break;
			}
		}
	}

}
