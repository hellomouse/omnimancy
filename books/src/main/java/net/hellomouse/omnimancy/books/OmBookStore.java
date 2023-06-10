package net.hellomouse.omnimancy.books;

import com.mojang.serialization.Lifecycle;
import io.wispforest.lavender.book.BookItem;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.nbt.NbtKey;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.hellomouse.omnimancy.books.api.OmBook;
import net.hellomouse.omnimancy.spring.events.lifecycle.OmInitializeEvent;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmBookStore {
    private List<OmBook> books = List.of();

    private static final NbtKey<Boolean> SANDWICH = new NbtKey<>("Sandwich", NbtKey.Type.BOOLEAN);

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

        bookRegistry.streamEntries().forEach(bookRef -> {
            OmBook book = bookRef.value();

            BookItem bookItem = new BookItem(
                    new OwoItemSettings()
                            .maxCount(1)
                            .group(book.getItemGroup()),
                    book.getId()
            ) {
                @Override
                public ActionResult useOnBlock(ItemUsageContext context) {
                    if (!context.getPlayer().isSneaking()) return ActionResult.PASS;
                    if (!context.getWorld().getBlockState(context.getBlockPos()).isOf(Blocks.SNOW_BLOCK)) return ActionResult.PASS;

                    context.getStack().mutate(SANDWICH, sandwich -> !sandwich);

                    return ActionResult.SUCCESS;
                }

                @Override
                public Text getName(ItemStack stack) {
                    return stack.getOr(SANDWICH, false)
                            ? Text.translatable(book.getTitleTranslationKey())
                            : super.getName(stack);
                }
            };

            Registry.register(Registries.ITEM, book.getItemId(), bookItem);
        });
    }
}

