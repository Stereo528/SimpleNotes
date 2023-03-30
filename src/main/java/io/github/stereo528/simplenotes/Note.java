package io.github.stereo528.simplenotes;

public class Note {
	private int number;
	private String text;
	public Note(int number, String text) {
		this.number = number;
		this.text = text;
	}

	public int getNumber() {
		return number;
	}
	public String getText() {
		return text;
	}
	public String toString() {
		return number + ". " + text;
	}
}
