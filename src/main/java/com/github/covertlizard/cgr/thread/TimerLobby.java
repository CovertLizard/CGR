package com.github.covertlizard.cgr.thread;

import com.github.covertlizard.cgr.display.Plank;
import com.github.covertlizard.cgr.display.PlankLobby;
import com.github.covertlizard.cgr.event.Event;
import com.github.covertlizard.cgr.event.EventGameStart;
import com.github.covertlizard.cgr.game.State;
import com.github.covertlizard.cgr.lib.Color;
import org.bukkit.plugin.java.JavaPlugin;

/****************************************************
 * Created: 4/16/2016 at 4:30 PM by CovertLizard
 * FQN: com.covertlizard.cgr.thread.TimerLobby
 * Info: This timer runs after certain conditions
 *       have been met in the lobby
 ****************************************************/
@SuppressWarnings("all")
public class TimerLobby extends Timer
{
    private int time = 20;

    public TimerLobby(JavaPlugin plugin)
    {
        super(plugin, 0, 20);
        Plank.PLANKS[0] = new PlankLobby();
    }

    @Override
    public Timer stop()
    {
        this.time = 20; // reset time
        return this;
    }

    @Override
    public void run()
    {
        Plank.PLANKS[0].insert(7, Color.YELLOW + "" + this.time + " seconds"); // update time
        if(!State.is(State.LOBBY) || this.time <= 0)
        {
            Event.call(new EventGameStart()); // call game start event
            super.stop();
            return;
        }
        this.time--;
    }
}