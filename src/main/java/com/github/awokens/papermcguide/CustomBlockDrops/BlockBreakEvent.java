package com.github.awokens.papermcguide.CustomBlockDrops;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class BlockBreakEvent implements Listener {

    private final SimpleCustomBlockDrops customBlockDrops;

    public BlockBreakEvent() {
        this.customBlockDrops = new SimpleCustomBlockDrops();
        this.customBlockDrops.addCustomBlockDrop(new SimpleCustomBlockDrops.CustomBlockDrop(
                Material.STONE,
                new ItemStack(Material.IRON_NUGGET)
        ));
    }


    @EventHandler
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
        Block block = event.getBlock();

        if (!customBlockDrops.isCustomBlockDrop(block.getType())) return;

        SimpleCustomBlockDrops.CustomBlockDrop customBlockDrop = customBlockDrops.getCustomBlockDrop(block.getType());
        event.setDropItems(false);

        block.getDrops().clear();
        block.getDrops().add(customBlockDrop.drop());

    }
}
