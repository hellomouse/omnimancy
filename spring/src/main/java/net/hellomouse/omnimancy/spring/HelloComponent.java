package net.hellomouse.omnimancy.spring;

import net.hellomouse.omnimancy.spring.events.lifecycle.OmInitializeEvent;
import net.hellomouse.omnimancy.spring.events.lifecycle.OmPreInitializeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HelloComponent {
    @EventListener
    public void onInitialize(OmInitializeEvent onInitialize) {
        OmnimancySpringMod.LOG.info("Hello!");
    }

    @EventListener
    public void onPreInitialize(OmPreInitializeEvent onPreInitialize) {
        OmnimancySpringMod.LOG.info("Pre init");
    }
}
