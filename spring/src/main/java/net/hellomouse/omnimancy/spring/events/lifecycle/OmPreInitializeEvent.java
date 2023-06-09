package net.hellomouse.omnimancy.spring.events.lifecycle;

import org.springframework.context.ApplicationEvent;

public class OmPreInitializeEvent extends ApplicationEvent {
    public OmPreInitializeEvent(Object source) {
        super(source);
    }
}
