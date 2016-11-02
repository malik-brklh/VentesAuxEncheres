package com.alma.serveur;

import java.io.Serializable;

public class Article implements ArticleInt,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String titre;
	private int prixIni;
	
	public Article(int id, String titre, int prixIni) {
		super();
		this.id = id;
		this.titre = titre;
		this.prixIni = prixIni;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getTitre() {
		return titre;
	}

	@Override
	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public int getPrixIni() {
		return prixIni;
	}

	@Override
	public void setPrixIni(int prixIni) {
		this.prixIni = prixIni;
	}
	
	
	
}
