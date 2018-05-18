package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket serverSocket;
	
	public Server() throws IOException {
		serverSocket = new ServerSocket(2000);
		System.out.println("Server create at port 2000");
		waitForNewConnection();
	}
	
	public void waitForNewConnection() throws IOException {
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("New connection!");
			DataInputStream input = new DataInputStream(socket.getInputStream());
			System.out.println(input.readUTF());
			input.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}