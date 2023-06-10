package net.hellomouse.omnimancy.books.api;

import io.wispforest.owo.itemgroup.OwoItemGroup;
import net.minecraft.util.Identifier;

public interface OmBook {
    Identifier getId();
    Identifier getItemId();
    OwoItemGroup getItemGroup();
    String getTitleTranslationKey();
}
