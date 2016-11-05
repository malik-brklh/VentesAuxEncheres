package com.alma.client;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.alma.serveur.ServeurInt;
import com.alma.serveur.VenteInt;

public class ClientImp extends UnicastRemoteObject /* JFrame */ implements ClientInt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Chrono chrono;
	private ServeurInt serveur;
	private String id;
	private VenteInt venteActuelle;

	private ClientIHM ihm;

	public static void main(String[] args) throws RemoteException {
		new ClientImp("client " + ((int) (Math.random() * 1000)));
	}

	public ClientImp(String id) throws RemoteException {

		this.setId(id);
		ihm = new ClientIHM(this);

		connexion();
	}

	private void printConsole(String t) {
		ihm.printConsole(t);
	}

	public void connexion() {
		printConsole(this.getId() + " se connecte ...");
		try {
			serveur = (ServeurInt) Naming.lookup(ServeurInt.url);
			printConsole("Connexion effectué");
			serveur.demandeInscription(this);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			printConsole("Connexion échoué");
		}

	}

	@SuppressWarnings("deprecation")
	public void encherir(int marge) throws RemoteException {
		chrono.aEncheri();
		if (this.venteActuelle == null) {
			printConsole("pas de vente");
		} else if (chrono == null) {
			printConsole("pas de chrono");
		} else {
			printConsole("creation offre");
			OffreInt offre = new Offre(this, chrono.getCurrentChrono(), venteActuelle.getPrixGagnant() + marge);
			printConsole("offre creee -ancien prix " + venteActuelle.getPrixGagnant() + " - prix proposé "
					+ venteActuelle.getPrixGagnant() + marge);
			this.serveur.enchirir(offre);
		}
	}

	public void tempsEcoule() throws RemoteException {
		printConsole(id + " : temps ecoule");
		serveur.tempsEcoule(id);
		// }
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
		printConsole("client " + id + "\t*** NOUVELLE VENTE RECUE****");
		printConsole("Titre = \t" + venteActuelle.getArticle().getTitre());
		printConsole("Prix Initiale = \t" + venteActuelle.getArticle().getPrixIni());
		printConsole("****************************************");
		demarreChrono();
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void finVente(VenteInt vente) throws RemoteException {
		majVente(vente);
		if (vente.getAcheteurActuel().getId() == id) {
			printConsole("PERSONNE N'A ACHETE CET ARTICLE");
		} else if (vente.getAcheteurActuel().getId() == id)
			printConsole("BRAVO VOUS AVEZ GAGNE L'ENCHERE");
		else
			printConsole("Dommage pour vous, " + vente.getAcheteurActuel().getId() + " a remporte l'enchere");
		printConsole("Article : " + vente.getArticle().getTitre() + "\tPrix : " + vente.getPrixGagnant());

	}
}
