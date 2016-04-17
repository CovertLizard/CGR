package com.github.covertlizard.cgr.reference;

import com.github.covertlizard.cgr.lib.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashSet;

/****************************************************
 * Created: 4/16/2016 at 9:20 PM by CovertLizard
 * FQN: com.github.covertlizard.cgr.reference.Item
 * Info: This class manages all *special* items that
 *       are contained within the game
 ****************************************************/
@SuppressWarnings("all")
public class Item
{
    public static final HashSet<ItemStack> stacks = new HashSet<>();

    public static void initialize()
    {
        Item.stacks.add(Item.create(Material.WOOL, 1, 0, Color.RED + "Choose your district", "Click to select a district."));
        Item.stacks.add(Item.create(Material.BOW, 1, 0, Color.BLUE + "Choose your kit", "Click to select a kit."));
        Item.stacks.add(Item.create(Material.EMPTY_MAP, 1, 0, Color.GREEN + "Vote for a map", "Click to vote for a map."));
    }

    public static ItemStack create(Material material, int count, int data, String name, String... lore)
    {
        ItemStack stack = new ItemStack(material, count, (byte) data);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        stack.setItemMeta(meta);
        return stack;
    }
}