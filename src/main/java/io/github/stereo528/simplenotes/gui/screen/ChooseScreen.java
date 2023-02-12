package io.github.stereo528.simplenotes.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.stereo528.simplenotes.SimpleNotes;
import io.github.stereo528.simplenotes.config.ModConfig;
import io.github.stereo528.simplenotes.gui.NotesButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ChooseScreen extends Screen {
	private final ResourceLocation BACKGROUND = new ResourceLocation(SimpleNotes.MODID, "textures/gui/notes_bg.png");
	public ChooseScreen() {
		super(Component.translatable("simplenotes.choose_screen.title"));
	}
	@Override
	public void init() {
		int x = this.width/2;
		int y = this.height/2;
		int xPos = x - 100;

		this.addRenderableWidget(new NotesButton(xPos, y-48, 200, 20,
			Component.translatable("simplenotes.quick_note_screen.title"),
			button -> Minecraft.getInstance().setScreen(new QuickNoteScreen(ChooseScreen.this))
		));
		this.addRenderableWidget(new NotesButton(xPos, y-24, 200, 20,
				Component.translatable("simplenotes.full_note_screen.title"),
				button -> Minecraft.getInstance().setScreen(new FullNoteScreen(ChooseScreen.this))
		));
		this.addRenderableWidget(new NotesButton(xPos, y, 200, 20,
				Component.translatable("simplenotes.coord_note_screen.title"),
				button -> Minecraft.getInstance().setScreen(new CoordNoteScreen(ChooseScreen.this))
		));
		this.addRenderableWidget(new NotesButton(xPos, y+24, 200, 20,
				Component.translatable("simplenotes.view_notes_screen.title"),
				button -> Minecraft.getInstance().setScreen(new ViewNoteScreen(ChooseScreen.this))
		));

		this.addRenderableWidget(new NotesButton(x-49, y+72, 98, 20,
				Component.translatable("simplenotes.button.exit"),
				button -> Minecraft.getInstance().setScreen(null)
		));
		super.init();
	}
	@Override
	public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
		this.renderBackground(poseStack);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, this.BACKGROUND);
		int x = (this.width - 250) / 2;
		int y = (this.height - 192) / 2;
		blit(poseStack, x, y, 0, 0, 250, 192);

		this.font.draw(poseStack, title, (int) ((this.width/2) - title.toString().length()), this.height/2 - 67, 16777215);

		super.render(poseStack, mouseX, mouseY, delta);
	}

	@Override
	public boolean isPauseScreen() {
		return ModConfig.notesPauseGame;
	}
}
