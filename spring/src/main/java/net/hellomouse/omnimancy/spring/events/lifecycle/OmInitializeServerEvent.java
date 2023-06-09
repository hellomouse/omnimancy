package net.hellomouse.omnimancy.spring.events.lifecycle;

import org.springframework.context.ApplicationEvent;

public class OmInitializeServerEvent extends ApplicationEvent {
    public OmInitializeServerEvent(Object source) {
        super(source);
    }
}
