package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.ConstantList;

public class FrameHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelWords panelWords;
	
	public FrameHome(ActionListener listener) {
		setTitle(ConstantList.APP_NAME);
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.APP_ICON)).getImage());
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
	
	public int getWordNumber() {
		return panelWords.getWordNumber();
	}
}