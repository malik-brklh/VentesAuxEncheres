package com.alma.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.alma.serveur.VenteInt;

public interface ClientInt extends Remote {
	
	void majVente(VenteInt vente) throws RemoteException;
	void finVente(VenteInt vente) throws RemoteException;
	void nouvelleVente(VenteInt vente) throws RemoteException;
	String getId() throws RemoteException;
}
