package com.alma.serveur;

import java.io.Serializable;

import com.alma.client.ClientInt;

public class Vente implements VenteInt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientInt acheteurActuel;
	private ArticleInt article;
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

	@Override
	public ClientInt getAcheteurActuel() {
		return acheteurActuel;
	}

	@Override
	public void setAcheteurActuel(ClientInt acheteurActuel) {
		this.acheteurActuel = acheteurActuel;
	}

	@Override
	public ArticleInt getArticle() {
		return article;
	}

	@Override
	public void setArticle(ArticleInt article) {
		this.article = article;
	}

	@Override
	public int getPrixGagnant() {
		return prixGagnant;
	}

	@Override
	public void setPrixGagnant(int prixGagnant) {
		this.prixGagnant = prixGagnant;
	}

	@Override
	public double getTempsChrono() {
		return tempsChrono;
	}

	@Override
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
