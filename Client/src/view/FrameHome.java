package view;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controller.ConstantList;

public class FrameHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	
	public FrameHome() {
		setTitle("Client");
		setSize(400, 700);
		list = new JList<>();
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
		list.setFont(ConstantList.AGENCY_FB);
		list.setModel(listModel);
		revalidate();
	}
}