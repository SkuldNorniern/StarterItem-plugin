package me.skuldnorniern.starteritem;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Vector;

public class StarterItem extends JavaPlugin {

    Vector<String> revlist = new Vector<>();


    @Override
    public void onEnable() {
        // Plugin startup logic
        final FileConfiguration config = this.getConfig();

        revlist.add("notch");
        revlist.add("SkuldNorniern");
        config.addDefault("advance_reservation", revlist);
        config.addDefault("only_rev_members", true);
        config.options().copyDefaults(true);
        saveConfig();


        System.out.println("Starter Item Plugin Started");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new listener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Starter Item Plugin Stopped");
    }


}
