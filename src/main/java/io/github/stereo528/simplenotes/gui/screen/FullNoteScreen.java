package io.github.stereo528.simplenotes.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.stereo528.simplenotes.SimpleNotes;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class FullNoteScreen extends BaseNoteScreen{
	private final ResourceLocation BACKGROUND = new ResourceLocation(SimpleNotes.MODID, "textures/gui/notes_bg.png");
	protected FullNoteScreen(Screen parent) {
		super(Component.translatable("simplenotes.full_note_screen.title"), parent);
	}

	@Override
	public void init() {

	}

	@Override
	public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
		this.renderBackground(poseStack);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, this.BACKGROUND);
		int x = (this.width - 250) / 2;
		int y = (this.height - 150) / 2;
		blit(poseStack, x, y, 0, 0, 250, 150);

		this.font.draw(poseStack, title, (int) ((this.width/2) - title.toString().length()), this.height/2 - 67, 16777215);


		super.render(poseStack, mouseX, mouseY, delta);
	}
}
