package com.alma.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.alma.serveur.VenteInt;

public interface ClientInt extends Remote {
	/*
	 * méthode appelable par le serveur
	 */
	void majVente(VenteInt vente) throws RemoteException;
	void finVente(VenteInt vente) throws RemoteException;
	void nouvelleVente(VenteInt vente) throws RemoteException;
	String getId() throws RemoteException;
	//void demandeInscription() throws RemoteException;
	//void encherir() throws RemoteException;
	//void tempsEcoule() throws RemoteException;
}
