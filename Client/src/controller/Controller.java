package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import network.Client;
import view.FrameHome;

public class Controller implements ActionListener{

	private Client client;
	private FrameHome frameHome;
	
	public Controller() {
		connect();
		frameHome = new FrameHome(this);
	}
	
	private void connect() {
		String ip = JOptionPane.showInputDialog("Ingrese la IP del servidor");
		client = new Client(ip);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}