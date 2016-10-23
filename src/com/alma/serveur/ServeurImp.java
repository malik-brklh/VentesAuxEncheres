package com.alma.serveur;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import com.alma.client.ClientInt;
import com.alma.client.OffreInt;

public class ServeurImp extends UnicastRemoteObject implements ServeurInt, Serializable {

	List<ClientInt> clientsInscrits = new ArrayList<ClientInt>();
	List<ClientInt> clientsEnAttente = new ArrayList<ClientInt>();
	List<Article> articles = new ArrayList<Article>();

	enum etatVenteEnum {
		EnAttente, Encours, Fin
	};

	etatVenteEnum etatVente = etatVenteEnum.EnAttente;
	Vente venteActuelle;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws RemoteException {
		new ServeurImp();
	}

	public ServeurImp() throws RemoteException {

		LocateRegistry.createRegistry(port);

		try {
			Naming.bind(url, this);
		} catch (MalformedURLException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	synchronized public void demandeInscription(ClientInt c) throws RemoteException {
		System.out.println(c.getId() + " veut s'inscrire");
		this.clientsEnAttente.add(c);
		System.out.println("il y a " + this.clientsEnAttente.size() + " clients inscrit");
		if (etatVente == etatVenteEnum.EnAttente && clientsEnAttente.size() >= nbUserMin) {
			etatVente = etatVenteEnum.Encours;
			nouvelleVente();
		}

	}

	@Override
	synchronized public void enchirir(OffreInt offre) throws RemoteException {
		venteActuelle.majVente(offre.getClient(), offre.getNouveauPrix(), offre.getChrono());
		venteActuelle.incNbEnchirissement();
		if (venteActuelle.getNbEnchirissement() == this.clientsInscrits.size()) {
			finVente();
		} else
			for (ClientInt c : clientsInscrits) {
				c.majVente(venteActuelle);
			}

	}

	@Override
	public void tempsEcoule() throws RemoteException {
		this.venteActuelle.incNbEnchirissement();
		if (venteActuelle.getNbEnchirissement() == this.clientsInscrits.size()) {
			finVente();
		}
	}

	private void finVente() throws RemoteException {
		System.out.println("SERVEUR ---- vente termine");
		this.etatVente = etatVenteEnum.Fin;
		for (ClientInt c : clientsInscrits) {
			c.finVente(venteActuelle);
		}
		this.venteActuelle = null;
		this.etatVente = etatVenteEnum.EnAttente;
		// tester si il y'a un nombre de personne pour commencer une nouvelle
		// vente
		if (clientsEnAttente.size() >= nbUserMin) {
			etatVente = etatVenteEnum.Encours;
			nouvelleVente();
		}
	}

	public void nouvelleVente() throws RemoteException {
		System.out.println("nouvelle vente");
		for (ClientInt client : clientsEnAttente) {
			clientsInscrits.add(client);
		}
		for (ClientInt client : clientsInscrits) {
			clientsEnAttente.remove(client);
		}
		if (articles.isEmpty()) {
			articles.add(new Article((int) (Math.random() * 1000), "titre " + (int) (Math.random() * 1000),
					(int) (Math.random() * 1000)));
		}
		venteActuelle = new Vente(null, articles.get(0), 0, 0);
		articles.remove(0);
		for (ClientInt c : clientsInscrits) {
			c.nouvelleVente(venteActuelle);
		}

	}

}
