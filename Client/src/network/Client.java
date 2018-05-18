package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	private Socket socket;
	
	public Client() {
		try {
			System.out.println("Conexion iniciada");
			socket = new Socket("localhost", 2000);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			System.out.println("enviando datos...");
			output.writeUTF("hola");
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new Client();
	}
}
