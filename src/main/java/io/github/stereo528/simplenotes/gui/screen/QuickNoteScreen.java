package io.github.stereo528.simplenotes.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.stereo528.simplenotes.SimpleNotes;
import io.github.stereo528.simplenotes.gui.NotesButton;
import io.github.stereo528.simplenotes.gui.NotesTextField;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class QuickNoteScreen extends BaseNoteScreen{
	private final ResourceLocation BACKGROUND = new ResourceLocation(SimpleNotes.MODID, "textures/gui/notes_bg.png");
	protected QuickNoteScreen(Screen parent) {
		super(Component.translatable("simplenotes.quick_note_screen.title"), parent);
	}
	private final Component name = Component.translatable("simplenotes.text_field.name");
	private final Component desc = Component.translatable("simplenotes.text_field.text_desc");
	@Override
	public void init() {
		int x = this.width/2;
		int y = this.height/2;
		int xPos = x - 100;


		this.addRenderableWidget(new NotesTextField(this.font, xPos, y-24, 200, 20,
			Component.translatable("simplenotes.text_field.name")
		));
		this.addRenderableWidget(new NotesTextField(this.font, xPos, y+16, 200, 20,
				Component.translatable("simplenotes.text_field.text_desc")
		));
		this.addRenderableWidget(new NotesButton(x-49, y+48, 98, 20,
				Component.translatable("simplenotes.button.exit"),
				button -> Minecraft.getInstance().setScreen(null)
		));
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

		this.font.draw(poseStack, title, (int) ((this.width/2) - title.toString().length()/4)-5, this.height/2 - 67, 16777215);
		this.font.draw(poseStack, name, (int) ((this.width/2) - name.toString().length()/4)+4, this.height/2 - 36, 16777215);
		this.font.draw(poseStack, desc, (int) ((this.width/2) - desc.toString().length()/4)-4, this.height/2 + 6, 16777215);

		super.render(poseStack, mouseX, mouseY, delta);
	}
}
