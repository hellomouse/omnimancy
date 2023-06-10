package net.hellomouse.omnimancy.auramanip;

import net.hellomouse.omnimancy.spring.events.lifecycle.OmInitializeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class OmPlayerAuraServiceImpl {
    private static OmPlayerAuraServiceImpl instance = null;

    public static OmPlayerAuraServiceImpl getInstance() {
        return instance;
    }

    @EventListener
    public void onInitialize(OmInitializeEvent event) {
        instance = this;
    }
}
