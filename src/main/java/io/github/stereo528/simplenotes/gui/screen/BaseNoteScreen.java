package io.github.stereo528.simplenotes.gui.screen;

import io.github.stereo528.simplenotes.config.ModConfig;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class BaseNoteScreen extends Screen {
	protected final Screen parent;

	protected BaseNoteScreen(Component title, Screen parent) {
		super(title);
		this.parent = parent;
	}

	@Override
	public boolean isPauseScreen() {
		return ModConfig.notesPauseGame;
	}
}
