package com.github.covertlizard.cgr.thread;

import org.bukkit.plugin.java.JavaPlugin;

/****************************************************
 * Created: 4/16/2016 at 9:36 PM by CovertLizard
 * FQN: com.github.covertlizard.cgr.thread.TimerWarm
 * Info: This class is used for the timer before the
 *       game officially starts
 ****************************************************/
@SuppressWarnings("all")
public class TimerWarm extends Timer
{
    private final int time = 10;

    public TimerWarm(JavaPlugin plugin)
    {
        super(plugin, 0, 20);
    }

    @Override
    public void run()
    {

    }
}