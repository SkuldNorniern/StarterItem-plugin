package me.skuldnorniern.starteritem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.List;

public class listener implements Listener {
    private final StarterItem plugin;

    public listener(StarterItem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (plugin.getConfig().getBoolean("only_rev_members")) {
            List<String> reslist = plugin.getConfig().getStringList("advance_reservation");
            String name = p.getDisplayName();
            boolean bol = reslist.contains(name);
            System.out.println(reslist);
            if(!bol) {
                if (!(p.hasPlayedBefore())) {
                    ItemStack stack = new ItemStack(Material.STONE_AXE,1);
                    ItemMeta meta = stack.getItemMeta();
                    meta.addEnchant(Enchantment.DURABILITY, 255, true);
                    stack.setItemMeta(meta);

                    Bukkit.broadcastMessage("Here is your reward! " + p.getDisplayName());
                    p.getInventory().addItem(stack);
                }
            }
            else
            {
                ItemStack stack = new ItemStack(Material.STONE_AXE,1);
                ItemMeta meta = stack.getItemMeta();
                meta.addEnchant(Enchantment.DURABILITY, 255, true);
                stack.setItemMeta(meta);

                Bukkit.broadcastMessage("Here is your reward! " + p.getDisplayName());
                p.getInventory().addItem(stack);
            }
        }
    }
}
