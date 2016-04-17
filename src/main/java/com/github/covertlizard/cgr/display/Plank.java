package com.github.covertlizard.cgr.display;

/****************************************************
 * Created: 2/9/2016 at 5:22 PM by CovertLizard
 * FQN: com.github.covertlizard.cgr.display
 * Info: This class is used for creating and modifying
 *       scoreboards
 ****************************************************/
@SuppressWarnings("all")
public abstract class Plank
{
    public static final Plank[] PLANKS = new Plank[10];
    protected final org.bukkit.scoreboard.Scoreboard scoreboard;
    protected final org.bukkit.scoreboard.Objective objective;
    protected final java.util.HashMap<Integer, Object> scores = new java.util.HashMap<>();
    private int index = 0; // color index

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
    public final Plank insert(int score, Object value)
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
    public final Plank remove(int score)
    {
        this.scoreboard.resetScores(this.scores.get(score).toString());
        this.scores.remove(score);
        return this;
    }

    /**
     * Inserts a space into the Scoreboard
     * @param index the score
     * @return the Plank instance
     */
    public final Plank space(int score)
    {
        this.insert(score, com.github.covertlizard.cgr.lib.Color.values()[this.index]);
        this.index += this.index == com.github.covertlizard.cgr.lib.Color.values().length ? 0 : 1;
        return this;
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