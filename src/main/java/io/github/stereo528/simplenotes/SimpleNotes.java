package io.github.stereo528.simplenotes;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleNotes implements ModInitializer {
	public static final String MODID = "simplenotes";
	public static final Logger LOGGER = LoggerFactory.getLogger("SimpleNotes");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello world from {}!", mod.metadata().name());
	}
}
