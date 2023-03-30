package io.github.stereo528.simplenotes.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.stereo528.simplenotes.Note;
import io.github.stereo528.simplenotes.NoteCreator;
import io.github.stereo528.simplenotes.NoteReader;
import net.minecraft.network.chat.Component;
import org.quiltmc.qsl.command.api.client.QuiltClientCommandSource;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.mojang.brigadier.arguments.StringArgumentType.*;
import static com.mojang.brigadier.arguments.IntegerArgumentType.*;
import static org.quiltmc.qsl.command.api.client.ClientCommandManager.*;

public class NoteCommand {
	private static final NoteReader noteReader;
	private static final NoteCreator noteCreator = new NoteCreator();

	static {
		try {
			noteReader = new NoteReader();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void register(CommandDispatcher<QuiltClientCommandSource> dispatcher) {
		dispatcher.register(literal("note")
			.then(argument("read", integer())
				.executes(ctx -> {
					try {
						return readNote(ctx.getSource(), getInteger(ctx, "read"));
					} catch (FileNotFoundException e) {
						throw new RuntimeException(e);
					}
				}))
			.then(argument("write", greedyString())
				.executes(ctx -> createNote(ctx.getSource(), getString(ctx, "write")))
			));

	}

	private static int readNote(QuiltClientCommandSource source, int read) throws CommandSyntaxException, FileNotFoundException {
		Note note = noteReader.get(read);
		source.sendFeedback(Component.literal(note.toString()));
		return note.toString().length();
	}

	private static int readLatestNote(QuiltClientCommandSource source) throws FileNotFoundException {
		Note note = noteReader.get();
		source.sendFeedback(Component.literal(note.toString()));
		return note.toString().length();
	}

	private static int createNote(QuiltClientCommandSource source, String write) throws CommandSyntaxException {
		noteCreator.createNote(write);
		source.sendFeedback(Component.translatable("key.simplenotes.success"));
		return write.length();
	}
}
