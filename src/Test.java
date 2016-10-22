import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.alma.client.ClientImp;
import com.alma.serveur.ServeurImp;
import com.alma.serveur.ServeurInt;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServeurInt serveurImp ;//= new ServeurImp();
		int port = ServeurInt.port;
		String url = ServeurInt.url;
		
		try {
			LocateRegistry.createRegistry(port);
			serveurImp = new ServeurImp();
			Naming.bind(url,serveurImp);
			
			
			ClientImp clientImp1 = new ClientImp("1",url);
			ClientImp clientImp2 = new ClientImp("2",url);
			ClientImp clientImp3 = new ClientImp("3",url);
			
			
			clientImp1.lookForServer();
			clientImp2.lookForServer();
			clientImp3.lookForServer();

			clientImp1.demandeInscription();
			clientImp2.demandeInscription();
			clientImp3.demandeInscription();
			
		//	serveurImp.listerLesClient();
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}
	}
}


