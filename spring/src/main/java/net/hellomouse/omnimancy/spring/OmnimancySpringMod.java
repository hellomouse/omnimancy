package net.hellomouse.omnimancy.spring;

import net.fabricmc.api.ModInitializer;
import net.hellomouse.omnimancy.spring.events.lifecycle.OmInitializeClientEvent;
import net.hellomouse.omnimancy.spring.events.lifecycle.OmInitializeEvent;
import net.hellomouse.omnimancy.spring.events.lifecycle.OmInitializeServerEvent;
import net.hellomouse.omnimancy.spring.events.lifecycle.OmPreInitializeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OmnimancySpringMod implements ModInitializer {
    public static Logger LOG = LoggerFactory.getLogger("omnimancy-spring");

    private static AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext();

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void onPreInitialize(Object source) {
        applicationContext.scan("net.hellomouse.omnimancy");
        applicationContext.refresh();

        applicationContext.publishEvent(new OmPreInitializeEvent(source));
    }

    public static void onInitializeServer(Object source) {
        applicationContext.publishEvent(new OmInitializeServerEvent(source));
    }

    public static void onInitializeClient(Object source) {
        applicationContext.publishEvent(new OmInitializeClientEvent(source));
    }

    @Override
    public void onInitialize() {
        applicationContext.publishEvent(new OmInitializeEvent(this));
    }
}
