package com.github.covertlizard.cgr.game;

/****************************************************
 * Created: 4/16/2016 at 4:12 PM by CovertLizard
 * FQN: com.covertlizard.cgr.game.State
 * Info: State utility class
 ****************************************************/
@SuppressWarnings("all")
public enum State
{
    LOBBY, PREGAME, GAME, POSTGAME, END;
    public static State current = State.LOBBY;

    public static boolean is(State state)
    {
        return State.current == state;
    }

    /**
     * Makes the selected state the current state
     */
    public void current()
    {
        State.current = this;
    }
}