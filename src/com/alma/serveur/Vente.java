package com.alma.serveur;

import java.io.Serializable;

import com.alma.client.ClientInt;

public class Vente implements VenteInt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientInt acheteurActuel;
	private Article article;
	private int prixGagnant;
	private double tempsChrono;
	private int nbEnchirissement=0;
	
	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vente(ClientInt acheteurActuel, Article article, int prixGagnant, double tempsChrono) {
		super();
		this.acheteurActuel = acheteurActuel;
		this.article = article;
		this.prixGagnant = prixGagnant;
		this.tempsChrono = tempsChrono;
	}

	public void majVente(ClientInt acheteur, int prixPropose, double chrono) {
		if (acheteurActuel == null || prixPropose > prixGagnant
				|| (prixPropose == prixGagnant && chrono > tempsChrono)) {
			acheteurActuel = acheteur;
			prixGagnant = prixPropose;
			tempsChrono = chrono;
		}
	}

	public ClientInt getAcheteurActuel() {
		return acheteurActuel;
	}

	public void setAcheteurActuel(ClientInt acheteurActuel) {
		this.acheteurActuel = acheteurActuel;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getPrixGagnant() {
		return prixGagnant;
	}

	public void setPrixGagnant(int prixGagnant) {
		this.prixGagnant = prixGagnant;
	}

	public double getTempsChrono() {
		return tempsChrono;
	}

	public void setTempsChrono(double tempsChrono) {
		this.tempsChrono = tempsChrono;
	}

	public void incNbEnchirissement(){
		nbEnchirissement++;
	}
	public int getNbEnchirissement(){
		return this.nbEnchirissement;
	}
}
