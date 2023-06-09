package net.hellomouse.omnimancy.books;

import com.mojang.serialization.Lifecycle;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.hellomouse.omnimancy.books.api.OmBook;
import net.hellomouse.omnimancy.spring.events.lifecycle.OmInitializeEvent;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.util.Identifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmBookStore {
    private List<OmBook> books = List.of();

    private static SimpleRegistry<OmBook> bookRegistry;

    public static Registry<OmBook> getBookRegistry() {
        return bookRegistry;
    }

    @Autowired(required = false)
    public void setBooks(List<OmBook> books) {
        this.books = books;
    }

    @EventListener
    public void onModInitialize(OmInitializeEvent event) {
        RegistryKey<Registry<OmBook>> key =
                RegistryKey.ofRegistry(
                        new Identifier(OmnimancyBooks.MODID, "books")
                );

        bookRegistry = FabricRegistryBuilder.createSimple(key)
                .attribute(RegistryAttribute.SYNCED)
                .buildAndRegister();

        books.forEach(omBook -> {
            bookRegistry.add(
                    RegistryKey.of(key, omBook.getId()),
                    omBook,
                    Lifecycle.stable()
            );
        });

        bookRegistry.streamEntries().forEach(System.out::println);
    }
}

