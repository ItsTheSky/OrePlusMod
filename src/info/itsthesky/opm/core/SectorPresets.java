package info.itsthesky.opm.core;

import arc.struct.Seq;
import mindustry.ctype.ContentList;
import mindustry.type.SectorPreset;

import static mindustry.content.Planets.serpulo;

public class SectorPresets implements ContentList {

    public static SectorPreset

            opmSector

    ;

    @Override
    public void load() {
        opmSector = new SectorPreset("opmSector", serpulo, 36){{
            alwaysUnlocked = true;
            planet = Planets.ibos;
            captureWave = 5;
            difficulty = 4;
        }};
        Planets.ibos.sectors = Seq.with(opmSector.sector);
    }
}
