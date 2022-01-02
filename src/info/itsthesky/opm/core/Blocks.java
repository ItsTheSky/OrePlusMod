package info.itsthesky.opm.core;

import mindustry.content.Liquids;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawLiquid;

import static mindustry.type.ItemStack.with;

public class Blocks implements ContentList {

    public static Block

    ironOre, ionOre, arcaneConveyor,

    arcaneCreator, arcaneCompressor

    ;

    @Override
    public void load() {
        ironOre = new OreBlock("iron-ore"){{
            variants = 3;
            oreDefault = true;
            oreScale = 25.4209f;
            oreThreshold = 0.884f;
            itemDrop = Items.iron;
        }};

        ionOre = new OreBlock("ion-ore"){{
            variants = 2;
            oreDefault = true;
            oreScale = 3.4209f;
            oreThreshold = 0.884f;
            itemDrop = Items.ion;
        }};

        arcaneConveyor = new Conveyor("arcane-conveyor"){{
            requirements(Category.distribution, with(
                            Items.iron, 2, Items.arcane, 1), true);
            health = 250;
            speed = 0.11f;
            displayedSpeed = 10f;
            buildCostMultiplier = 2f;
        }};

        arcaneCompressor = new GenericCrafter("arcane-compressor"){{
            requirements(Category.crafting, with(Items.arcane, 180, mindustry.content.Items.thorium, 10, Items.iron, 150));
            health = 600;
            craftTime = 45;
            hasPower = true;
            size = 3;
            outputItem = new ItemStack(Items.compressedArcane, 1);

            description = "Compress magical arcane into plate, to use in deeper and more advanced engines.";

            consumes.power(2.5f);
            consumes.items(new ItemStack(Items.iron, 1), new ItemStack(Items.arcane, 2));
        }};

        arcaneCreator = new GenericCrafter("arcane-creator"){{
            requirements(Category.crafting, with(Items.iron, 120, mindustry.content.Items.titanium, 80, mindustry.content.Items.graphite, 120));
            health = 300;
            craftTime = 30;
            hasPower = true;
            size = 2;
            outputItem = new ItemStack(Items.arcane, 1);

            description = "The main engine to create arcane from iron and ions. It require a lot of energy, but produce arcane faster.";

            consumes.power(4f);
            consumes.items(new ItemStack(Items.ion, 2), new ItemStack(Items.iron, 1));
        }};
    }
}
