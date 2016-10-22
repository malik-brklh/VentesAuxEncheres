package com.alma.chrono;

public class Chrono extends Thread {

	int delay = 60000;
	int pricision = 100;
	
	
	
	@Override
	public void run() {
		for (delay=delay; delay>0;delay-=pricision)
			try {
				this.sleep(pricision);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public int getCurrentChrono(){
		return delay;
	}
}
