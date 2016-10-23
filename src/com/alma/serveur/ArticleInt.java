package com.alma.serveur;

import java.rmi.Remote;

public interface ArticleInt extends Remote {
	int getId();

	void setId(int id);

	String getTitre();

	void setTitre(String titre);

	int getPrixIni();

	void setPrixIni(int prixIni);

}
