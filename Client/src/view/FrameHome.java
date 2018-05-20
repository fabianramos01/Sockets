package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Command;
import controller.ConstantList;

public class FrameHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelWords panelWords;
	private JLabel labelHour;

	public FrameHome(ActionListener listener) {
		setTitle(ConstantList.APP_NAME);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.APP_ICON)).getImage());
		setSize(ConstantList.WIDTH_FRAME, ConstantList.HEIGHT_FRAME);
		init(listener);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	private void init(ActionListener listener) {
		setJMenuBar(new MenuBarUser(listener));
		addPanelHour(listener);
		panelWords = new PanelWords(listener);
		add(panelWords, BorderLayout.CENTER);
		addPanelFile(listener);
	}

	private void addPanelHour(ActionListener listener) {
		JPanel panel = new JPanel(new GridLayout(1, 3));
		panel.add(UtilityList.createJLabel(ConstantList.SERVER_HOUR, ConstantList.AGENCY_FB, Color.BLACK));
		panel.add(UtilityList.createJButton(Command.COMMAND_CLOCK.getCommand(), Command.COMMAND_CLOCK.getTitle(),
				Command.COMMAND_CLOCK.getImg(), listener));
		labelHour = UtilityList.createJLabel("", ConstantList.AGENCY_FB, Color.BLACK);
		labelHour.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.add(labelHour);
		add(panel, BorderLayout.NORTH);
	}
	
	private void addPanelFile(ActionListener listener) {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.add(UtilityList.createJLabel(ConstantList.SERVER_FILE, ConstantList.AGENCY_FB, Color.BLACK));
		panel.add(UtilityList.createJButton(Command.COMMAND_FILE.getCommand(), Command.COMMAND_FILE.getTitle(),
				Command.COMMAND_FILE.getImg(), listener));
		add(panel, BorderLayout.SOUTH);
	}

	public void loadWords(ArrayList<String> words) {
		panelWords.loadWords(words);
		revalidate();
	}

	public int getWordNumber() {
		return panelWords.getWordNumber();
	}
	
	public void setHour(String hour) {
		labelHour.setText(hour);
	}
}