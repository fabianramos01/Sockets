package controller;

import javax.swing.ImageIcon;

public enum Command {

	COMMAND_WORDS("COMMAND_WORDS", "Obtener palabras" , "/data/words.png"),
	COMMAND_FILE("COMMAND_FILE", "Obtener palabras" , "/data/file.png"),
	COMMAND_CLOCK("COMMAND_CLOCK", "Obtener palabras" , "/data/clock.png");
	
	private String command;
	private String title;
	private String pathImg;
	
	private Command(String command, String title, String pathImg) {
		this.command = command;
		this.title = title;
		this.pathImg = pathImg;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getTitle() {
		return title;
	}
	
	public ImageIcon getImg() {
		return new ImageIcon(getClass().getResource(pathImg));
	}
}