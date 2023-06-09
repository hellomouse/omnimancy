package net.hellomouse.omnimancy.spring.client;

import net.fabricmc.api.ClientModInitializer;
import net.hellomouse.omnimancy.spring.OmnimancySpringMod;

public class OmnimancySpringClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        OmnimancySpringMod.onInitializeClient(this);
    }
}
