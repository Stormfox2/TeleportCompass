package de.stormfox2.compass.listener;

import de.stormfox2.compass.Compass;
import de.stormfox2.compass.items.Item;
import de.stormfox2.compass.items.ItemManager;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class JoinListener implements Listener {
    Item compass;

    public JoinListener(){
        compass = ItemManager.getInstance().getCompass();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Compass m = Compass.getInstance();
        Player p = e.getPlayer();

        p.getInventory().setItem(compass.getSlot() , compass);
    }

}
