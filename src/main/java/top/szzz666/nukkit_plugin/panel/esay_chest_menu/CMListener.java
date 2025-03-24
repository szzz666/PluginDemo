package top.szzz666.nukkit_plugin.panel.esay_chest_menu;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.inventory.InventoryTransactionEvent;
import cn.nukkit.inventory.transaction.action.SlotChangeAction;
import top.szzz666.nukkit_plugin.panel.esay_chest_menu.lib.ChestFakeInventory;

public class CMListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryTransaction(InventoryTransactionEvent event) {
        event.getTransaction().getActions().forEach(action -> {
            if (action instanceof SlotChangeAction) {
                SlotChangeAction slotChange = (SlotChangeAction) action;
                if (slotChange.getInventory() instanceof ChestFakeInventory) {
                    ChestFakeInventory inventory = (ChestFakeInventory) slotChange.getInventory();
                    inventory.setEvent(event);
                    int slot = slotChange.getSlot();
                    inventory.getRs().get(slot).run();
                    event.setCancelled(true);
                }
            }
        });
    }
}
