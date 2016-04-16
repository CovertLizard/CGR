package com.github.covertlizard.cgr;

import com.github.covertlizard.cgr.listener.Listener;
import com.github.covertlizard.cgr.listener.ListenerJoin;
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
        Listener.register(this, new ListenerJoin());
    }
}