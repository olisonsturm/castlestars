/*
Fluent API
 */
package me.songe.castlestars.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemCreator {

    private String displayName;
    private int amount = 1;
    private Material material;
    private List<String> lore = new ArrayList<>();

    public ItemCreator(Material material) {
        this.material = material;
    }

    public ItemCreator setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ItemCreator setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemCreator setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public ItemCreator setLore(String... string) {
        this.lore = Arrays.asList(string);
        return this;
    }

    public ItemStack build() {
        ItemStack stack = new ItemStack(material);
        stack.setAmount(amount);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
    }

}