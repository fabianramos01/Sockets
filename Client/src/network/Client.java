package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.FrameHome;

public class Client {

	private Socket socket;
	
	public Client() {
		try {
			System.out.println("Conexion iniciada");
			socket = new Socket("10.4.72.112", 2000);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			System.out.println("enviando datos...");
			int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de palabras"));
			output.writeInt(n);
			readWords(n);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readWords(int n) throws IOException {
		DataInputStream input = new DataInputStream(socket.getInputStream());
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(input.readUTF());
		}
		input.close();
		new FrameHome(list);
	}
	
	
	public static void main(String[] args) {
		new Client();
	}
}
