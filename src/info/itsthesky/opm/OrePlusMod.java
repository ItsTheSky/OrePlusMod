package info.itsthesky.opm;

import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import info.itsthesky.opm.core.Blocks;
import info.itsthesky.opm.core.Items;
import info.itsthesky.opm.core.Planets;
import info.itsthesky.opm.core.SectorPresets;
import mindustry.ctype.ContentList;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

@SuppressWarnings("unused")
public class OrePlusMod extends Mod{

    private final ContentList[] resources = {
            new Items(),
            new Blocks(),
            new Planets(),
            new SectorPresets(),
    };

    public OrePlusMod() {
        Log.info("Loading OPM ...");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(5f, () -> {
                BaseDialog dialog = new BaseDialog("OPM Loaded!");
                dialog.cont.add("OrePlusMod seems to be loaded successfully, thanks for downloading!").row();
                dialog.cont.button("Got it!", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        for (ContentList list : resources)
            list.load();
    }

}
