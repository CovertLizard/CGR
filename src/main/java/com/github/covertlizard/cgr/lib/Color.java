package com.github.covertlizard.cgr.lib;

/****************************************************
 * Created: 1/24/2016 at 5:04 PM by CovertLizard
 * FQN: com.github.covertlizard.cgr.lib
 * Info: Contains message colors
 ****************************************************/
@SuppressWarnings("all")
public enum Color
{
    BLACK('0', "black"),
    DARK_BLUE('1', "dark_blue"),
    DARK_GREEN('2', "dark_green"),
    CYAN('3', "dark_aqua"),
    DARK_RED('4', "dark_red"),
    PURPLE('5', "dark_purple"),
    ORANGE('6', "orange"),
    GRAY('7', "gray"),
    DARK_GRAY('8', "dark_gray"),
    BLUE('9', "blue"),
    GREEN('a', "green"),
    AQUA('b', "aqua"),
    RED('c', "red"),
    PINK('d', "light_purple"),
    YELLOW('e', "yellow"),
    WHITE('f', "white"),
    MAGIC('k', "magic"),
    BOLD('l', "bold"),
    STRIKE('m', "strikethrough"),
    UNDER('n', "underline"),
    ITALIC('o', "italic"),
    RESET('r', "reset");

    public static final char COLOR_CHARACTER = '\u00A7';
    public final char CHARACTER;
    public final String NAME;
    public final String COMPILE;

    private Color(char character, String name)
    {
        this.CHARACTER = character;
        this.NAME = name;
        this.COMPILE = new String(new char[]{Color.COLOR_CHARACTER, character});
    }

    public String toBold()
    {
        return new String(this.COMPILE + BOLD.COMPILE);
    }

    @Override
    public String toString()
    {
        return this.COMPILE;
    }
}