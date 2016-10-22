package com.alma.serveur;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import com.alma.client.ClientInt;

public interface ServeurInt extends Serializable, Remote{

	int port = 8088;
	String url = "//localhost:"+port+"/enchere";
	
	/**
	 * méthodes appelées par le client via RMI
	 */
	public void demandeInscription(ClientInt c) throws RemoteException;
	void enchirir() throws RemoteException;
	void tempsEcoule() throws RemoteException;
	
	/**
	 * méthodes internes au serveur
	 */
	void notifClient() throws RemoteException;
	void nouvelleVente() throws RemoteException;
	void validInscription() throws RemoteException;
	void majVente() throws RemoteException;
	void demarreChrono() throws RemoteException;
	/*public void listerLesClient() throws RemoteException;*/
	
	
}
