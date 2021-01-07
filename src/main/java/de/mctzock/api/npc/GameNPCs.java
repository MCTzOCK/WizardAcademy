package de.mctzock.api.npc;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class GameNPCs {

    public static void generateTestNPC(Player p){
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Lost");
        npc.spawn(p.getLocation());
    }
}
