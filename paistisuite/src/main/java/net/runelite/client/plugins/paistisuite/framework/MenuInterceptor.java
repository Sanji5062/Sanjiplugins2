package net.runelite.client.plugins.paistisuite.framework;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.plugins.paistisuite.api.PWalking;

@Slf4j
public class MenuInterceptor {
    private static MenuEntry nextEntry = null;

    public static void setNextEntry(MenuEntry entry){
        nextEntry = entry;
    }

    public static void onMenuOptionClicked(MenuOptionClicked event) {
        if (nextEntry != null) {
            event.setMenuEntry(nextEntry);
            nextEntry = null;
        } else if (nextEntry.getOption().equals("Walk here") && PWalking.walkAction)
        {
            log.info("Walk action: {} {}", PWalking.coordX, PWalking.coordY);
            PWalking.setSelectedSceneTile(PWalking.coordX, PWalking.coordY);
            PWalking.walkAction = false;
            nextEntry = null;
        }
    }
}
