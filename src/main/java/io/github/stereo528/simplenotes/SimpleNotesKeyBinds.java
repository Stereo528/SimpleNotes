package io.github.stereo528.simplenotes;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class SimpleNotesKeyBinds {
	public static final KeyMapping TOGGLE = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.simplenotes.open_selector", GLFW.GLFW_KEY_N, "key.simplenotes.simplenotes"));
	public static void init() {}
}
