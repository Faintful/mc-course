package net.faintful.mccourse.event;

import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.faintful.mccourse.config.ModConfigs;
import net.faintful.mccourse.util.CustomTitleScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;

public class ReplaceTitleScreenEvent implements ScreenEvents.BeforeInit {
    @Override
    public void beforeInit(MinecraftClient client, Screen screen, int scaledWidth, int scaledHeight) {
        if(ModConfigs.REPLACE_TITLESCREEN && screen instanceof TitleScreen && !(screen instanceof CustomTitleScreen)) {
            client.setScreen(new CustomTitleScreen());
        }
    }
}