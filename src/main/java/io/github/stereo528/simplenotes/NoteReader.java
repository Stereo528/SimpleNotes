package io.github.stereo528.simplenotes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class NoteReader {
	private static File noteFile;
	public NoteReader() throws IOException {
		this.setNoteFile();
	}

	private void setNoteFile() throws IOException {
		noteFile = new File("SimpleNotes.txt");
		if(noteFile.createNewFile()) {
			noteFile.delete();
		}
	}

	public int getLatestNum() throws FileNotFoundException {
		Scanner file = new Scanner(noteFile);
		String latest = null;
		while(file.hasNextLine()) {
			latest = file.nextLine();
		}
		if(latest == null) {
			return -1;
		}
		return Integer.parseInt(latest.substring(0, latest.indexOf(".")));
	}
	public Note get() throws FileNotFoundException {
		return get(getLatestNum());
	}
	public Note get(int number) throws FileNotFoundException {
		Scanner file = new Scanner(noteFile);
		String note = null;
		while(file.hasNextLine()) {
			String line = file.nextLine();
			if(Integer.parseInt(line.substring(0, line.indexOf("."))) == number) {
				note = line;
				break;
			}
		}
		if(note == null || number == -1) {
			return new Note(-1, "No Note Could Be Found");
		}
		String text = note.substring(note.indexOf(".") + 2);
		return new Note(number, text);
	}
}

