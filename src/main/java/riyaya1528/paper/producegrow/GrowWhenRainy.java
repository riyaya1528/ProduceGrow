package riyaya1528.paper.producegrow;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

import java.util.Collection;

public class GrowWhenRainy implements Listener {
    @EventHandler
    public void onGrow(BlockGrowEvent e) {
        if(ProduceGrow.rainGrow) {
            if(e.getBlock().getWorld().hasStorm()) {
                Location location = e.getBlock().getLocation();
                int n = 0;
                while (n <= ProduceGrow.rainGrowSpeed) {
                    sendPacketGrowBlock(location);
                    n = n + 1;
                }
            }
        }
    }
    public void sendPacketGrowBlock(Location location) {
        Collection<Player> players = location.getNearbyPlayers(48);
        for (Player player : players)
            player.playEffect(location, Effect.VILLAGER_PLANT_GROW, Integer.valueOf(0));
    }
}
