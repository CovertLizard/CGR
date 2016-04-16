package com.covertlizard.cgr.schedule;

import org.bukkit.plugin.java.JavaPlugin;

/****************************************************
 * Created: 4/16/2016 at 4:09 PM by CovertLizard
 * FQN: com.covertlizard.cgr.schedule.Timer
 * Info: Timer helper class
 ****************************************************/
@SuppressWarnings("all")
public abstract class Timer implements Runnable
{
    /**
     * Creates an Asyncronous timer
     * @param plugin the plugin instance
     * @param delay the delay before the timer begins
     * @param period the period (or delay) before the run function is called again
     */
    public Timer(JavaPlugin plugin, long delay, long period)
    {
        plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, this, delay, period);
    }
}