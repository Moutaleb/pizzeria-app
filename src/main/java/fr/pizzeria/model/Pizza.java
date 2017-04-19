package fr.pizzeria.model;

import java.lang.reflect.Field;

public class Pizza {

	private int id;
	@ToString(TopUpperCase = true)
	private String code;
	@ToString(TopUpperCase = false)
	private String nom;
	@ToString(TopUpperCase = false)
	private double prix;
	@ToString(TopUpperCase = true)
	private CategoriePizza categoriePizza;
	private static int nbrPizza = 0; // enlever ?
	private static int generateId = 0; // ID unique

	public Pizza() {
		this.id = generateId++;
		nbrPizza++;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza categoriePizza) {
		this.id = generateId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
		nbrPizza++;
	}

	public static int getNbrPizza() {
		return nbrPizza;
	}

	public static void setNbrPizza(int nbrPizza) {
		Pizza.nbrPizza = nbrPizza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

	@Override
	public String toString() {

		String resultat = "";

		for (Field field : this.getClass().getDeclaredFields()) {

			ToString annotation = field.getAnnotation(ToString.class);
			if (annotation != null) {
				boolean toUpperCase = annotation.TopUpperCase();
				try {
					if (toUpperCase) {

						resultat += field.get(this).toString().toUpperCase();

					} else {
						resultat += field.get(this);
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}

		return "Cette pizza est de catégorie : " + categoriePizza;
	}

}
