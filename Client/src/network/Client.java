package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.FrameHome;

public class Client {

	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;

	public Client(String ip) {
		try {
			System.out.println("Conexion iniciada");
			socket = new Socket(ip, 2000);
			output = new DataOutputStream(socket.getOutputStream());
			input = new DataInputStream(socket.getInputStream());
			int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de palabras"));
			getWords(n);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getWords(int n) throws IOException {
		System.out.println("enviando datos...");
		output.writeUTF(Request.GET_WORDS.toString());
		output.writeInt(n);
		ArrayList<String> list = new ArrayList<>();
		if (input.readUTF().equals(Request.GET_WORDS.toString())) {
			for (int i = 0; i < n; i++) {
				list.add(input.readUTF());
//				new FrameHome(list);
			}
		}
		return list;
	}

	public String getServerHour() throws IOException {
		output.writeUTF(Request.GET_HOUR.toString());
		String hour = "";
		if (input.readUTF().equals(Request.GET_HOUR.toString())) {
			hour = input.readUTF();
		}
		return hour;
	}
	
	public File getFile() throws IOException {
		output.writeUTF(Request.GET_FILE.toString());
		File file = null;
		if (input.readUTF().equals(Request.GET_FILE.toString())) {
			byte[] fileArray = new byte[input.readInt()];
			input.readFully(fileArray);
			file = new File(input.readUTF());
			writeFile(file, fileArray);
		}
		return file;
	}
	
	private void writeFile(File file, byte[] array) throws IOException {
		FileOutputStream fOutputStream = new FileOutputStream(file);
		fOutputStream.write(array);
		fOutputStream.close();
	}

	public static void main(String[] args) {
		new Client("10.4.72.112");
	}
}
