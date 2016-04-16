package com.github.covertlizard.cgr.display;

/****************************************************
 * Created: 2/9/2016 at 5:22 PM by CovertLizard
 * FQN: com.github.covertlizard.cgr.display
 * Info: Scoreboard utility class
 ****************************************************/
@SuppressWarnings("all")
public class Plank
{
    protected final org.bukkit.scoreboard.Scoreboard scoreboard;
    protected final org.bukkit.scoreboard.Objective objective;
    protected final java.util.HashMap<Integer, Object> scores = new java.util.HashMap<>();

    /**
     * Creates a new Plank instance
     */
    public Plank()
    {
        this.scoreboard = org.bukkit.Bukkit.getScoreboardManager().getNewScoreboard();
        this.objective = this.scoreboard.registerNewObjective("a", "dummy");
        this.objective.setDisplaySlot(org.bukkit.scoreboard.DisplaySlot.SIDEBAR);
    }

    /**
     * Inserts and replaces a value in the Scoreboard
     * @param index the score
     * @param value the value
     * @return the Plank instance
     */
    protected final Plank insert(int score, Object value)
    {
        if(this.scores.containsKey(score)) this.remove(score);
        this.scores.put(score, value);
        this.objective.getScore(value.toString()).setScore(score);
        return this;
    }
    /**
     * Removes the value from the scoreboard
     * @param score the score
     * @return the Plank instance
     */
    protected final Plank remove(int score)
    {
        if(!this.scores.containsKey(score)) return this;
        this.scoreboard.resetScores(this.scores.get(score).toString());
        this.scores.remove(score);
        return this;
    }

    /**
     * Inserts a space into the Scoreboard
     * @param index the score
     * @return the Plank instance
     */
    protected final Plank space(int score)
    {
        return this.insert(score,  org.bukkit.ChatColor.BLACK);
    }

    /**
     * Displays the Plank to the specified players
     * @param players the players
     */
    public final void display(java.util.Collection<? extends org.bukkit.entity.Player> players)
    {
        for(org.bukkit.entity.Player player : players) player.setScoreboard(this.scoreboard);
    }

    /**
     * Displays the Plank to the specified players
     * @param players the players
     */
    public final void display(org.bukkit.entity.Player... players)
    {
        for(org.bukkit.entity.Player player : players) player.setScoreboard(this.scoreboard);
    }
}