package hugo.lol.entity.inventory.equipment;

import hugo.lol.entity.Champion;
import hugo.lol.entity.inventory.equipment.type.EquipmentSlot;
import hugo.lol.entity.item.equipment.EquipmentItem;

import java.util.EnumMap;
import java.util.Map;

public class EquipmentSlots {

    private final Map<EquipmentSlot, EquipmentItem> slots;

    public EquipmentSlots() {
        this.slots = new EnumMap<>(EquipmentSlot.class);
    }

    public boolean equip(EquipmentSlot slot, EquipmentItem item, Champion champion) {
        if (!isSlotFree(slot)) return false;
        slots.put(slot, item);
        item.applyEffect(champion);
        System.out.println(champion.getName() + " equipped " + item.getName() + " in " + slot);
        return true;
    }

    public EquipmentItem unequip(EquipmentSlot slot) {
        return slots.remove(slot);
    }

    public EquipmentItem getEquipped(EquipmentSlot slot) {
        return slots.get(slot);
    }

    public boolean isSlotFree(EquipmentSlot slot) {
        return !slots.containsKey(slot);
    }

    public void print() {
        System.out.println("=== Equipment ===");
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            EquipmentItem item = slots.get(slot);
            System.out.println(slot + ": " + (item == null ? "empty" : item));
        }
    }
}