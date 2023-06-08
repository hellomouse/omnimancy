package net.hellomouse.omnimancy.spring;

import net.fabricmc.api.ModInitializer;
import net.hellomouse.omnimancy.spring.events.lifecycle.OmInitializeEvent;
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

    @Override
    public void onInitialize() {
        applicationContext.scan("net.hellomouse.omnimancy");
        applicationContext.refresh();

        applicationContext.publishEvent(new OmInitializeEvent(this));
    }
}
