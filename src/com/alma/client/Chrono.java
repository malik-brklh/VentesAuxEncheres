package com.alma.client;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Chrono extends Thread {

	private int delay = 20000;
	private int precision = 100;
	private ClientImp proprio;
	private boolean aEncheri = false;

	public Chrono(ClientImp proprio) {
		super();
		this.proprio = proprio;
	}

	public void aEncheri() {
		this.aEncheri = true;
	}

	@Override
	public void run() {
		for (; delay > 0 && !aEncheri; delay -= precision)
			try {
				sleep(precision);
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
		if (!aEncheri)
			try {
				proprio.tempsEcoule();
			} catch (RemoteException e) {
			}
	}

	public int getCurrentChrono() {
		return delay;
	}
}
