package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {

	private Socket socket;
	
	public Client() {
		try {
			System.out.println("Conexion iniciada");
			socket = new Socket("localhost", 2000);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			System.out.println("enviando datos...");
			int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de palabras"));
			output.writeInt(n);
			DataInputStream input = new DataInputStream(socket.getInputStream());
			for (int i = 0; i < n; i++) {
				System.out.println(input.readUTF());
			}
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new Client();
	}
}
