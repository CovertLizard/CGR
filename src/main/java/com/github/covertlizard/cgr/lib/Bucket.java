package com.github.covertlizard.cgr.lib;

/****************************************************
 * Created: 4/16/2016 at 4:44 PM by CovertLizard
 * FQN: com.covertlizard.cgr.lib.Bucket
 * Info: This class provides a few Bukkit utilities
 ****************************************************/
@SuppressWarnings("all")
public class Bucket
{
    public static int count = 0;

    public static synchronized void setCount(int count)
    {
        Bucket.count = count;
    }

    public static synchronized int getCount()
    {
        return Bucket.count;
    }
}