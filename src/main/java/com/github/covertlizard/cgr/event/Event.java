package com.github.covertlizard.cgr.event;

/****************************************************
 * Created: 1/13/2016 at 5:29 PM by CovertLizard
 * FQN: com.github.covertlizard.cgr.event
 * Info: Allows for custom event implementations and calls
 ****************************************************/
@SuppressWarnings("all")
public class Event extends org.bukkit.event.Event implements org.bukkit.event.Cancellable
{
    public static final org.bukkit.event.HandlerList HANDLER_LIST = new org.bukkit.event.HandlerList();
    private boolean cancelled = false;

    @Override
    public boolean isCancelled()
    {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel)
    {
        this.cancelled = cancel;
    }

    @Override
    public org.bukkit.event.HandlerList getHandlers()
    {
        return Event.HANDLER_LIST;
    }

    public static org.bukkit.event.HandlerList getHandlerList()
    {
        return Event.HANDLER_LIST;
    }

    /**
     * Calls the event
     * @return the event instance
     */
    public static Event call(Event event)
    {
        org.bukkit.Bukkit.getServer().getPluginManager().callEvent(event);
        return event;
    }
}