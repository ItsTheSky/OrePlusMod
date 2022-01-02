package info.itsthesky.opm.core;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.ctype.ContentList;
import mindustry.graphics.g3d.SunMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.Planet;

public class Planets implements ContentList {

    public static Planet

            ibos

    ;

    @Override
    public void load() {
        ibos = new Planet("ibos", mindustry.content.Planets.sun, 3, 1) {{
            bloom = true;
            generator = new SerpuloPlanetGenerator();
            accessible = false;
            meshLoader = () -> new SunMesh(
                    this, 6,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("387DFF"),
                    Color.valueOf("385FFF"),
                    Color.valueOf("4C4CFF"),
                    Color.valueOf("4C4CFF"),
                    Color.valueOf("8572FF"),
                    Color.valueOf("A98EF2")
            );
            hasAtmosphere = true;
            atmosphereColor = Color.valueOf("443460FF");
            atmosphereRadIn = 0.019f;
            atmosphereRadOut = 0.29f;
            alwaysUnlocked = true;
            orbitRadius = 42.3f;
            startSector = 36;
        }};
    }
}
