package top.szzz666.nukkit_plugin.panel.esay_chest_menu;

import cn.nukkit.item.Item;

public class CMUtil {
    public static Item Button(String sitem, String text, String lore) {
        Item item = getItem(sitem);
        return Button(item, text, lore);
    }


    public static Item Button(Item item, String text, String lore) {
        item.setCustomName("§r" + text + "§r");
        item.setLore("§r" + lore + "§r");
        return item;
    }

    public static Item Button(Item item, String text) {
        item.setCustomName("§r" + text + "§r");
        return item;
    }

    public static Item Button(String sitem, String text) {
        Item item = getItem(sitem);
        item.setCustomName("§r" + text + "§r");
        return item;
    }

    public static Item getItem(String s) {
        String[] parts = s.split(":");
        try {
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            switch (nums.length) {
                case 1:
                    return Item.get(nums[0]);
                case 2:
                    return Item.get(nums[0], nums[1]);
                case 3:
                    return Item.get(nums[0], nums[1], nums[2]);
            }
        } catch (NumberFormatException e) {
            return Item.fromString(s);
        }
        return Item.AIR_ITEM;
    }
}
