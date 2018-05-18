package view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class FrameHome extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final Font AGENCY_FB = new Font("Agency FB", Font.BOLD, 30);
	private DefaultListModel<String> listModel;
	private JList<String> list;
	
	public FrameHome(ArrayList<String> words) {
		setTitle("Client");
		setSize(400, 700);
		list = new JList<>();
		loadWords(words);
		add(new JScrollPane(list));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public void loadWords(ArrayList<String> words) {
		listModel = new DefaultListModel<>();
		for (String string : words) {
			listModel.addElement(string);
		}
		list.setFont(AGENCY_FB);
		list.setModel(listModel);
		revalidate();
	}
}