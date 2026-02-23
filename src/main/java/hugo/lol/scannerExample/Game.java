package hugo.lol.scannerExample;

import hugo.lol.entity.Champion;
import hugo.lol.entity.assasin.Assassin;
import hugo.lol.entity.healer.Healer;
import hugo.lol.entity.mage.Mage;
import hugo.lol.entity.tank.Tank;
import hugo.lol.entity.interfaces.HealerChampion;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Champion> champions = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║   LEAGUE CHAMPION MANAGER v1.0   ║");
        System.out.println("╚══════════════════════════════════╝");

        boolean exit = false;
        while (!exit) {
            showMenu();
            int option = readInt();

            switch (option) {
                case 1 -> createChampion();
                case 2 -> listChampions();
                case 3 -> showChampionStats();
                case 4 -> simulateFight();
                case 5 -> levelUpChampion();
                case 6 -> healAction();
                case 0 -> exit = true;
                default -> System.out.println("Invalid option, try again.\n");
            }
        }

        System.out.println("Goodbye");
        scanner.close();
    }

    // ─── MENU ────────────────────────────────────────────────────────────────

    private void showMenu() {
        System.out.println("\n┌──────────────────────────────┐");
        System.out.println("│          MAIN MENU           │");
        System.out.println("├──────────────────────────────┤");
        System.out.println("│  1. Create Champion          │");
        System.out.println("│  2. List Champions           │");
        System.out.println("│  3. Show Champion Stats      │");
        System.out.println("│  4. Simulate Combat          │");
        System.out.println("│  5. Level Up Champion        │");
        System.out.println("│  6. Heal Champion            │");
        System.out.println("│  0. Exit                     │");
        System.out.println("└──────────────────────────────┘");
        System.out.print("Choose an option: ");
    }

    // Menu

    private void createChampion() {
        System.out.println("\n=== CREATE CHAMPION ===");
        System.out.println("1. Mage     (HP:500 | DMG:60  | Mana:300)");
        System.out.println("2. Assassin (HP:600 | DMG:80  | Crit:20)");
        System.out.println("3. Tank     (HP:1000| DMG:40  | Armor:50)");
        System.out.println("4. Healer   (HP:700 | Heal:150| Mana:300)");
        System.out.print("Choose type: ");

        int type = readInt();
        System.out.print("Enter champion name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        Champion champion = switch (type) {
            case 1 -> new Mage(name, "Mage", 500, 60, 300);
            case 2 -> new Assassin(name, "Assassin", 600, 80);
            case 3 -> new Tank(name, "Tank", 1000, 40);
            case 4 -> new Healer(name, "Healer", 700, 300, 150);
            default -> null;
        };

        if (champion != null) {
            champions.add(champion);
            System.out.println("Champion '" + champion.getName() + "' created! ("
                    + champions.size() + " total)");
        } else {
            System.out.println("Invalid champ.");
        }
    }

    //list champ

    private void listChampions() {
        if (champions.isEmpty()) {
            System.out.println("\nNo champions created yet.");
            return;
        }
        System.out.println("\n=== CHAMPION ROSTER (" + champions.size() + ") ===");
        for (int i = 0; i < champions.size(); i++) {
            Champion c = champions.get(i);
            String status = c.getHealth() > 0 ? "Alive" : "Dead";
            System.out.printf("  %d. %s %-14s | %-10s | Lv.%d | HP: %d/%d%n",
                    i + 1, status, c.getName(), c.getRole(),
                    c.getLevel(), c.getHealth(), c.getMaxHealth());
        }
    }

    // stats

    private void showChampionStats() {
        if (champions.isEmpty()) {
            System.out.println("\nNo champions available.");
            return;
        }
        listChampions();
        System.out.print("\nSelect champion number: ");
        int index = readInt() - 1;

        if (!isValidIndex(index)) {
            System.out.println("Invalid selection.");
            return;
        }

        Champion c = champions.get(index);
        System.out.println("\n══════════════════════════════");
        System.out.printf("  %s — %s%n", c.getName().toUpperCase(), c.getRole());
        System.out.println("══════════════════════════════");
        System.out.println("  Level   : " + c.getLevel());
        System.out.println("  Health  : " + c.getHealth() + "/" + c.getMaxHealth());
        System.out.println("  Damage  : " + c.getDamage());

        // Class-specific stats
        switch (c) {
            case Mage mage -> System.out.println("  Mana    : " + mage.getMana());
            case Assassin assassin -> System.out.println("  Critical: " + assassin.getCritical());
            case Tank tank -> System.out.println("  Armor   : " + tank.getArmor());
            case Healer healer -> {
                System.out.println("  HealPwr : " + healer.getHealPower());
                System.out.println("  Mana    : " + healer.getMana());
            }
            default -> {
            }
        }
        System.out.println("══════════════════════════════");
    }

    // fight

    private void simulateFight() {
        if (champions.size() < 2) {
            System.out.println("\n You need at least 2 champions to fight.");
            return;
        }

        listChampions();
        System.out.print("\nSelect attacker: ");
        int idx1 = readInt() - 1;
        System.out.print("Select defender: ");
        int idx2 = readInt() - 1;

        if (!isValidIndex(idx1) || !isValidIndex(idx2) || idx1 == idx2) {
            System.out.println("Invalid selection.");
            return;
        }

        Champion attacker = champions.get(idx1);
        Champion defender = champions.get(idx2);

        System.out.println("\n"+ attacker.getName() + " VS " + defender.getName());
        System.out.println("──────────────────────────────────────");

        //basic attack
        System.out.println("\n[Round 1 - Basic Attack]");
        attacker.receiveDamage(defender.getDamage());
        if (attacker.getHealth() > 0) {
            defender.receiveDamage(attacker.getDamage());
        }

        // special ability
        if (attacker.getHealth() > 0 && defender.getHealth() > 0) {
            System.out.println("\n[Round 2 - Special Ability]");
            attacker.specialAbility(defender);
            if (defender.getHealth() > 0) {
                defender.specialAbility(attacker);
            }
        }

        // resul
        System.out.println("\n─── RESULT ───");
        if (attacker.getHealth() <= 0 && defender.getHealth() <= 0) {
            System.out.println("Draw! Both champions fell.");
        } else if (attacker.getHealth() <= 0) {
            System.out.println(defender.getName() + " wins!");
        } else if (defender.getHealth() <= 0) {
            System.out.println(attacker.getName() + " wins!");
        } else {
            System.out.println("Both survived the combat!");
            System.out.printf("  %s → HP: %d/%d%n",
                    attacker.getName(), attacker.getHealth(), attacker.getMaxHealth());
            System.out.printf("  %s → HP: %d/%d%n",
                    defender.getName(), defender.getHealth(), defender.getMaxHealth());
        }
    }

    // levelup

    private void levelUpChampion() {
        if (champions.isEmpty()) {
            System.out.println("\nNo champions available.");
            return;
        }
        listChampions();
        System.out.print("\nSelect champion to level up: ");
        int index = readInt() - 1;

        if (isValidIndex(index)) {
            champions.get(index).levelUp();
        } else {
            System.out.println("Invalid selection.");
        }
    }

    // heal

    private void healAction() {
        if (champions.isEmpty()) {
            System.out.println("\nNo champions available.");
            return;
        }

        ArrayList<Integer> healers = new ArrayList<>();
        for (int i = 0; i < champions.size(); i++) {
            if (champions.get(i) instanceof HealerChampion) {
                healers.add(i);
            }
        }

        if (healers.isEmpty()) {
            System.out.println("\n No champions with healing ability in your roster.");
            return;
        }

        System.out.println("\n=== CHAMPIONS THAT CAN HEAL ===");
        for (int idx : healers) {
            Champion c = champions.get(idx);
            System.out.printf("  %d. %-14s (%s)%n", idx + 1, c.getName(), c.getRole());
        }
        System.out.print("Select healer: ");
        int healerIdx = readInt() - 1;

        if (!isValidIndex(healerIdx) || !(champions.get(healerIdx) instanceof HealerChampion healer)) {
            System.out.println("That champion cannot heal.");
            return;
        }

        listChampions();
        System.out.print("Select target to heal: ");
        int targetIdx = readInt() - 1;

        if (!isValidIndex(targetIdx)) {
            System.out.println("Invalid selection.");
            return;
        }

        healer.heal(champions.get(targetIdx));
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < champions.size();
    }
}
