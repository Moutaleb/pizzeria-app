package fr.pizzeria.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="numerocommande")
	private int numero_commande;
	
	@Column(name="statut")
	private String statut ;
	
	@Column(name="datecommande")
	private String date_commande;
	
	
	@ManyToOne
	private Livreur livreur;


	
	@ManyToOne
	private Client client;
	
	
	@ManyToMany
	@JoinTable(name="commande_pizza",
	joinColumns=
	@JoinColumn(name="commande_id", referencedColumnName="id"),
	inverseJoinColumns=
	@JoinColumn(name="pizza_id", referencedColumnName="id")
			)

	private Set<Pizza> pizzas;
	
	public Commande(int id, int numero_commande, String statut, String date_commande, int livreur_id, Client client, Livreur livreur ) {
	
		this.id = id;
		this.numero_commande = numero_commande;
		this.statut = statut;
		this.date_commande = date_commande;
		this.livreur = livreur;
		this.client = client;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumero_commande() {
		return numero_commande;
	}


	public void setNumero_commande(int numero_commande) {
		this.numero_commande = numero_commande;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public String getDate_commande() {
		return date_commande;
	}


	public void setDate_commande(String date_commande) {
		this.date_commande = date_commande;
	}


	public Livreur getLivreur() {
		return livreur;
	}


	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
