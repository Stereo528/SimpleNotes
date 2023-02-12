package io.github.stereo528.simplenotes.gui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class NotesButton extends Button {


	public NotesButton(int x, int y, int width, int height, Component message, OnPress onPress) {
		super(x, y, width, height, message, onPress, Button.DEFAULT_NARRATION);
	}
}
