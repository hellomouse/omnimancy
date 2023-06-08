package net.hellomouse.omnimancy.spring.events.lifecycle;

import org.springframework.context.ApplicationEvent;

public class OmInitializeEvent extends ApplicationEvent {
    public OmInitializeEvent(Object source) {
        super(source);
    }
}
