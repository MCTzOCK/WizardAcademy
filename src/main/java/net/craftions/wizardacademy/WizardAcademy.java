package net.craftions.wizardacademy;

import de.mctzock.api.mysql.MySQL;
import net.craftions.wizardacademy.events.EventPlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class WizardAcademy extends JavaPlugin {

    public static WizardAcademy plugin;

    @Override
    public void onEnable() {
        plugin = this;
        File conf = new File("conf");
        if(!conf.isDirectory()){
            conf.mkdir();
        }
        File mysql_config = new File("conf/mysql.yml");
        if(!mysql_config.isFile()){
            try {
                mysql_config.createNewFile();
                FileWriter w = new FileWriter(mysql_config);
                w.write("host: enter_here\ndatabase: enter_here\nuser: enter_here\npassword: enter_here");
                w.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MySQL.connect();
        Bukkit.getPluginManager().registerEvents(new EventPlayerJoin(), this);
        System.out.println("Welcome to WizardAcademy v" + this.getDescription().getVersion() + " by " + this.getDescription().getAuthors());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MySQL.disconnect();
    }
}