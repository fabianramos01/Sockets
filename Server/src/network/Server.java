package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
			request(new DataInputStream(socket.getInputStream()), new DataOutputStream(socket.getOutputStream()));
		}
	}
	
	private void request(DataInputStream input, DataOutputStream output) throws IOException {
		switch (Request.valueOf(input.readUTF())) {
		case GET_HOUR:
			
			break;
		case GET_FILE:
			break;
		case GET_WORDS:
			int n = input.readInt();
			System.out.println(n);
			sendWords(n, output);
			break;
		}
	}
	
	private void sendWords(int n, DataOutputStream output) throws IOException {
		for (int i = 0; i < n; i++) {
			output.writeUTF(words.get(i));
		}
		output.close();
	}
	
	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}