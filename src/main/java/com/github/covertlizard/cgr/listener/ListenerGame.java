package com.github.covertlizard.cgr.listener;

import com.github.covertlizard.cgr.event.EventGameStart;
import com.github.covertlizard.cgr.game.State;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

/****************************************************
 * Created: 4/16/2016 at 7:27 PM by CovertLizard
 * FQN: com.github.covertlizard.cgr.listener.ListenerGame
 * Info: This class listens for any events related to
 *       the game
 ****************************************************/
@SuppressWarnings("all")
public class ListenerGame extends Listener
{
    private final double[][] SPAWNS = {{0, -19}, {4, -18}, {8, -16}, {12, -13}, {15, -9}, {17, -5}, {18, 0}, {17, 5}, {15, 9}, {12, 13}, {8, 16}, {4, 18}, {0, 19}, {-4, 18}, {-8, 16}, {-12, 13}, {-15, 9}, {-17, 5}, {-18, 0}, {-17, -5}, {-15, -9}, {-12, -13}, {-8, -16}, {-4, -18}};

    @EventHandler
    private void onGameStartEvent(EventGameStart event)
    {
        State.current = State.PREGAME;
        int index = 0;
        for(Player player : super.plugin.getServer().getOnlinePlayers())
        {
            player.teleport(new Location(super.plugin.getServer().getWorld("world"), SPAWNS[index][0] + 0.5, 4.5, SPAWNS[index][1] + 0.5));
            player.getInventory().clear();
            player.setGameMode(GameMode.ADVENTURE);
            index++;
        }
    }
}