package com.alma.client;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.alma.serveur.ServeurInt;
import com.alma.serveur.VenteInt;

public class ClientImp /* extends UnicastRemoteObject */ implements ClientInt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Chrono chrono;
	private ServeurInt serveur;
	private String id;
	private VenteInt venteActuelle;

	public ClientImp(String id) throws RemoteException {
		this.setId(id);
		chrono = null;
		serveur = null;
		venteActuelle = null;

	}

	public void connexion() {
		System.out.println(this.getId() + " se connecte ...");
		try {
			serveur = (ServeurInt) Naming.lookup(ServeurInt.url);
			System.out.println("Connexion effectué");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			serveur = null;
		}

	}

	public void demandeInscription() throws RemoteException {
		this.serveur.demandeInscription((ClientInt) this);
	}

	public void encherir(int marge) throws RemoteException {
		if (this.venteActuelle == null) {
			System.out.println("pas de vente");
		} else if (chrono == null) {
			System.out.println("pas de chrono");
		} else {
			OffreInt offre = new Offre(this, chrono.getCurrentChrono(), venteActuelle.getPrixGagnant() + marge);
			this.serveur.enchirir(offre);
		}
	}

	public void tempsEcoule() throws RemoteException {
		System.out.println(id + " : temps ecoule");
		serveur.tempsEcoule();
	}

	public void setId(String id) {
		this.id = id;
	}

	public void demarreChrono() {
		this.chrono = new Chrono(this);
		this.chrono.start();

	}

	@Override
	public void majVente(VenteInt vente) {

		venteActuelle = vente;
	}

	@Override
	public void nouvelleVente(VenteInt vente) {
		this.venteActuelle = vente;
		System.out.println("client "+id+"\t*** NOUVELLE VENTE RECUE****");
		System.out.println("Titre = \t" + venteActuelle.getArticle().getTitre());
		System.out.println("Prix Initiale = \t" + venteActuelle.getArticle().getPrixIni());
		System.out.println("****************************************");
		demarreChrono();
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void finVente(VenteInt vente) throws RemoteException {
		majVente(vente);
		if (vente.getAcheteurActuel() == null) {
			System.out.println("PERSONNE N'A ACHETE CET ARTICLE");
		} else if (vente.getAcheteurActuel() == this)
			System.out.println("BRAVO VOUS AVEZ GAGNE L'ENCHERE");
		else
			System.out.println("Dommage pour vous, " + vente.getAcheteurActuel().getId() + " a remporte l'enchere");
		System.out.println("Article : " + vente.getArticle().getTitre() + "\tPrix : " + vente.getPrixGagnant());

	}
}
