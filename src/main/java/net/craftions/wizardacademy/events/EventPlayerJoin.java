package net.craftions.wizardacademy.events;

import de.mctzock.api.mysql.MySQL;
import de.mctzock.api.npc.GameNPCs;
import net.craftions.wizardacademy.tutorial.Tutorial;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        // check if player has joined before
        ResultSet rs = MySQL.executeQuery("SELECT * FROM users_joined WHERE name = '" + e.getPlayer().getName() + "';");
        try {
            if(!rs.next()){
                // player has not joined before
                // start tutorial
                System.out.println("Player " + e.getPlayer().getName() + " joined the first time!");
                Tutorial.TutorialText(e.getPlayer());
                MySQL.executeUpdate("INSERT INTO users_joined (name, uuid) values ('" + e.getPlayer().getName() + "', '" + e.getPlayer().getUniqueId().toString() + "');");
            }else {
                e.getPlayer().sendTitle("§4 Willkommen zurück!","");
                GameNPCs.generateTestNPC(e.getPlayer());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
