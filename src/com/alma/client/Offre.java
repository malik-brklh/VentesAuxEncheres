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

	@Override
	public ClientInt getClient() {
		return client;
	}

	@Override
	public void setClient(ClientInt client) {
		this.client = client;
	}

	@Override
	public int getChrono() {
		return chrono;
	}

	@Override
	public void setChrono(int chrono) {
		this.chrono = chrono;
	}

	@Override
	public int getNouveauPrix() {
		return nouveauPrix;
	}

	@Override
	public void setNouveauPrix(int nouveauPrix) {
		this.nouveauPrix = nouveauPrix;
	}

}
