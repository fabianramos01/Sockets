package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

import model.MyThread;
import persistence.FileManager;

public class Connection extends MyThread {

	private DataInputStream input;
	private DataOutputStream output;
	private Socket socket;

	public Connection(Socket socket) {
		super("", 1000);
		this.socket = socket;
		try {
			input = new DataInputStream(this.socket.getInputStream());
			output = new DataOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		start();
	}

	private void sendWords() throws IOException {
		int n = input.readInt();
		output.writeUTF(Request.GET_WORDS.toString());
		ArrayList<String> words = FileManager.loadWords();
		if (n <= words.size()) {
			for (int i = 0; i < n; i++) {
				output.writeUTF(words.get(i));
			}
		}
	}

	private void sendHour() throws IOException {
		output.writeUTF(Request.GET_HOUR.toString());
		Calendar calendar = Calendar.getInstance();
		String am_pm = calendar.get(Calendar.AM_PM) == 1 ? "pm" : "am";
		output.writeUTF(calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":"
				+ calendar.get(Calendar.SECOND) + " " + am_pm);
	}

	private void sendFile() throws IOException {
		output.writeUTF(Request.GET_FILE.toString());
		File file = new File(ConstantList.SEND_FILE);
		byte[] array = new byte[(int) file.length()];
		readFile(file, array);
		output.writeUTF(file.getName());
		output.writeInt(array.length);
		output.write(array);
	}

	private void readFile(File file, byte[] array) throws IOException {
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(array);
		inputStream.close();
	}
	
	private void managerRequest(String request) throws IOException {
		switch (Request.valueOf(request)) {
		case GET_HOUR:
			sendHour();
			break;
		case GET_FILE:
			sendFile();
			break;
		case GET_WORDS:
			sendWords();
			break;
		}
	}

	@Override
	public void execute() {
		String request;
		try {
			request = input.readUTF();
			if (request != null) {
				managerRequest(request);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			stop();
		}
	}
}