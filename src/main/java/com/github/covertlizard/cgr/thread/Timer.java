package com.github.covertlizard.cgr.thread;

import org.bukkit.plugin.java.JavaPlugin;

/****************************************************
 * Created: 4/16/2016 at 4:09 PM by CovertLizard
 * FQN: com.covertlizard.cgr.thread.Timer
 * Info: Timer helper class
 ****************************************************/
@SuppressWarnings("all")
public abstract class Timer implements Runnable
{
    public static final Timer[] TIMERS = new Timer[5];
    private final JavaPlugin plugin;
    private final long delay, period;
    private int id;

    /**
     * Creates an Asyncronous timer
     * @param plugin the plugin instance
     * @param delay the delay before the timer begins
     * @param period the period (or delay) before the run function is called again
     */
    public Timer(JavaPlugin plugin, long delay, long period)
    {
        this.plugin = plugin;
        this.delay = delay;
        this.period = period;
        Timer.TIMERS[0] = new TimerLobby(plugin);
    }

    /**
     * Starts the timer Syncronously
     */
    public Timer start()
    {
        this.id = this.plugin.getServer().getScheduler().runTaskTimer(this.plugin, this, this.delay, this.period).getTaskId();
        return this;
    }

    /**
     * Starts the timer Asyncronously
     */
    public Timer startAsync()
    {
        this.id = this.plugin.getServer().getScheduler().runTaskTimerAsynchronously(this.plugin, this, this.delay, this.period).getTaskId();
        return this;
    }

    /**
     * Stops the timer
     */
    public Timer stop()
    {
        this.plugin.getServer().getScheduler().cancelTask(this.id);
        return this;
    }
}