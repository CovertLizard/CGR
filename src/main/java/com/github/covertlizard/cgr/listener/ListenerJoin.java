package com.github.covertlizard.cgr.listener;

import com.github.covertlizard.cgr.display.Plank;
import com.github.covertlizard.cgr.game.State;
import com.github.covertlizard.cgr.lib.Bucket;
import com.github.covertlizard.cgr.reference.Item;
import com.github.covertlizard.cgr.reference.Reference;
import com.github.covertlizard.cgr.thread.Timer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

/****************************************************
 * Created: 4/16/2016 at 4:44 PM by CovertLizard
 * FQN: com.covertlizard.cgr.listener.ListenerJoin
 * Info: This class listens for players joining and
 *       leaving the server
 ****************************************************/
@SuppressWarnings("all")
public class ListenerJoin extends Listener
{
    @EventHandler
    private void onPlayerJoinEvent(PlayerJoinEvent event)
    {
        Bucket.setCount(Bucket.getCount() + 1);
        if(State.is(State.LOBBY))
        {
            Item.stacks.forEach(stack -> event.getPlayer().getInventory().addItem(stack));
            // scoreboard
            Plank.PLANKS[0].display(event.getPlayer());
            Plank.PLANKS[0].insert(4, Bucket.getCount() + " / " + Reference.PLAYERS_MAX);
            if(Bucket.getCount() >= Reference.PLAYERS_MIN) Timer.TIMERS[0].start(); // start the lobby timer if the amount of players needed is met
        }
    }

    @EventHandler
    private void onPlayerQuitEvent(PlayerQuitEvent event)
    {
        Bucket.setCount(Bucket.getCount() - 1);
        if(State.is(State.LOBBY))
        {
            Plank.PLANKS[0].insert(4, Bucket.getCount() + " / " + Reference.PLAYERS_MAX);
            if(Bucket.getCount() >= Reference.PLAYERS_MIN) Timer.TIMERS[0].stop(); // stop the timer if there is not enough players to begin the game
        }
    }
}