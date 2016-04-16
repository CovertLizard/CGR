package com.covertlizard.cgr.thread;

import com.covertlizard.cgr.lib.Glock;
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
    private Glock glock = new Glock(60, 0 ,0);

    public TimerLobby(JavaPlugin plugin)
    {
        super(plugin, 0, 20);
    }

    @Override
    public Timer stop()
    {
        this.glock = new Glock(60, 0, 0); // reset the clock
        return this;
    }

    @Override
    public void run()
    {
        if(this.glock.getSeconds() == 0)
        {
            this.stop();
            // todo start game
            return;
        }
        this.glock.decrement();
        // todo display current time to players
    }
}