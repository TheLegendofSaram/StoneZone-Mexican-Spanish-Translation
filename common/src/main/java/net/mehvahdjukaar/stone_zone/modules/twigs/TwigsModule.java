package net.mehvahdjukaar.stone_zone.modules.twigs;

import com.ninni.twigs.block.ColumnBlock;
import net.mehvahdjukaar.every_compat.api.RenderLayer;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.moonlight.api.misc.Registrator;
import net.mehvahdjukaar.moonlight.api.set.BlockType;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.mehvahdjukaar.stone_zone.modules.SZModule;
import net.mehvahdjukaar.stone_zone.type.StoneType;
import net.mehvahdjukaar.stone_zone.type.StoneTypeRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Collection;
import java.util.Objects;

//SUPPORT: v3.1.0+
public class TwigsModule extends SZModule {

    public final SimpleEntrySet<StoneType, Block> columns;

    public TwigsModule(String modId) {
        super(modId, "tw");

        columns = addEntry(SimpleEntrySet.builder(StoneType.class, "column",
                        getModBlock("stone_column"), () -> StoneTypeRegistry.STONE_TYPE,
                        stoneType -> new ColumnBlock(Utils.copyPropertySafe(
                                        (Objects.nonNull(stoneType.getBlockOfThis("bricks")))
                                        ? Objects.requireNonNull(stoneType.getBlockOfThis("bricks"))
                                        : Blocks.STONE_BRICKS)
                                )
                        )
                .addCustomItem((s,b,p)-> new BlockItem(b, p))
                .createPaletteFromChild("bricks")
                .addTexture(modRes("block/stone_column"))
                .addTexture(modRes("block/stone_column_bottom"))
                .addTexture(modRes("block/stone_column_tip"))
                .addTexture(modRes("block/stone_column_top"))
                .setTabKey(modRes("twig"))
                .setRenderType(RenderLayer.CUTOUT_MIPPED)
                .defaultRecipe()
                .addRecipe(modRes("stone_column_stonecutting"))
                .build()
        );

    }

    @Override
    public <T extends BlockType> void registerBlocks(Class<T> typeClass, Registrator<Block> registry, Collection<T> types) {
        super.registerBlocks(typeClass, registry, types);
    }
}
