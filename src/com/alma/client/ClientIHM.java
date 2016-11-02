package com.alma.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ClientIHM extends JFrame{

	private JTextArea console;
	private JPanel conteneur;
	private JButton enchBut;
	private ClientImp clientImp;
	public ClientIHM(ClientImp clientImp) {

		this.clientImp = clientImp;
		
		conteneur = new JPanel();
		conteneur.setBackground(null);
		conteneur.setOpaque(true);
		setSize(600, 600);
		setContentPane(conteneur);
		setTitle(clientImp.getId());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		console = new JTextArea();
		console.setSize(500	, 500);
		console.setEditable(true);
		console.setLocation(0,0);
		enchBut = new JButton("Encherir");
		enchBut.setLocation(520	, 0);
		
		enchBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					clientImp.encherir(50);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		conteneur.add(enchBut);
		conteneur.add(console);
		conteneur.repaint();
	}
	
	void printConsole(String t){
		console.append("\n"+t);
	//	System.out.println(t);
	}
}
