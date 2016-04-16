package com.covertlizard.cgr.schedule;

import com.covertlizard.cgr.schedule.timers.LobbyTimer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;

/****************************************************
 * Created: 4/16/2016 at 4:18 PM by CovertLizard
 * FQN: com.covertlizard.cgr.schedule.ScheduleControl
 * Info: Manages the starting and stopping of timers
 ****************************************************/
@SuppressWarnings("all")
public class ScheduleControl
{
    private final HashSet<Timer> timers = new HashSet<>();
    private final JavaPlugin plugin;

    public ScheduleControl(JavaPlugin plugin)
    {
        this.plugin = plugin;
        this.timers.add(new LobbyTimer(plugin));
    }
}