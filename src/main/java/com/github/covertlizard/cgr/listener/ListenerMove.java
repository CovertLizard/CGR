package com.github.covertlizard.cgr.listener;

import com.github.covertlizard.cgr.game.State;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

/****************************************************
 * Created: 4/16/2016 at 9:34 PM by CovertLizard
 * FQN: com.github.covertlizard.cgr.listener.ListenerMove
 * Info:
 ****************************************************/
@SuppressWarnings("all")
public class ListenerMove extends Listener
{
    @EventHandler
    private void onPlayerMoveEvent(PlayerMoveEvent event)
    {
        if(!State.is(State.PREGAME)) return;
        event.setCancelled(true);
    }
}