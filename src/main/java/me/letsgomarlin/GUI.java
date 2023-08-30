package me.letsgomarlin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GUI implements Listener {
;
    private final Inventory inv;

    public GUI() {
        inv = Bukkit.createInventory(null, 9, "Example");
        initializeItems();
    }

    private void initializeItems() {
        inv.addItem(createGuiItem(Material.DIAMOND_HOE, "Example hoe"));
    }
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("Test");
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }

    public void OpenInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }
    @EventHandler
    public void onInventoryClock(final InventoryClickEvent e) {
        if(!e.getInventory().equals(inv)) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();
        final Player p = (Player) e.getWhoClicked();
        p.sendMessage("You clicked at slot " + e.getRawSlot());

        }

        public void onInventoryClick(final InventoryDragEvent e) {
        if(e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }

}
