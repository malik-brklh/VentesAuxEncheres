package com.alma.vente;

import java.io.Serializable;

import com.alma.client.ClientInt;

public class Vente implements Serializable{

	private ClientInt acheteurActuel;
	private int nbAcheteur;
	private Article article;
	private int prixGagnant;
	private double tempsChrono;
	
	
	
	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Vente(ClientInt acheteurActuel, int nbAcheteur, Article article,
			int prixGagnant, double tempsChrono) {
		super();
		this.acheteurActuel = acheteurActuel;
		this.nbAcheteur = nbAcheteur;
		this.article = article;
		this.prixGagnant = prixGagnant;
		this.tempsChrono = tempsChrono;
	}

	public void majVente(ClientInt acheteur, int prixPropose, double chrono){
		if(acheteurActuel==null 
				|| prixPropose > prixGagnant
				|| (prixPropose == prixGagnant && chrono > tempsChrono)){
			acheteurActuel=acheteur;
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



	public int getNbAcheteur() {
		return nbAcheteur;
	}



	public void setNbAcheteur(int nbAcheteur) {
		this.nbAcheteur = nbAcheteur;
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
	
	
	
	
}
