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
    }






    /**
     * Starts the timer Syncronously
     */
    public void start()
    {
        this.id = this.plugin.getServer().getScheduler().runTaskTimer(this.plugin, this, this.delay, this.period).getTaskId();
    }






    /**
     * Starts the timer Asyncronously
     */
    public void startAsync()
    {
        this.id = this.plugin.getServer().getScheduler().runTaskTimerAsynchronously(this.plugin, this, this.delay, this.period).getTaskId();
    }






    /**
     * Stops the timer
     */
    public void stop()
    {
        this.plugin.getServer().getScheduler().cancelTask(this.id);
    }
}