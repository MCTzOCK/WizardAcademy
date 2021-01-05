package net.craftions.wizardacademy;

import org.bukkit.plugin.java.JavaPlugin;

public final class WizardAcademy extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Welcome to WizardAcademy v" + this.getDescription().getVersion() + " by " + this.getDescription().getAuthors());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
