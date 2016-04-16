package com.covertlizard.cgr.schedule.timers;

import com.covertlizard.cgr.game.State;
import com.covertlizard.cgr.schedule.Timer;
import org.bukkit.plugin.java.JavaPlugin;

/****************************************************
 * Created: 4/16/2016 at 4:20 PM by CovertLizard
 * FQN: com.covertlizard.cgr.schedule.timers.LobbyTimer
 * Info: Runs during the Lobby state
 ****************************************************/
@SuppressWarnings("all")
public class LobbyTimer extends Timer
{
    public LobbyTimer(JavaPlugin plugin)
    {
        super(plugin, 0, 20);
    }

    @Override
    public void run()
    {
        if(State.current != State.LOBBY) //stop timer if not in lobby state
        {
            super.stop();
            return;
        }
    }
}