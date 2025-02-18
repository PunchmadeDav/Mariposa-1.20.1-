package dev.doctor4t.mariposa.datagen;

import dev.doctor4t.mariposa.Mariposa;
import dev.doctor4t.mariposa.index.MariposaBlocks;
import dev.doctor4t.mariposa.index.MariposaItems;
import dev.doctor4t.mariposa.index.MariposaTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class MariposaRecipeGen extends FabricRecipeProvider {
    public MariposaRecipeGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerPlanksRecipe(exporter, MariposaBlocks.SEQUOIA_PLANKS, MariposaTags.SEQUOIA_LOGS_ITEM, 4);
        offerBarkBlockRecipe(exporter, MariposaBlocks.SEQUOIA_WOOD, MariposaBlocks.SEQUOIA_LOG);
        offerBarkBlockRecipe(exporter, MariposaBlocks.STRIPPED_SEQUOIA_WOOD, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
        offerStackedBlockRecipe(exporter, MariposaBlocks.STACKED_SEQUOIA_LOGS, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
        offerHangingSignRecipe(exporter, MariposaItems.SEQUOIA_HANGING_SIGN, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
    }

    private static void offerStackedBlockRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6)
                .pattern("###")
                .pattern("###")
                .input('#', input)
                .group("stacked")
                .criterion("has_log", conditionsFromItem(input))
                .offerTo(exporter, new Identifier(Mariposa.MOD_ID, RecipeProvider.getRecipeName(output)));
    }

    @Override
    public String getName() {
        return Mariposa.MOD_ID;
    }
}
