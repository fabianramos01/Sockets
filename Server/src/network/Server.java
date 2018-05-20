package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import persistence.FileManager;

public class Server {

	private ServerSocket serverSocket;
	private ArrayList<String> words;
	
	public Server() throws IOException {
		serverSocket = new ServerSocket(2000);
		System.out.println("Server create at port 2000");
		words = FileManager.loadWords();
		waitForNewConnection();
	}
	
	public void waitForNewConnection() throws IOException {
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("New connection!");
			new Connection(socket, this);
		}
	}
	
	public ArrayList<String> getWords() {
		return words;
	}
	
	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}