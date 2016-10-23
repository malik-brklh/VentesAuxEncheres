package com.alma.client;

import java.rmi.Remote;

public interface OffreInt extends Remote {

	ClientInt getClient();

	void setClient(ClientInt client);

	int getChrono();

	void setChrono(int chrono);

	int getNouveauPrix();

	void setNouveauPrix(int nouveauPrix);
}
