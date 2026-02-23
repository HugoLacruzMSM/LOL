package hugo.lol.service;

import hugo.lol.entity.Champion;
import hugo.lol.entity.assasin.Assassin;
import hugo.lol.entity.healer.Healer;
import hugo.lol.entity.mage.Mage;
import hugo.lol.entity.tank.Tank;

import java.util.List;
import java.util.Scanner;

public class UserInteractionService {

    private final Scanner scanner;

    public UserInteractionService() {
        this.scanner = new Scanner(System.in);
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

    public int showChampionTypeMenu() {
        System.out.println("\n--- Create Champion ---");
        System.out.println("1. Mage (HP:500 | DMG:60 | Mana:300)");
        System.out.println("2. Assassin (HP:600 | DMG:80 | Crit:20)");
        System.out.println("3. Tank (HP:1000 | DMG:40 | Armor:50)");
        System.out.println("4. Healer (HP:700 | Heal:150 | Mana:300)");
        System.out.print("Type: ");
        return readInt();
    }

    public String askName() {
        System.out.print("Name: ");
        return scanner.nextLine().trim();
    }

    public void listChampions(List<Champion> champions) {
        if (champions.isEmpty()) {
            System.out.println("\nNo champions yet.");
            return;
        }
        System.out.println("\n--- Champions (" + champions.size() + ") ---");
        for (int i = 0; i < champions.size(); i++) {
            Champion c = champions.get(i);
            System.out.printf("%d. %s - Lv%d - HP:%d/%d%n",
                    i + 1, c.getName(),
                    c.getLevel(), c.getHealth(), c.getMaxHealth());
        }
    }

    public void showStats(Champion c) {
        System.out.println("\n--- " + c.getName() + " ---");
        System.out.println("Level: " + c.getLevel());
        System.out.println("HP: " + c.getHealth() + "/" + c.getMaxHealth());
        System.out.println("Damage: " + c.getDamage());

        switch (c) {
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

    public int selectChampion(String prompt) {
        System.out.print(prompt + ": ");
        return readInt() - 1;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    //TODO Eliminar esto y hacer manejo de excepciones
    public void showError(String error) {
        System.out.println("Error: " + error);
    }

    public void showCombatHeader(Champion c1, Champion c2) {
        System.out.println("\n=== " + c1.getName() + " VS " + c2.getName() + " ===");
    }

    public void showRound(int round, String description) {
        System.out.println("\n[Round " + round + " - " + description + "]");
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
}
