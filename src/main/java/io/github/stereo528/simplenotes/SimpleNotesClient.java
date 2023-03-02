package io.github.stereo528.simplenotes;

import eu.midnightdust.lib.config.MidnightConfig;
import io.github.stereo528.simplenotes.config.ModConfig;
import io.github.stereo528.simplenotes.gui.screen.ChooseScreen;
import net.minecraft.client.Minecraft;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;

import static io.github.stereo528.simplenotes.SimpleNotes.MODID;

public class SimpleNotesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {

		MidnightConfig.init(MODID, ModConfig.class);
	}
}
