package de.stormfox2.compass;

import de.stormfox2.compass.inventory.InventoryManager;
import de.stormfox2.compass.items.ItemManager;
import de.stormfox2.compass.listener.InteractEvent;
import de.stormfox2.compass.listener.ItemSaveListener;
import de.stormfox2.compass.listener.JoinListener;
import de.stormfox2.compass.listener.PluginMessaging;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Compass extends JavaPlugin {
    private static Compass instance;
    private List<String> defaultLore;

    @Override
    public void onEnable() {
        instance = this;

        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new PluginMessaging());
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        loadConfig();

        InventoryManager inventoryManager = new InventoryManager();
        ItemManager itemManager = new ItemManager();
        inventoryManager.getInv();

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new ItemSaveListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);

    }

    @Override
    public void onDisable() {

    }

    public static Compass getInstance() {
        return instance;
    }

    public void loadConfig(){
        getConfig().options().copyDefaults(true);

        saveConfig();
    }
}

