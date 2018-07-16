package de.stormfox2.compass.inventory;

import de.stormfox2.compass.Compass;
import de.stormfox2.compass.items.Item;
import de.stormfox2.compass.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class InventoryManager {
    private static InventoryManager instance;
    FileConfiguration conf = Compass.getInstance().getConfig();
    List<Item> items;
    Inventory inv;

    public InventoryManager() {
        instance = this;
        inv = Bukkit.createInventory(null, conf.getInt("config.size"), "Compass");
    }

    public void openInv(Player p) {
        p.openInventory(inv);
    }

    public void getInv() {
        items = ItemManager.getInstance().getItems();

        for (int i = 0; i <= 27; i++) {
            for (Item item : items) {
                if (item.getSlot() == i) {
                    inv.setItem(item.getSlot(), item);
                }
            }
        }

    }

    public static InventoryManager getInstance() {
        return instance;
    }

}
