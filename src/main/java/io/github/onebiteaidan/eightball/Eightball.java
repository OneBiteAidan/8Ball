package io.github.onebiteaidan.eightball;

import org.bukkit.plugin.java.JavaPlugin;

public final class Eightball extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("8Ball Has Started");

        this.saveDefaultConfig();
        this.saveConfig();

        getCommand("8ball").setExecutor(new EightBallCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
