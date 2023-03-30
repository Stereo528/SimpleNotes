package io.github.stereo528.simplenotes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NoteCreator {
	public NoteCreator() {}
	public void createNote(String text) {
		try {
			File noteFile = new File("SimpleNotes.txt");
			if(noteFile.createNewFile()) {
				FileWriter noteWriter = new FileWriter("SimpleNotes.txt");
				noteWriter.append("0. ").append(text).append("\n");
				noteWriter.close();
			} else {
				NoteReader noteReader = new NoteReader();
				int latest = noteReader.getLatestNum();
				FileWriter noteWriter = new FileWriter("SimpleNotes.txt");
				if(latest == -1) {
					noteWriter.append("0. ").append(text).append("\n");
				} else {
					noteWriter.append(String.valueOf(latest + 1)).append(". ").append(text).append("\n");
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
