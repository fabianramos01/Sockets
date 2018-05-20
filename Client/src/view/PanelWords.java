package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.ConstantList;

public class PanelWords extends JPanel{

	private static final long serialVersionUID = 1L;
	private JList<String> wordList;
	private DefaultListModel<String> listModel;

	public PanelWords(ActionListener listener) {
		setLayout(new BorderLayout());
		wordList = new JList<>();
		add(new JScrollPane(wordList), BorderLayout.CENTER);
	}
	
	public void loadWords(ArrayList<String> words) {
		listModel = new DefaultListModel<>();
		for (String string : words) {
			listModel.addElement(string);
		}
		wordList.setFont(ConstantList.AGENCY_FB);
		wordList.setModel(listModel);
		revalidate();
	}
}