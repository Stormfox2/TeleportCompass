package de.stormfox2.compass.items;

import de.stormfox2.compass.Compass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemManager {
    List<Item> items;
    FileConfiguration conf = Compass.getInstance().getConfig();
    Item item;
    private static ItemManager instance;
    Item compass;

    public ItemManager() {
        instance = this;
        items = new ArrayList<Item>();

        compass = new Item(Material.getMaterial(conf.getString("config.material")), conf.getInt("config.slot") - 1);
        compass.setDisplay(conf.getString("config.name"));

        for (int i = 1; i <= 9; i++) {
            if (conf.getBoolean("item" + i + ".enabled")) {
                String name = conf.getString("item" + i + ".name");
                int slot = conf.getInt("item" + i + ".slot") - 1;
                Material material = Material.getMaterial(conf.getString("item" + i + ".material"));
                List<String> lore = conf.getStringList("item" + i + ".lore");
                String server = conf.getString("item" + i + ".server");

                item = new Item(material, slot);
                item.setLore(lore);
                item.setDisplay(name);
                item.setServer(server);
                items.add(item);
            }
        }
    }

    public Item getCompass() {
        return compass;
    }

    public List<Item> getItems() {
        return items;
    }

    public static ItemManager getInstance() {
        return instance;
    }
}
