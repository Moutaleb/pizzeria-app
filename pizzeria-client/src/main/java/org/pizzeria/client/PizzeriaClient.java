package org.pizzeria.client;

import java.util.Scanner;
import java.util.logging.Level;

import org.apache.commons.codec.digest.DigestUtils;

import fr.pizzeria.domain.Client;

public class PizzeriaClient {

	public static void main(String[] args) {

		
		int saisie=0;
		Scanner sc = new Scanner(System.in);
		while(saisie!=99){
		System.out.println("***** Pizzeria Client *****");
		System.out.println("1. S’inscrire");
		System.out.println("2. Se connecter");
		System.out.println("99. Sortir");
		
	    saisie = sc.nextInt();
	    

		if(saisie==1){
			
			
			 System.out.println("Veillez saisir un nom :");
			 String nom = sc.next();
			 System.out.println("Veillez saisir un prenom :"); 
			 String prenom = sc.next();
			 
			 System.out.println("Veillez saisir un email :");
			 String email = sc.next();
			 
			 System.out.println("Veillez saisir un mot de passe :");
			 String mdp = DigestUtils.sha1Hex(sc.next());
			 
			 Client client = new Client (0,nom,prenom,email,mdp,null);
			 //System.out.println(nom+" "+prenom+" "+email+" "+mdp);
			 
			 
		}
		
		if(saisie==2){
			System.out.println("2. Se connecter");
			System.out.println("Veillez saisir un email :");
			 String email = sc.next();
			 System.out.println("Veillez saisir un mot de passe :");
			 String mdp = DigestUtils.sha1Hex(sc.next());
			 
			 
			 
			
		}

		if(saisie==99){
			System.out.println("Au revoir");
		}
	    
		}
		
		
	}

}
