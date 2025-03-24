package top.szzz666.nukkit_plugin.panel.esay_chest_menu;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.inventory.InventoryType;
import cn.nukkit.item.Item;
import cn.nukkit.network.protocol.ContainerOpenPacket;
import cn.nukkit.network.protocol.RemoveEntityPacket;
import lombok.Getter;
import lombok.Setter;
import top.szzz666.nukkit_plugin.panel.esay_chest_menu.lib.DoubleChestFakeInventory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BigChestMenu extends DoubleChestFakeInventory {
    private final List<ChestMenu.Button> buttons = new ArrayList<>();
    long id;
    @Getter
    @Setter
    private Runnable close;

    public BigChestMenu(String title) {
        super(null, title);
        this.setName(title);
    }

    public void add(int slot, Item item, Runnable runnable) {
        this.buttons.add(new ChestMenu.Button(slot, item, runnable));
    }

    public void show(Player player) {
        this.id = Entity.entityCount++;
        Map<Integer, Item> itemMap = new LinkedHashMap<>();
        List<Runnable> rs = new ArrayList<>();
        for (ChestMenu.Button button : buttons) {
            itemMap.put(button.slot, button.item);
            rs.add(button.callback);
        }
        this.setContents(itemMap);
        this.setRs(rs);
        player.addWindow(this);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void onSlotChange(int index, Item before, boolean send) {
        super.onSlotChange(index, before, send);
    }

    @Override
    public void onOpen(Player who) {
        super.onOpen(who);
        ContainerOpenPacket pk = new ContainerOpenPacket();
        pk.windowId = who.getWindowId(this);
        pk.entityId = id;
        pk.type = InventoryType.DOUBLE_CHEST.getNetworkType();
        who.dataPacket(pk);
    }

    @Override
    public void onClose(Player who) {
        RemoveEntityPacket pk = new RemoveEntityPacket();
        pk.eid = id;
        who.dataPacket(pk);
        super.onClose(who);
        if (close != null) {
            close.run();
        }
    }
}
