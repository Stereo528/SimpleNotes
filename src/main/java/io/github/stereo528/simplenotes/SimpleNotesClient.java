package io.github.stereo528.simplenotes;

import com.mojang.brigadier.CommandDispatcher;
import eu.midnightdust.lib.config.MidnightConfig;
import io.github.stereo528.simplenotes.commands.NoteCommand;
import io.github.stereo528.simplenotes.config.ModConfig;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.Commands;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.command.api.client.ClientCommandRegistrationCallback;
import org.quiltmc.qsl.command.api.client.QuiltClientCommandSource;

import static io.github.stereo528.simplenotes.SimpleNotes.MODID;

public class SimpleNotesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {
		MidnightConfig.init(MODID, ModConfig.class);

		ClientCommandRegistrationCallback.EVENT.register(SimpleNotesClient::registerCommands);
	}
	private static void registerCommands(CommandDispatcher<QuiltClientCommandSource> dispatcher, CommandBuildContext commandBuildContext, Commands.CommandSelection commandSelection) {
		NoteCommand.register(dispatcher);
	}
}
