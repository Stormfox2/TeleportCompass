package de.stormfox2.compass.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Item extends ItemStack {

    private int slot;
    private String server;

    public Item(Material material, int s){
        super(material);
        this.slot = s;
    }

    public void setLore(List<String> lore){
        ItemMeta m = getItemMeta();
        m.setLore(lore);
        setItemMeta(m);
    }

    public void setDisplay(String display){
        ItemMeta m = getItemMeta();
        m.setDisplayName(display);
        setItemMeta(m);
    }

    public String  getDisplay(){
        ItemMeta m = getItemMeta();
        return m.getDisplayName();
    }

    public int getSlot(){
        return slot;
    }

    public String getServer(){
        return server;
    }

    public void setServer(String s){
        server = s;
    }
}
