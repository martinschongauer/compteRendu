package com.soprasteria.javaxml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class LireComptes {

	public static void main(String[] args) {

        final String fileName = "comptes.xml";
        
        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(fileName);
            Document jdomDoc = (Document) builder.build(xmlFile);

            Element root = jdomDoc.getRootElement();
            List < Element > listOfComptes = root.getChildren("Comptes");
            
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

            // Listage de tous les comptes
            System.out.println(compteList);
            
            // Listage des comptes courants
            for(CompteBancaire cmpt: compteList) 
            {
            	if (cmpt.getTypeCompte() == "Courant")
            		System.out.println(cmpt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}