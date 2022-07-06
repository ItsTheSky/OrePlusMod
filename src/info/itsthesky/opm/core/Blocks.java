package info.itsthesky.opm.core;

import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.GenericCrafter;

import static mindustry.type.ItemStack.with;

public class Blocks implements ContentList {

    public static Block

            ironOre, ionOre, arcaneConveyor,
            waterGenerator, sandGenerator,
            ironCondenser, arcaneCreator, arcaneCompressor,
            arcaneWall, arcaneWallLarge, arcaneWallHuge, arcaneWallGigantic

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
            speed = 0.4f;
            displayedSpeed = 10f;
            buildCostMultiplier = 2f;
        }};

        ironCondenser = new GenericCrafter("iron-condenser") {{
            requirements(Category.crafting, with(mindustry.content.Items.copper, 80, mindustry.content.Items.silicon, 60, mindustry.content.Items.lead, 150));
            health = 600;
            craftTime = 30;
            hasPower = false;
            size = 2;
            alwaysUnlocked = true;
            outputItem = new ItemStack(Items.iron, 2);

            description = "Convert copper, lead and coal into OPM iron to use with magical items.";

            consumes.items(new ItemStack(mindustry.content.Items.copper, 1),
                    new ItemStack(mindustry.content.Items.lead, 1),
                    new ItemStack(mindustry.content.Items.coal, 3));
        }};
        
        waterGenerator = new GenericCrafter("water-generator") {{
            requirements(Category.crafting, with(mindustry.content.Items.copper, 80, mindustry.content.Items.silicon, 60, mindustry.content.Items.lead, 150));
            health = 600;
            craftTime = 30;
            hasPower = false;
            size = 2;
            hasLiquids = true;
            alwaysUnlocked = true;
            outputLiquid = new LiquidStack(mindustry.content.Liquids.water, 40);
            consumes.items(new ItemStack(mindustry.content.Items.copper, 1));
        }};





        arcaneCompressor = new GenericCrafter("arcane-compressor"){{
            requirements(Category.crafting, with(Items.arcane, 180, mindustry.content.Items.thorium, 10, Items.iron, 150));
            health = 600;
            craftTime = 45;
            hasPower = true;
            size = 3;
            alwaysUnlocked = true;
            outputItem = new ItemStack(Items.compressedArcane, 1);

            description = "Compress magical arcane into plate, to use in deeper and more advanced engines.";

            consumes.power(0.4f);
            consumes.items(new ItemStack(Items.iron, 1), new ItemStack(Items.arcane, 2));
        }};

        sandGenerator = new GenericCrafter("sand-generator") {{
            requirements(Category.crafting, with(mindustry.content.Items.copper, 80, mindustry.content.Items.lead, 150));
            health = 600;
            craftTime = 20;
            hasPower = false;
            size = 2;
            alwaysUnlocked = true;
            outputItem = new ItemStack(mindustry.content.Items.sand, 2);
            consumes.items(new ItemStack(mindustry.content.Items.copper, 3));
        }};

        arcaneCreator = new GenericCrafter("arcane-creator"){{
            requirements(Category.crafting, with(Items.iron, 120, mindustry.content.Items.titanium, 80, mindustry.content.Items.graphite, 120));
            health = 300;
            craftTime = 30;
            hasPower = true;
            size = 2;
            outputItem = new ItemStack(Items.arcane, 1);
            alwaysUnlocked = true;
            description = "The main engine to create arcane from iron and ions. It require a lot of energy, but produce arcane faster.";

            consumes.power(0.4f);
            consumes.items(new ItemStack(Items.ion, 2), new ItemStack(Items.iron, 1));
        }};

        arcaneWall = new Wall("arcane-wall"){{
            requirements(Category.defense, with(Items.arcane, 6));
            health = 60 * 6;
            alwaysUnlocked = true;
        }};

        arcaneWallLarge = new Wall("arcane-wall-large"){{
            requirements(Category.defense, with(Items.arcane, 24));
            health = 60 * 4 * 6;
            size = 2;
            alwaysUnlocked = true;
        }};

        arcaneWallHuge = new Wall("arcane-wall-huge"){{
            requirements(Category.defense, with(Items.arcane, 300));
            health = 60 * 9 * 6;
            size = 3;
            alwaysUnlocked = true;
        }};

        arcaneWallGigantic = new Wall("arcane-wall-gigantic"){{
            requirements(Category.defense, with(Items.arcane, 500));
            health = 60 * 16 * 6;
            size = 4;
            alwaysUnlocked = true;
        }};
    }
}
