package io.github.stereo528.simplenotes.gui;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;

public class NotesTextField extends EditBox {
	public NotesTextField(Font textRenderer, int x, int y, int width, int height, Component text) {
		super(textRenderer, x, y, width, height, text);
	}
}
