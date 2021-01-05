package net.craftions.wizardacademy.events;

import de.mctzock.api.mysql.MySQL;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

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
            }else {
                e.getPlayer().sendMessage("Willkommen zurück!");
                e.getPlayer().sendTitle("Hallo!","Tschüs!!!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
