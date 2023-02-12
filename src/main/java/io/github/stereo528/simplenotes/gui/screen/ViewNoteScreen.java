package io.github.stereo528.simplenotes.gui.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.stereo528.simplenotes.SimpleNotes;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ViewNoteScreen extends BaseNoteScreen {
	private final ResourceLocation BACKGROUND = new ResourceLocation(SimpleNotes.MODID, "textures/gui/notes_bg.png");
	protected ViewNoteScreen(Screen parent) {
		super(Component.translatable("simplenotes.view_notes_screen.title"), parent);
	}

	@Override
	public void init() {}

	@Override
	public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {

	}
}
