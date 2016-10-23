import java.rmi.RemoteException;

import com.alma.client.ClientImp;


public class Test {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		
			ClientImp clientImp1 = new ClientImp("1");
			attente();
			ClientImp clientImp2 = new ClientImp("2");
			attente();
			ClientImp clientImp3 = new ClientImp("3");
			attente();
			
			clientImp1.connexion();
			attente();
			clientImp2.connexion();
			attente();
			clientImp3.connexion();
			attente();

			clientImp1.demandeInscription();
			attente();
			clientImp2.demandeInscription();
			attente();
			clientImp3.demandeInscription();
			attente(1000);
			
			clientImp1.encherir(50);
			
	}
	
	
	public static void attente(){
		try{
			Thread.currentThread();
			Thread.sleep(200);
		}catch(Exception e){}
	}
	public static void attente(int d){
		try{
			Thread.currentThread();
			Thread.sleep(d);
		}catch(Exception e){}
	}
}


