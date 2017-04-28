package fr.pizzeria.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="motdepasse")
	private String mot_de_passe;
	
	@OneToMany
	private Set<Commande> commandes; 
	
	

	public Client(int id, String nom, String prenom, String email, String mot_de_passe, Set<Commande> commandes) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
		this.commandes = commandes;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMot_de_passe() {
		return mot_de_passe;
	}



	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}



	public Set<Commande> getCommandes() {
		return commandes;
	}



	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	
	
}
