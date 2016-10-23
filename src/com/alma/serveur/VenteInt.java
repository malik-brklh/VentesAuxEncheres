package com.alma.serveur;

import java.rmi.Remote;

import com.alma.client.ClientInt;

public interface VenteInt extends Remote {
	ClientInt getAcheteurActuel();
	void setAcheteurActuel(ClientInt acheteurActuel);
	Article getArticle();
	void setArticle(Article article);
	int getPrixGagnant();
	void setPrixGagnant(int prixGagnant);
	double getTempsChrono();
	void setTempsChrono(double tempsChrono);
}