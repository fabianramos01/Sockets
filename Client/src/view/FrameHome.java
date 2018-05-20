package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FrameHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelWords panelWords;
	
	public FrameHome(ActionListener listener) {
		setTitle("Client");
		setSize(400, 700);
		panelWords = new PanelWords(listener);
		add(panelWords);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public void loadWords(ArrayList<String> words) {
		panelWords.loadWords(words);
		revalidate();
	}
}