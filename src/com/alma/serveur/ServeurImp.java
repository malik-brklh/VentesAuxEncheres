package com.alma.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.SliderUI;

import com.alma.client.ClientInt;
import com.alma.vente.Article;
import com.alma.vente.Vente;

public class ServeurImp extends UnicastRemoteObject implements ServeurInt {

	
	List<ClientInt> clientsInscrits = new ArrayList<ClientInt>();
	List<ClientInt> clientsEnAttente = new ArrayList<ClientInt>();
	List<Article> articles = new ArrayList<Article>();
	
	int nbCliMin = 150;
	
	Vente venteActuelle;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServeurImp() throws RemoteException {
		super();
	}


	
	
	/*public ServeurImp() {
		super();
		clients = new ArrayList<ClientImp>();
	}
	*/
	
	@Override
	synchronized public void demandeInscription(ClientInt c) {
		this.clientsEnAttente.add(c);
	}

	@Override
	synchronized public void enchirir() {
		
	}

	@Override
	public void tempsEcoule() {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifClient() throws RemoteException {
		for (ClientInt c : clientsInscrits){
			c.majVente(venteActuelle);
		}
	}

	@Override
	public void nouvelleVente() throws RemoteException {
		
		
		if (articles.isEmpty()){
			articles.add(new Article((int)(Math.random()*1000),"titre "+(int)(Math.random()*1000),(int)(Math.random()*1000)));
		}
		venteActuelle = new Vente(null, clientsInscrits.size(), articles.get(0), 0, 0);
		articles.remove(0);
		for (ClientInt c : clientsInscrits){
			c.nouvelleVente(venteActuelle);
		}

		demarreChrono();
	}

	
	@Override
	public void validInscription() {
		
		for(ClientInt client : clientsEnAttente){
			clientsInscrits.add(client);
			clientsEnAttente.remove(client);
		}
		

	}

	@Override
	public void majVente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void demarreChrono() throws RemoteException {
		for (ClientInt c : clientsInscrits){
			c.demarreChrono();
		}

	}

	/*
	public void listerLesClient() throws RemoteException{
		for (ClientInt c : clientsEnAttente){
			System.out.println(c.getId());
	}
	}*/
}
