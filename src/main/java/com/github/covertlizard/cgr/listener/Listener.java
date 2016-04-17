package com.github.covertlizard.cgr.listener;

import org.bukkit.plugin.java.JavaPlugin;

/****************************************************
 * Created: 4/16/2016 at 4:40 PM by CovertLizard
 * FQN: com.covertlizard.cgr.listener.Listener
 * Info: This class is used for Listener extension and
 *       registration
 ****************************************************/
@SuppressWarnings("all")
public class Listener implements org.bukkit.event.Listener
{
    protected JavaPlugin plugin;

    public void setPlugin(JavaPlugin plugin)
    {
        this.plugin = plugin;
    }

    /**
     * Registers the listener to the plugin
     * @param plugin the plugin instance
     * @param listener the listener instance
     */
    public static void register(JavaPlugin plugin, Listener listener)
    {
        listener.setPlugin(plugin);
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}