package net.craftions.wizardacademy.commands;

import net.craftions.wizardacademy.utils.Locations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRundtour implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;
        if (args.length == 1) {
            if (args[0].equals("ja")){

                player.teleport(Locations.tutorial_start);

            }else if (args[0].equals("nein")){
                sender.sendMessage("Ok. Ein Tipp noch:");
                sender.sendMessage("Wenn du gleich das Schiff verlässt, ");



            }
        }

        return true;
    }
}
