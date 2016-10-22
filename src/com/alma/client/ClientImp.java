package com.alma.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.alma.chrono.Chrono;
import com.alma.serveur.ServeurInt;
import com.alma.vente.Vente;

public class ClientImp implements ClientInt {

	Chrono chrono;
	String urlServeur = "//localhost:8097/serv";
	ServeurInt serveur;
	private String id ;
	
	

	public ClientImp(String id) {
		super();
		this.setId(id);
	}


	public ClientImp(String id, String url) {
		super();
		this.setId(id);
		this.urlServeur = url;
	}

	@Override
	public void lookForServer() {
		try {
			serveur = (ServeurInt) Naming.lookup(urlServeur);
			System.out.println("Connexion effectué");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void demandeInscription() throws RemoteException {
		this.serveur.demandeInscription((ClientInt)this);
	}

	@Override
	public void majVente(Vente vente) {
		
	}


	@Override
	public void encherir() {
		
	}

	@Override
	public void tempsEcoule() {
		// TODO Auto-generated method stub

	}

	@Override
	public void nouvelleVente(Vente vente) {
		System.out.println("\t\t*** NOUVELLE VENTE RECUE****");
		System.out.println("Titre = \t"+vente.getArticle().getTitre());
		System.out.println("Prix Initiale = \t"+vente.getArticle().getPrixIni());
		System.out.println("****************************************");
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Override
	public void demarreChrono() {
		this.chrono = new Chrono();
		this.chrono.start();

	}
}
