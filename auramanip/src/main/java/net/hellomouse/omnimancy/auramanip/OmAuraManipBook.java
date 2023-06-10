package net.hellomouse.omnimancy.auramanip;

import io.wispforest.owo.itemgroup.OwoItemGroup;
import net.hellomouse.omnimancy.books.api.OmBook;
import net.minecraft.util.Identifier;
import org.springframework.stereotype.Component;

@Component
public class OmAuraManipBook implements OmBook {
    @Override
    public Identifier getId() {
        return Identifier.of(OmnimancyAuraManipulation.MODID, "aura-manipulation");
    }

    @Override
    public Identifier getItemId() {
        return Identifier.of(OmnimancyAuraManipulation.MODID, "aura-manipulation-book");
    }

    @Override
    public OwoItemGroup getItemGroup() {
        return null;
    }

    @Override
    public String getTitleTranslationKey() {
        return "omnimancy.auramanip.book.auramanip";
    }
}
