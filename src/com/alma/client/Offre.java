package com.alma.client;

import java.io.Serializable;

public class Offre implements OffreInt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientInt client;
	private int chrono;
	private int nouveauPrix;

	public Offre(ClientInt client, int chrono, int nouveauPrix) {
		super();
		this.setClient(client);
		this.setChrono(chrono);
		this.setNouveauPrix(nouveauPrix);
	}

	public ClientInt getClient() {
		return client;
	}

	public void setClient(ClientInt client) {
		this.client = client;
	}

	public int getChrono() {
		return chrono;
	}

	public void setChrono(int chrono) {
		this.chrono = chrono;
	}

	public int getNouveauPrix() {
		return nouveauPrix;
	}

	public void setNouveauPrix(int nouveauPrix) {
		this.nouveauPrix = nouveauPrix;
	}

}
