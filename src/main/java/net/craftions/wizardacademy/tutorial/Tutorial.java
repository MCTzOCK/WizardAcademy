package net.craftions.wizardacademy.tutorial;

import net.craftions.wizardacademy.WizardAcademy;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Tutorial {

    public static void TutorialText(Player p){

        p.sendMessage("§7§l Hallo " + p.getName() + ".");
        p.sendMessage("Hallo! Hier neben dir...");
        p.sendMessage("Ich bin übrigens Otto");

        Bukkit.getScheduler().scheduleSyncDelayedTask(WizardAcademy.plugin, new Runnable() {
            @Override
            public void run() {

                p.sendMessage("§7§l Ich habe gehört, dass du neu auf der WizardAcademy bist.");
                p.sendMessage("§7§l Was hältst du von einer Rundtour am Anfang.");


                TextComponent jaGerne = new TextComponent("§a Ja, gerne");
                ClickEvent clickEventJa = new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/rundtour ja");
                jaGerne.setClickEvent(clickEventJa);
                p.spigot().sendMessage(jaGerne);

                TextComponent neinDanke = new TextComponent("§c Nein, Danke");
                ClickEvent clickEventNein = new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/rundtour nein");
                neinDanke.setClickEvent(clickEventNein);
                p.spigot().sendMessage(neinDanke);

            }
        },2 * 20);
    }
}
