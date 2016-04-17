package com.github.covertlizard.cgr;

import com.github.covertlizard.cgr.listener.*;
import com.github.covertlizard.cgr.thread.*;
import org.bukkit.plugin.java.JavaPlugin;

/****************************************************
 * Created: 4/16/2016 at 2:45 PM by CovertLizard
 * FQN: com.covertlizard.cgr.Core
 * Info: Core class for the CGR plugin
 ****************************************************/
@SuppressWarnings("all")
public class Core extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        Timer.TIMERS[0] = new TimerLobby(this);
        Timer.TIMERS[1] = new TimerWarm(this);
        Listener.register(this, new ListenerJoin());
        Listener.register(this, new ListenerGame());
        Listener.register(this, new ListenerMove());
    }
}