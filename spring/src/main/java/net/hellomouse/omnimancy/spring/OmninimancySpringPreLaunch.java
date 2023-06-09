package net.hellomouse.omnimancy.spring;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.fabricmc.loader.impl.game.minecraft.MinecraftGameProvider;

public class OmninimancySpringPreLaunch implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        OmnimancySpringMod.onPreInitialize(this);
    }
}
