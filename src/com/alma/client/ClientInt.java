package com.alma.client;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import com.alma.vente.Vente;

public interface ClientInt extends Remote, Serializable {

	void lookForServer() throws RemoteException;
	
	
	void demandeInscription() throws RemoteException;
	void majVente(Vente vente) throws RemoteException;
	void demarreChrono() throws RemoteException;
	void encherir() throws RemoteException;
	void tempsEcoule() throws RemoteException;
	void nouvelleVente(Vente vente) throws RemoteException;
	
	String getId() throws RemoteException;
}
