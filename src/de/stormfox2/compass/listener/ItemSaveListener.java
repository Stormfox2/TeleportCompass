package de.stormfox2.compass.listener;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.stormfox2.compass.Compass;
import de.stormfox2.compass.inventory.InventoryManager;
import de.stormfox2.compass.items.Item;
import de.stormfox2.compass.items.ItemManager;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class ItemSaveListener implements Listener {
    Item compass;

    public ItemSaveListener(){
        compass = ItemManager.getInstance().getCompass();
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        if(e.getItemDrop().getItemStack().getType() == compass.getType() && e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(compass.getDisplay()))
            e.setCancelled(true);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getCurrentItem().getType() == compass.getType() && e.getCurrentItem().getItemMeta().getDisplayName().equals(compass.getDisplay())) {
            InventoryManager.getInstance().openInv((Player)(e.getWhoClicked()));

            e.setCancelled(true);
        }

        for (Item item : ItemManager.getInstance().getItems()) {
            if (item.getType() == e.getCurrentItem().getType() && e.getCurrentItem().getItemMeta().getDisplayName().equals(item.getDisplay())) {
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("Connect");
                out.writeUTF(item.getServer());

                ((Player) e.getWhoClicked()).sendPluginMessage(Compass.getInstance(), "BungeeCord", out.toByteArray());

                e.setCancelled(true);
            }
        }
    }

}
