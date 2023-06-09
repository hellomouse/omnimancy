package net.hellomouse.omnimancy.spring;

import net.fabricmc.api.DedicatedServerModInitializer;

public class OmnimancySpringServerMod implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        OmnimancySpringMod.onInitializeServer(this);
    }
}
