package hugo.lol.entity.inventory;

import hugo.lol.entity.Champion;
import hugo.lol.entity.inventory.equipment.type.EquipmentSlot;
import hugo.lol.entity.inventory.equipment.EquipmentSlots;
import hugo.lol.entity.inventory.grid.InventoryGrid;
import hugo.lol.entity.item.Item;
import hugo.lol.entity.item.consumable.ConsumableItem;
import hugo.lol.entity.item.equipment.EquipmentItem;

public class Inventory {

    private final InventoryGrid grid;
    private final EquipmentSlots equipmentSlots;
    private final ConsumableBag consumableBag;

    public Inventory(int rows, int cols, int consumableCapacity) {
        this.grid = new InventoryGrid(rows, cols);
        this.equipmentSlots = new EquipmentSlots();
        this.consumableBag = new ConsumableBag(consumableCapacity);
    }

    public boolean storeItem(Item item) {
        return grid.autoPlace(item);
    }

    public boolean equipArmor(EquipmentSlot slot, EquipmentItem equipmentItem, Champion champion) {
        return equipmentSlots.equip(slot, equipmentItem, champion);
    }

    public boolean addConsumable(ConsumableItem consumableItem) {
        return consumableBag.add(consumableItem);
    }

    public boolean useConsumable(int index, Champion champion) {
        return consumableBag.use(index, champion);
    }

    public void print() {
        grid.print();
        equipmentSlots.print();
        consumableBag.print();
    }

    public InventoryGrid getGrid() { return grid; }
    public EquipmentSlots getEquipmentSlots() { return equipmentSlots; }
    public ConsumableBag getConsumableBag() { return consumableBag; }
}