package hugo.lol.service;

import hugo.lol.entity.Champion;
import hugo.lol.entity.assasin.Assassin;
import hugo.lol.entity.healer.Healer;
import hugo.lol.entity.inventory.equipment.type.EquipmentSlot;
import hugo.lol.entity.mage.Mage;
import hugo.lol.entity.shop.Shop;
import hugo.lol.entity.tank.Tank;
import hugo.lol.exception.InvalidSelectionException;

import javax.naming.InvalidNameException;
import java.util.List;
import java.util.Scanner;

public class ChampionConsoleService {

    private final Scanner scanner;

    public ChampionConsoleService() {
        this.scanner = new Scanner(System.in);
    }

    public int askChampionType() throws InvalidSelectionException {
            System.out.println("\n--- Create Champion ---");
            System.out.println("1. Mage (HP:500 | DMG:60 | Mana:300)");
            System.out.println("2. Assassin (HP:600 | DMG:80 | Crit:20)");
            System.out.println("3. Tank (HP:1000 | DMG:40 | Armor:50)");
            System.out.println("4. Healer (HP:700 | Heal:150 | Mana:300)");
            System.out.print("Type: ");
            int selection = readInt();

            if (selection < 1 || selection > 4) {
                throw new InvalidSelectionException("Invalid selection");
            }
            return selection;
    }

    public String askName() throws InvalidNameException {
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                throw new InvalidNameException("Name is empty");
            }

            return scanner.nextLine().trim();

    }

    public void listChampions(List<Champion> champions) {
        if (champions.isEmpty()) {
            System.out.println("\nNo champions yet.");
            return;
        }

        System.out.println("\n--- Champions (" + champions.size() + ") ---");
/*
%d: (int).
%f: (double, float).
%s: (String).
%c: (char).
%b: (boolean).
%%: %.
* */
        for (int i = 0; i < champions.size(); i++) {
            Champion c = champions.get(i);
            System.out.printf("%d. %s - Lv%d - HP:%d/%d",
                    i + 1, c.getName(),
                    c.getLevel(), c.getHealth(), c.getMaxHealth());
        }
    }

    public int selectChampion(String consoleMessage) {
        System.out.print(consoleMessage + ": ");
        return readInt() - 1;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showCombatHeader(Champion c1, Champion c2) {
        System.out.println("\n=== " + c1.getName() + " VS " + c2.getName() + " ===");
    }

    public void showRound(int round, String description) {
        System.out.println("\n[Round " + round + " - " + description + "]");
    }

    public int showInventoryMenu() {
        System.out.println("\n1. Use consumable");
        System.out.println("2. Equip armor");
        System.out.println("0. Back");
        System.out.print("Option: ");
        return readInt();
    }

    public void showInventory(Champion champion) {
        System.out.println("\n--- " + champion.getName() + " Inventory ---");
        champion.getInventory().print();
    }

    public void showShop(Shop shop) {
        shop.printStock();
    }

    public void showStats(Champion champion) {
        System.out.println("\n--- " + champion.getName() + " ---");
        System.out.println("Level: " + champion.getLevel());
        System.out.println("HP: " + champion.getHealth() + "/" + champion.getMaxHealth());
        System.out.println("Damage: " + champion.getDamage());

        switch (champion) {
            case Mage mage -> System.out.println("Mana: " + mage.getMana());
            case Assassin assassin -> System.out.println("Critical: " + assassin.getCritical());
            case Tank tank -> System.out.println("Armor: " + tank.getArmor());
            case Healer healer -> {
                System.out.println("Heal Power: " + healer.getHealPower());
                System.out.println("Mana: " + healer.getMana());
            }
            default -> {}
        }
    }

    public void showWelcome() {
        System.out.println("\n=== LEAGUE CHAMPION MANAGER ===\n");
    }

    public int showMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Create Champion");
        System.out.println("2. List Champions");
        System.out.println("3. Show Stats");
        System.out.println("4. Simulate Combat");
        System.out.println("5. Level Up");
        System.out.println("6. Heal");
        System.out.println("0. Exit");
        System.out.print("Option: ");
        return readInt();
    }

    public void close() {
        scanner.close();
        System.out.println("Goodbye!");
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public int selectItem(String message) {
        System.out.print(message + ": ");
        return readInt() - 1;
    }

    public EquipmentSlot selectEquipmentSlot() {
        System.out.println("Slots: ");
        EquipmentSlot[] slots = EquipmentSlot.values();
        for (int i = 0; i < slots.length; i++) {
            System.out.println((i + 1) + ". " + slots[i]);
        }
        System.out.print("Slot: ");
        int index = readInt() - 1;
        return slots[index];
    }
}
