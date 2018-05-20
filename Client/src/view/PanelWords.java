package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import controller.Command;
import controller.ConstantList;

public class PanelWords extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<String> wordList;
	private DefaultListModel<String> listModel;
	private JSpinner spinner;

	public PanelWords(ActionListener listener) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		wordList = new JList<>();
		JPanel panel = new JPanel(new GridLayout(1, 2));
		spinner = new JSpinner(new SpinnerNumberModel(0, 0, 500, 1));
		spinner.setFont(ConstantList.AGENCY_FB);
		panel.add(spinner);
		panel.add(UtilityList.createJButton(Command.COMMAND_WORDS.getCommand(), Command.COMMAND_WORDS.getTitle(),
				Command.COMMAND_WORDS.getImg(), listener));
		add(panel, BorderLayout.NORTH);
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
	
	public int getWordNumber() {
		return Integer.parseInt(spinner.getValue().toString());
	}
}