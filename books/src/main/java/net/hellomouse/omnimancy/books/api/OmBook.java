package net.hellomouse.omnimancy.books.api;

import net.minecraft.util.Identifier;

public interface OmBook {
    Identifier getId();
    String getTitleTranslationKey();
}
