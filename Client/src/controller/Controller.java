package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
	
	private void getWords() {
		try {
			frameHome.loadWords(client.getWords(frameHome.getWordNumber()));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Command.valueOf(e.getActionCommand())) {
		case COMMAND_CLOCK:
			break;
		case COMMAND_FILE:
			break;
		case COMMAND_WORDS:
			getWords();
			break;
		}
	}
}