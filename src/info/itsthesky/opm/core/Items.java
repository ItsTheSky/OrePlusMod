package info.itsthesky.opm.core;

import arc.Core;
import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class Items implements ContentList {

    public static Item

    iron, ion, arcane, compressedArcane

    ;

    @Override
    public void load() {
        iron = new Item("iron"){{
            description = "Base material used for OPM engine.";
            alwaysUnlocked = true;
            color = Color.gray;
        }};

        ion = new Item("ion"){{
            description = "Raw magical item, can be converted into arcane.";
            explosiveness = 0.2f;
            radioactivity = 1f;
            alwaysUnlocked = true;
            color = Color.cyan;
        }};

        arcane = new Item("arcane") {{
            description = "The base magical item for a lot of OPM buildings and creation.";
            alwaysUnlocked = true;
            color = Color.rgb(20, 148, 255);
        }};
    }
}
