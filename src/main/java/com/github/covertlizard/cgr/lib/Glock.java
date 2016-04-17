package com.github.covertlizard.cgr.lib;

/****************************************************
 * Created: 2/3/2016 at 4:13 PM by CovertLizard
 * FQN: com.covertlizard.test.Glock
 * Info: Digital Timer Helper class
 ****************************************************/
@SuppressWarnings("all")
public class Glock
{
    private final int seconds;
    private final int minutes;
    private final int hours;
    private long millis;

    /**
     * Creates a new Glock instance
     * @param seconds the amount of seconds to begin with
     * @param minutes the amount of minutes to begin with
     * @param hours the amount of hours to begin with
     */
    public Glock(int seconds, int minutes, int hours)
    {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.millis = (this.seconds + (this.minutes * 60) + (this.hours * 60 * 60)) * 1000L;
    }

    /**
     * Decrements the timer by the amount of seconds specified
     * @param seconds the seconds to decrement by
     * @return the Glock instance
     */
    public Glock decrement(int seconds)
    {
        this.millis -= seconds * 1000;
        return this;
    }

    public Glock decrement()
    {
        return this.decrement(1);
    }

    /**
     * Increments the timer by the amount of seconds specified
     * @param seconds the seconds to increment by
     * @return the Glock instance
     */
    public Glock increment(int seconds)
    {
        this.millis += seconds * 1000;
        return this;
    }

    public Glock increment()
    {
        return this.increment(1);
    }

    public long getSeconds()
    {
        return this.millis / 1000;
    }

    public long getMillis()
    {
        return this.millis;
    }

    public long getMinutes()
    {
        return this.millis / 1000 / 60;
    }

    public long getHours()
    {
        return this.millis / 1000 / 3600;
    }

    public String format()
    {
        return (this.minutes < 10 ? "0" + this.minutes : this.minutes) + " : " + (this.seconds < 10 ? "0" + this.seconds : this.seconds);
    }
}