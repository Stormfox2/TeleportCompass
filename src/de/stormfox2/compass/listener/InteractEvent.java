package de.stormfox2.compass.listener;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.stormfox2.compass.Compass;
import de.stormfox2.compass.inventory.InventoryManager;
import de.stormfox2.compass.items.Item;
import de.stormfox2.compass.items.ItemManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {
    Item compass;

    public InteractEvent(){
        compass = ItemManager.getInstance().getCompass();
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if(e.getItem().getItemMeta().getDisplayName().equals(compass.getDisplay()) && e.getItem().getType() == compass.getType()){
            InventoryManager.getInstance().openInv(e.getPlayer());
        }

        for(Item item : ItemManager.getInstance().getItems()){
            if(item.getType() == e.getItem().getType() && e.getItem().getItemMeta().getDisplayName().equals(item.getDisplay())){
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("Connect");
                out.writeUTF(item.getServer());

                e.getPlayer().sendPluginMessage(Compass.getInstance(), "BungeeCord", out.toByteArray());
            }
        }

    }

}
