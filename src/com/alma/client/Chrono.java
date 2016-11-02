package com.alma.client;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Chrono extends Thread{

	private int delay = 20000;
	private int precision = 100;
	private ClientImp proprio;
	
	
	
	public Chrono(ClientImp proprio) {
		super();
		this.proprio = proprio;
	}

	@Override
	public void run() {
		for (; delay>0;delay-=precision)
			try {
				sleep(precision);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		try {
			proprio.tempsEcoule();
		} catch (RemoteException e) {
		}
	}
	
	public int getCurrentChrono(){
		return delay;
	}
}
