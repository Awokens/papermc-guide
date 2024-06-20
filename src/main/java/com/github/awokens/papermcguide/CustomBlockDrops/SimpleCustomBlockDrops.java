package com.github.awokens.papermcguide.CustomBlockDrops;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SimpleCustomBlockDrops {

    private final List<CustomBlockDrop> customBlockDrops;

    public SimpleCustomBlockDrops() {
        this.customBlockDrops = new ArrayList<>();
    }

    public void addCustomBlockDrop(CustomBlockDrop customBlockDrop) {
        this.customBlockDrops.add(customBlockDrop);
    }

    public boolean isCustomBlockDrop(Material block) {
        return getCustomBlockDrop(block) != null;
    }

    public CustomBlockDrop getCustomBlockDrop(Material blockType) {
        for (CustomBlockDrop customBlockDrop : customBlockDrops) {
            if (customBlockDrop.blockType() == blockType) {
                return customBlockDrop;
            }
        }
        return null;
    }

    public record CustomBlockDrop(Material blockType, ItemStack drop) { }
}
