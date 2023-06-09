package net.hellomouse.omnimancy.spring.events.lifecycle;

import org.springframework.context.ApplicationEvent;

public class OmInitializeClientEvent extends ApplicationEvent {
    public OmInitializeClientEvent(Object source) {
        super(source);
    }
}
