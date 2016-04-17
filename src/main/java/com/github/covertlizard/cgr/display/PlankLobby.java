package com.github.covertlizard.cgr.display;

import com.github.covertlizard.cgr.lib.Color;
import com.github.covertlizard.cgr.reference.Reference;

/****************************************************
 * Created: 4/16/2016 at 6:11 PM by CovertLizard
 * FQN: com.github.covertlizard.cgr.display.PlankLobby
 * Info: This class contains scoreboard values for the
 *       lobby
 ****************************************************/
@SuppressWarnings("all")
public class PlankLobby extends Plank
{
    public PlankLobby()
    {
        super.objective.setDisplayName(Color.WHITE + "CG: " + Color.RED.toBold() + "REBOOM");
        super.space(9);
        super.insert(8, Color.BLUE.toBold() + "Time:");
        super.insert(7, "1:00");
        super.space(6);
        super.insert(5, Color.GREEN.toBold() + "Players:");
        super.insert(4, "0 / " + Reference.PLAYERS_MAX);
    }
}